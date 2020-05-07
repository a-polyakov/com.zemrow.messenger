package com.zemrow.messenger.db.querydsl;

import com.google.common.base.Function;
import com.mysema.codegen.CodeWriter;
import com.mysema.codegen.model.Parameter;
import com.mysema.codegen.model.SimpleType;
import com.mysema.codegen.model.Types;
import com.querydsl.codegen.EntityType;
import com.querydsl.codegen.Property;
import com.querydsl.codegen.Serializer;
import com.querydsl.codegen.SerializerConfig;
import com.querydsl.core.util.BeanUtils;
import com.querydsl.sql.codegen.OrdinalPositionComparator;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Настройка генерации entity
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslEntitySerializer implements Serializer {

    private static final Function<Property, Parameter> propertyToParameter = new Function<Property, Parameter>() {
        @Override
        public Parameter apply(Property input) {
            return new Parameter(input.getName(), input.getType());
        }
    };

    public QueryDslEntitySerializer() {
    }

    @Override
    public void serialize(EntityType model, SerializerConfig serializerConfig,
        CodeWriter writer) throws IOException {
        final String simpleName = model.getSimpleName();
        final ArrayList<Property> properties = getSortProperties(model);
        boolean hasId = false;
        boolean hasCreateTime = false;
        boolean hasCreatedBy = false;
        boolean hasUpdateTime = false;
        boolean hasUpdatedBy = false;
        boolean hasDeleteTime = false;
        boolean hasDeletedBy = false;
        for (Property property : properties) {
            if ("id".equals(property.getEscapedName())) {
                hasId = true;
            }
            if ("createTime".equals(property.getEscapedName())) {
                hasCreateTime = true;
            }
            else if ("createdBy".equals(property.getEscapedName())) {
                hasCreatedBy = true;
            }
            else if ("updateTime".equals(property.getEscapedName())) {
                hasUpdateTime = true;
            }
            else if ("updatedBy".equals(property.getEscapedName())) {
                hasUpdatedBy = true;
            }
            else if ("deleteTime".equals(property.getEscapedName())) {
                hasDeleteTime = true;
            }
            else if ("deletedBy".equals(property.getEscapedName())) {
                hasDeletedBy = true;
            }
        }

        // package
        writer.packageDecl(model.getPackageName());

        // imports
        Set<String> importedClasses = getAnnotationTypes(model);
        if (hasId || hasCreateTime || hasCreatedBy || hasUpdateTime || hasUpdatedBy || hasDeleteTime || hasDeletedBy) {
            importedClasses.add("com.zemrow.messenger.SessionStorage");
        }
        addImportFromProperties(properties, importedClasses);
        if (model.hasLists()) {
            importedClasses.add(List.class.getName());
        }
        if (model.hasCollections()) {
            importedClasses.add(Collection.class.getName());
        }
        if (model.hasSets()) {
            importedClasses.add(Set.class.getName());
        }
        if (model.hasMaps()) {
            importedClasses.add(Map.class.getName());
        }
        if (!importedClasses.isEmpty()) {
            writer.importClasses(importedClasses.toArray(new String[importedClasses.size()]));
        }

        // javadoc
        final String tableRemarks = (String)model.getData().get(QueryDslMetaDataExporter.REMARKS);
        writer.javadoc("Класс сгенерирован автоматически, для таблицы " + simpleName + (tableRemarks != null ? "(" + tableRemarks + ")" : "") + " из БД"
            , ""
            , "@author " + getClass().getName() + " on " + QueryDslMetaDataExporter.DATE_FORMAT.format(new Date()));

        // header
        for (Annotation annotation : model.getAnnotations()) {
            writer.annotation(annotation);
        }

        // todo implement
        if (hasId) {
            writer.beginClass(model, new SimpleType("AbstractEntityWithId"));
        }
        else {
            writer.beginClass(model, new SimpleType("AbstractEntity"));
        }

        // fields
        for (Property property : properties) {
            final String propertyName = property.getEscapedName();
            if (!"id".equals(propertyName)) {
                final String remarks = (String)property.getData().get(QueryDslMetaDataExporter.REMARKS);
                if (remarks != null) {
                    writer.javadoc(remarks);
                }
                writer.privateField(property.getType(), propertyName);
            }
        }

        // empty constructor, constructor by all fields
        addConstructor(model, writer);

        // preInsert, preUpdate, preDelete
        addPreMethod(model, writer,
            hasId,
            hasCreateTime,
            hasCreatedBy,
            hasUpdateTime,
            hasUpdatedBy,
            hasDeleteTime,
            hasDeletedBy);

        // accessors
        for (Property property : properties) {
            String propertyName = property.getEscapedName();
            if (!"id".equals(propertyName)) {
                String remarks = (String)property.getData().get(QueryDslMetaDataExporter.REMARKS);
                // getter
                if (remarks != null) {
                    remarks = remarks.toLowerCase();
                    writer.javadoc("Получение " + remarks);
                }
                writer.beginPublicMethod(property.getType(), "get" + BeanUtils.capitalize(propertyName));
                writer.line("return ", propertyName, ";");
                writer.end();
                // setter
                if (remarks != null) {
                    writer.javadoc("Установить " + remarks);
                }
                Parameter parameter = new Parameter(propertyName, property.getType());
                writer.beginPublicMethod(Types.VOID, "set" + BeanUtils.capitalize(propertyName), parameter);
                writer.line("this.", propertyName, " = ", propertyName, ";");
                writer.end();
            }
        }

        addToString(model, writer);

        writer.end();
    }

    public static void addImportFromProperties(Collection<Property> properties, Set<String> importedClasses) {
        for (Property property : properties) {
            if (Enum.class.isAssignableFrom(property.getType().getJavaClass())) {
                importedClasses.add(property.getType().getFullName());
            }
        }
    }

    private void addPreMethod(EntityType model, CodeWriter writer,
        boolean hasId,
        boolean hasCreateTime,
        boolean hasCreatedBy,
        boolean hasUpdateTime,
        boolean hasUpdatedBy,
        boolean hasDeleteTime,
        boolean hasDeletedBy) throws IOException {

        final Parameter parameterSessionStorage = new Parameter("session", new SimpleType("SessionStorage"));

        // TODO validation not null, size

        // preInsert
        if (hasId || hasCreateTime || hasCreatedBy || hasUpdateTime || hasUpdatedBy) {
            writer.line("@Override");
            writer.beginPublicMethod(new SimpleType("void"), "preInsert", parameterSessionStorage);
            if (hasId) {
                //TODO
//                writer.line("if (id == null) {");
//                writer.line("    id = UUID.randomUUID().getMostSignificantBits();");
//                writer.line("}");
            }
            if (hasCreateTime) {
                writer.line("if (createTime == null) {");
                writer.line("    createTime = System.currentTimeMillis();");
                writer.line("}");
            }
            if (hasCreatedBy) {
                writer.line("if (createdBy == null) {");
                writer.line("    createdBy = session.getUserId();");
                writer.line("}");
            }
            addSetUpdateTime(writer, hasUpdateTime);
            addSetUpdatedBy(writer, hasUpdatedBy);
            writer.end();
        }

        // preUpdate
        if (hasUpdateTime || hasUpdatedBy) {
            writer.line("@Override");
            writer.beginPublicMethod(new SimpleType("void"), "preUpdate", parameterSessionStorage);
            addSetUpdateTime(writer, hasUpdateTime);
            addSetUpdatedBy(writer, hasUpdatedBy);
            writer.end();
        }

        // preDelete
        if (hasDeleteTime || hasDeletedBy) {
            writer.line("@Override");
            writer.beginPublicMethod(new SimpleType("void"), "preDelete", parameterSessionStorage);
            if (hasDeleteTime) {
                writer.line("if (deleteTime == null) {");
                writer.line("    deleteTime = System.currentTimeMillis();");
                writer.line("}");
            }
            if (hasDeletedBy) {
                writer.line("if (deletedBy == null) {");
                writer.line("    deletedBy = session.getUserId();");
                writer.line("}");
            }

            writer.end();
        }
    }

    private void addSetUpdateTime(CodeWriter writer, boolean hasUpdateTime) throws IOException {
        if (hasUpdateTime) {
            writer.line("updateTime = System.currentTimeMillis();");
        }
    }

    private void addSetUpdatedBy(CodeWriter writer, boolean hasUpdatedBy) throws IOException {
        if (hasUpdatedBy) {
            writer.line("updatedBy = session.getUserId();");
        }
    }

    //TODO
    private Set<String> getAnnotationTypes(EntityType model) {
        Set<String> imports = new HashSet<String>();
        for (Annotation annotation : model.getAnnotations()) {
            imports.add(annotation.annotationType().getName());
        }
        return imports;
    }

    private void addConstructor(EntityType model, CodeWriter writer) throws IOException {
        final String tableRemarks = (String)model.getData().get(QueryDslMetaDataExporter.REMARKS);
        // public empty constructor
        if (tableRemarks != null) {
            writer.javadoc("Создать " + tableRemarks);
        }
        writer.beginConstructor();
        writer.end();

        // full constructor
        final ArrayList<Property> sortProperties = getSortProperties(model);
        if (tableRemarks != null) {
            final List<String> javadoc = new ArrayList<>();
            javadoc.add("Создать " + tableRemarks);
            for (Property property : sortProperties) {
                javadoc.add("@param " + property.getName() + " " + property.getData().get(QueryDslMetaDataExporter.REMARKS));
            }
            writer.javadoc(javadoc.toArray(new String[javadoc.size()]));
        }
        writer.beginConstructor(sortProperties, propertyToParameter);
        for (Property property : sortProperties) {
            writer.line("this.", property.getEscapedName(), " = ", property.getEscapedName(), ";");
        }
        writer.end();
    }

    public static ArrayList<Property> getSortProperties(EntityType model) {
        final ArrayList<Property> list = new ArrayList(model.getProperties());
        list.sort(new OrdinalPositionComparator());
        return list;
    }

    protected void addToString(EntityType model, CodeWriter writer) throws IOException {
        writer.line("@Override");
        writer.beginPublicMethod(Types.STRING, "toString");
        writer.line("final StringBuilder result=new StringBuilder(\"{class = \\\"" + model.getFullName() + "\\\"\");");
        for (Property property : getSortProperties(model)) {
            String propertyName = property.getEscapedName();
            writer.line("if (" + propertyName + " != null) {");
            writer.line("    result.append(\", " + propertyName + " = \\\"\").append(" + propertyName + ")" + ".append('\"');");
            writer.line("}");
        }
        writer.line("result.append('}');");
        writer.line("return result.toString();");
        writer.end();
    }
}
