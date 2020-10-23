package com.zemrow.messenger.db.querydsl;

import com.google.common.collect.Sets;
import com.mysema.codegen.CodeWriter;
import com.mysema.codegen.model.*;
import com.querydsl.codegen.*;
import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.ColumnMetadata;
import com.querydsl.sql.codegen.MetaDataSerializer;
import com.querydsl.sql.codegen.NamingStrategy;
import com.querydsl.sql.codegen.SQLCodegenModule;
import com.querydsl.sql.codegen.support.ForeignKeyData;
import com.querydsl.sql.codegen.support.InverseForeignKeyData;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

import static com.mysema.codegen.Symbols.*;

/**
 * Настройка генерации констант
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslMetaDataSerializer extends MetaDataSerializer {

    private static final Map<Integer, String> typeConstants = new HashMap<>();

    static {
        try {
            for (Field field : java.sql.Types.class.getDeclaredFields()) {
                if (field.getType().equals(Integer.TYPE)) {
                    typeConstants.put(field.getInt(null), field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }

    }

    //TODO
    private final Class<?> entityPathType;

    /**
     * Create a new {@code MetaDataSerializer} instance
     *
     * @param typeMappings
     * @param namingStrategy      naming strategy for table to class and column to property conversion
     * @param innerClassesForKeys wrap key properties into inner classes (default: false)
     * @param imports             java user imports
     * @param columnComparator
     * @param entityPathType
     */
    @Inject
    public QueryDslMetaDataSerializer(TypeMappings typeMappings,
                                      NamingStrategy namingStrategy,
                                      @Named(SQLCodegenModule.INNER_CLASSES_FOR_KEYS) boolean innerClassesForKeys,
                                      @Named(SQLCodegenModule.IMPORTS) Set<String> imports,
                                      @Named(SQLCodegenModule.COLUMN_COMPARATOR) Comparator<Property> columnComparator,
                                      @Named(SQLCodegenModule.ENTITYPATH_TYPE) Class<?> entityPathType) {
        super(typeMappings, namingStrategy, innerClassesForKeys, imports, columnComparator, entityPathType);
        this.entityPathType = entityPathType;
    }

    protected void introImports(CodeWriter writer, SerializerConfig config,
                                EntityType model) throws IOException {
        writer.staticimports(PathMetadataFactory.class);

        // import package of query type
        Type queryType = typeMappings.getPathType(model, model, true);
        if (!model.getPackageName().isEmpty()
                && !queryType.getPackageName().equals(model.getPackageName())
                && !queryType.getSimpleName().equals(model.getSimpleName())) {
            String fullName = model.getFullName();
            String packageName = model.getPackageName();
            if (fullName.substring(packageName.length() + 1).contains(".")) {
                fullName = fullName.substring(0, fullName.lastIndexOf('.'));
            }
            writer.importClasses(fullName);
        }

        // delegate packages
        introDelegatePackages(writer, model);

        // other packages
        writer.imports(SimpleExpression.class.getPackage());

        // other classes
        Set<String> classes = new HashSet<>();
        classes.add(PathMetadata.class.getCanonicalName());

        if (!model.getConstructors().isEmpty()) {
            classes.add(ConstructorExpression.class.getCanonicalName());
            classes.add(Projections.class.getCanonicalName());
            classes.add(Expression.class.getCanonicalName());
        }
        boolean inits = false;
        if (model.hasEntityFields() || model.hasInits()) {
            inits = true;
        } else {
            Set<TypeCategory> collections = Sets.newHashSet(TypeCategory.COLLECTION, TypeCategory.LIST, TypeCategory.SET);
            for (Property property : model.getProperties()) {
                if (!property.isInherited() && collections.contains(property.getType().getCategory())) {
                    inits = true;
                    break;
                }
            }
        }
        if (inits) {
            classes.add(PathInits.class.getCanonicalName());
        }
        QueryDslEntitySerializer.addImportFromProperties(model.getProperties(), classes);
        writer.importClasses(classes.toArray(new String[classes.size()]));

        Collection<ForeignKeyData> foreignKeys = (Collection<ForeignKeyData>)
                model.getData().get(ForeignKeyData.class);
        Collection<InverseForeignKeyData> inverseForeignKeys = (Collection<InverseForeignKeyData>)
                model.getData().get(InverseForeignKeyData.class);
        boolean addJavaUtilImport = false;
        if (foreignKeys != null) {
            for (ForeignKeyData keyData : foreignKeys) {
                if (keyData.getForeignColumns().size() > 1) {
                    addJavaUtilImport = true;
                }
            }
        }
        if (inverseForeignKeys != null) {
            for (InverseForeignKeyData keyData : inverseForeignKeys) {
                if (keyData.getForeignColumns().size() > 1) {
                    addJavaUtilImport = true;
                }
            }
        }

        if (addJavaUtilImport) {
            writer.imports(List.class.getPackage());
        }

        writer.imports(ColumnMetadata.class, java.sql.Types.class);

        if (!entityPathType.getPackage().equals(ColumnMetadata.class.getPackage())) {
            writer.imports(entityPathType);
        }

        writeUserImports(writer);
    }

    @Override
    protected void introJavadoc(CodeWriter writer, EntityType model) throws IOException {
        final String simpleName = model.getSimpleName();
        final String tableRemarks = (String) model.getData().get(QueryDslMetaDataExporter.REMARKS);
        writer.javadoc("Класс сгенерирован автоматически, для таблицы " + simpleName + (tableRemarks != null ? "(" + tableRemarks + ")" : "") + " из БД"
                , ""
                , "@author " + getClass().getName() + " on " + QueryDslMetaDataExporter.DATE_FORMAT.format(new Date()));
    }

    @Override
    protected void introClassHeader(CodeWriter writer, EntityType model) throws IOException {
        Type queryType = typeMappings.getPathType(model, model, true);

        TypeCategory category = model.getOriginalCategory();
        // serialize annotations only, if no bean types are used
        if (model.equals(queryType)) {
            for (Annotation annotation : model.getAnnotations()) {
                writer.annotation(annotation);
            }
        }
        writer.beginClass(queryType, new ClassType(category, entityPathType, model));
        writer.privateStaticFinal(Types.LONG_P, "serialVersionUID", String.valueOf(model.hashCode()));
    }

    @Override
    protected void introDefaultInstance(CodeWriter writer, EntityType model, String defaultName) throws IOException {
        final String tableRemarks = (String) model.getData().get(QueryDslMetaDataExporter.REMARKS);
        if (tableRemarks != null) {
            writer.javadoc(tableRemarks);
        }
        super.introDefaultInstance(writer, model, defaultName);
    }

    protected void serializeProperties(EntityType model, SerializerConfig config,
                                       CodeWriter writer) throws IOException {
        for (Property property : QueryDslEntitySerializer.getSortProperties(model)) {
            final String remarks = (String) property.getData().get(QueryDslMetaDataExporter.REMARKS);
            if (remarks != null) {
                writer.javadoc(remarks);
            }

            String name = property.getName();
            StringBuilder nameConstant = new StringBuilder(String.valueOf(Character.toUpperCase(name.charAt(0))));
            for (int i = 1; i < name.length(); i++) {
                char c = name.charAt(i);
                if (Character.isUpperCase(c)) {
                    nameConstant.append('_');
                } else {
                    c = Character.toUpperCase(c);
                }
                nameConstant.append(c);
            }
            property.getData().put("nameConstant", nameConstant.toString());
            writer.line("public static final String ", nameConstant.toString(),
                    ASSIGN, QUOTE, name, QUOTE, SEMICOLON).nl();
        }

        for (Property property : QueryDslEntitySerializer.getSortProperties(model)) {
            // FIXME : the custom types should have the custom type category
            if (typeMappings.isRegistered(property.getType())
                    && property.getType().getCategory() != TypeCategory.CUSTOM
                    && property.getType().getCategory() != TypeCategory.ENTITY) {
                customField(model, property, config, writer);
                continue;
            }

            // strips of "? extends " etc
            Type propertyType = new SimpleType(property.getType(), property.getType().getParameters());
            Type queryType = typeMappings.getPathType(propertyType, model, false);
            String localRawName = writer.getRawName(property.getType());

            switch (property.getType().getCategory()) {
                case STRING:
                    serialize(model, property, queryType, writer, "createString");
                    break;

                case BOOLEAN:
                    serialize(model, property, queryType, writer, "createBoolean");
                    break;

                case SIMPLE:
                    serialize(model, property, queryType, writer, "createSimple", writer.getClassConstant(localRawName));
                    break;

                case COMPARABLE:
                    serialize(model, property, queryType, writer, "createComparable", writer.getClassConstant(localRawName));
                    break;

                case ENUM:
                    serialize(model, property, queryType, writer, "createEnum", writer.getClassConstant(localRawName));
                    break;

                case DATE:
                    serialize(model, property, queryType, writer, "createDate", writer.getClassConstant(localRawName));
                    break;

                case DATETIME:
                    serialize(model, property, queryType, writer, "createDateTime", writer.getClassConstant(localRawName));
                    break;

                case TIME:
                    serialize(model, property, queryType, writer, "createTime", writer.getClassConstant(localRawName));
                    break;

                case NUMERIC:
                    serialize(model, property, queryType, writer, "createNumber", writer.getClassConstant(localRawName));
                    break;

                case CUSTOM:
                    customField(model, property, config, writer);
                    break;

                case ENTITY:
                    entityField(model, property, config, writer);
                    break;
            }
        }
    }

    @Override
    protected void serialize(EntityType model, Property field, Type type, CodeWriter writer,
                             String factoryMethod, String... args) throws IOException {
        final String remarks = (String) field.getData().get(QueryDslMetaDataExporter.REMARKS);
        if (remarks != null) {
            writer.javadoc(remarks);
        }
        Supertype superType = model.getSuperType();
        StringBuilder value = new StringBuilder();
        if (field.isInherited() && superType != null) {
            if (!superType.getEntityType().hasEntityFields()) {
                value.append("_super." + field.getEscapedName());
            }
        } else {
            String nameConstant = (String) field.getData().get("nameConstant");
            value.append(factoryMethod + "(" + nameConstant);
            String[] var9 = args;
            int var10 = args.length;

            for (int var11 = 0; var11 < var10; ++var11) {
                String arg = var9[var11];
                value.append(", " + arg);
            }

            value.append(")");
        }

        if (field.isInherited()) {
            writer.line(new String[]{"//inherited"});
        }

        if (value.length() > 0) {
            writer.publicFinal(type, field.getEscapedName(), value.toString());
        } else {
            writer.publicFinal(type, field.getEscapedName());
        }

    }

    @Override
    protected void constructorsForVariables(CodeWriter writer, EntityType model) throws IOException {
        String localName = writer.getRawName(model);
        String genericName = writer.getGenericName(true, model);

        boolean stringOrBoolean = model.getOriginalCategory() == TypeCategory.STRING
                || model.getOriginalCategory() == TypeCategory.BOOLEAN;
//        boolean hasEntityFields = model.hasEntityFields() || superTypeHasEntityFields(model);
        boolean hasEntityFields = false;
//        String thisOrSuper = hasEntityFields ? THIS : SUPER;
        String thisOrSuper = SUPER;
        String additionalParams = hasEntityFields ? "" : getAdditionalConstructorParameter(model);

//        if (!localName.equals(genericName)) {
//            suppressAllWarnings(writer);
//        }
        writer.beginConstructor(new Parameter("variable", Types.STRING));
        if (stringOrBoolean) {
            writer.line(thisOrSuper, "(forVariable(variable)", additionalParams, ");");
        } else {
            writer.line(thisOrSuper, "(", localName.equals(genericName) ? EMPTY : "(Class) ",
                    writer.getClassConstant(localName) + COMMA + "forVariable(variable)", hasEntityFields ? ", INITS" : EMPTY,
                    additionalParams, ");");
        }
        if (!hasEntityFields) {
            constructorContent(writer, model);
        }
        writer.end();
    }

    @Override
    protected void outro(EntityType model, CodeWriter writer) throws IOException {
        writer.beginPublicMethod(Types.VOID,"addMetadata");
        for (Property property : QueryDslEntitySerializer.getSortProperties(model)) {
            String name = property.getEscapedName();
            ColumnMetadata metadata = (ColumnMetadata) property.getData().get("COLUMN");
            StringBuilder columnMeta = new StringBuilder();
            columnMeta.append("ColumnMetadata");
            String nameConstant = (String) property.getData().get("nameConstant");

            columnMeta.append(".named(" + nameConstant + ")");
            columnMeta.append(".withIndex(" + metadata.getIndex() + ")");
            if (metadata.hasJdbcType()) {
                String type = String.valueOf(metadata.getJdbcType());
                if (typeConstants.containsKey(metadata.getJdbcType())) {
                    type = "Types." + typeConstants.get(metadata.getJdbcType());
                }
                columnMeta.append(".ofType(" + type + ")");
            }
            if (metadata.hasSize()) {
                columnMeta.append(".withSize(" + metadata.getSize() + ")");
            }
            if (metadata.getDigits() > 0) {
                columnMeta.append(".withDigits(" + metadata.getDigits() + ")");
            }
            if (!metadata.isNullable()) {
                columnMeta.append(".notNull()");
            }
            writer.line("addMetadata(", name, ", ", columnMeta.toString(), ");");
        }
        writer.end();

        writer.end();
    }
}
