package com.zemrow.messenger.db.querydsl;

import com.google.common.base.Function;
import com.google.common.io.Files;
import com.mysema.codegen.CodeWriter;
import com.mysema.codegen.JavaWriter;
import com.mysema.codegen.model.ClassType;
import com.mysema.codegen.model.SimpleType;
import com.mysema.codegen.model.Type;
import com.mysema.codegen.model.TypeCategory;
import com.querydsl.codegen.CodegenModule;
import com.querydsl.codegen.EntityType;
import com.querydsl.codegen.Property;
import com.querydsl.codegen.QueryTypeFactory;
import com.querydsl.codegen.Serializer;
import com.querydsl.codegen.SimpleSerializerConfig;
import com.querydsl.codegen.TypeMappings;
import com.querydsl.sql.ColumnMetadata;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.SchemaAndTable;
import com.querydsl.sql.codegen.KeyDataFactory;
import com.querydsl.sql.codegen.NamingStrategy;
import com.querydsl.sql.codegen.SQLCodegenModule;
import com.querydsl.sql.codegen.support.ForeignKeyData;
import com.querydsl.sql.codegen.support.InverseForeignKeyData;
import com.querydsl.sql.codegen.support.PrimaryKeyData;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * Копия MetaDataExporter с добавлением комментариев к полям
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslMetaDataExporter {

    public static final String REMARKS = "remarks";

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");

    private static final Set<String> excludeTable = new HashSet<>();

    static {
        excludeTable.add("databasechangelog");
        excludeTable.add("databasechangeloglock");
    }

    private final SQLCodegenModule module = new SQLCodegenModule();

    /**
     * Список сгенерированых классаов
     */
    private final Set<String> classes = new HashSet<>();

    private File targetFolder;

    private File beansTargetFolder;

    private String beanPackageName;

    @Nullable
    private Serializer beanSerializer;

    private final Map<EntityType, Type> entityToWrapped = new HashMap<>();

    private Serializer serializer;

    private TypeMappings typeMappings;

    private QueryTypeFactory queryTypeFactory;

    private NamingStrategy namingStrategy;

    private Configuration configuration;

    private KeyDataFactory keyDataFactory;

    private boolean schemaToPackage = false;

    private static final String sourceEncoding = "UTF-8";

    private boolean exportTables = true;

    private boolean exportViews = true;

    private boolean exportPrimaryKeys = true;

    private boolean exportForeignKeys = true;

    private boolean exportDirectForeignKeys = true;

    private boolean exportInverseForeignKeys = true;

    public QueryDslMetaDataExporter() {
    }

    protected EntityType createEntityType(SchemaAndTable schemaAndTable,
        final String className) {
        EntityType classModel;

        String beanPackage = normalizePackage(beanPackageName, schemaAndTable);
        String simpleName = module.getBeanPrefix() + className + module.getBeanSuffix();
        Type classTypeModel = new SimpleType(TypeCategory.ENTITY,
            beanPackage + "." + simpleName, beanPackage, simpleName, false, false);
        classModel = new EntityType(classTypeModel, module.get(Function.class, CodegenModule.VARIABLE_NAME_FUNCTION_CLASS));

        Type mappedType = queryTypeFactory.create(classModel);
        entityToWrapped.put(classModel, mappedType);
        typeMappings.register(classModel, mappedType);

        classModel.getData().put("schema", schemaAndTable.getSchema());
        classModel.getData().put("table", schemaAndTable.getTable());
        return classModel;
    }

    private String normalizePackage(String packageName, SchemaAndTable schemaAndTable) {
        String rval = packageName;
        if (schemaToPackage) {
            rval = namingStrategy.getPackage(rval, schemaAndTable);
        }
        return rval;
    }

    protected Property createProperty(EntityType classModel,
        String propertyName, Type typeModel) {
        return new Property(
            classModel,
            propertyName,
            propertyName,
            typeModel,
            Collections.<String>emptyList(),
            false);
    }

    /**
     * Export the tables based on the given database metadata
     *
     * @param md database metadata
     * @throws SQLException
     */
    public void export(DatabaseMetaData md) throws SQLException {
        module.bind(SQLCodegenModule.BEAN_PACKAGE_NAME, beanPackageName);

        classes.clear();
        typeMappings = module.get(TypeMappings.class);
        queryTypeFactory = module.get(QueryTypeFactory.class);
        serializer = module.get(Serializer.class);
        beanSerializer = module.get(Serializer.class, SQLCodegenModule.BEAN_SERIALIZER);
        namingStrategy = module.get(NamingStrategy.class);
        configuration = module.get(Configuration.class);

        keyDataFactory = new KeyDataFactory(namingStrategy, beanPackageName,
            module.getBeanPrefix(), module.getBeanSuffix(), schemaToPackage);

        List<String> types = new ArrayList<String>(2);
        if (exportTables) {
            types.add("TABLE");
        }
        if (exportViews) {
            // TODO имя класса должно содержать View
            types.add("VIEW");
        }
        String[] typesArray = types.toArray(new String[types.size()]);

        final List<EntityType> resultEntityTypeList = new ArrayList<>();
        try (ResultSet tables = md.getTables(null, null, null, typesArray)) {
            while (tables.next()) {
                final EntityType resultEntityType = handleTable(md, tables);
                if (resultEntityType != null) {
                    resultEntityTypeList.add(resultEntityType);
                }
            }
        }

        write(new File(targetFolder + File.separator + module.getPackageName().replace('.', File.separatorChar), "TablesConst.java"), resultEntityTypeList);
    }

    private EntityType handleTable(DatabaseMetaData md, ResultSet tables) throws SQLException {
        String catalog = tables.getString("TABLE_CAT");
        String schema = tables.getString("TABLE_SCHEM");
        String schemaName = tables.getString("TABLE_SCHEM");
        String tableName = tables.getString("TABLE_NAME");
        String remarks = tables.getString(REMARKS);

        if (excludeTable.contains(tableName)) {
            return null;
        }

        SchemaAndTable schemaAndTable = new SchemaAndTable(schemaName, tableName);

        String className = namingStrategy.getClassName(schemaAndTable);
        EntityType classModel = createEntityType(schemaAndTable, className);

        classModel.getData().put(REMARKS, remarks);

        if (exportPrimaryKeys) {
            // collect primary keys
            Map<String, PrimaryKeyData> primaryKeyData = keyDataFactory
                .getPrimaryKeys(md, catalog, schema, tableName);
            if (!primaryKeyData.isEmpty()) {
                classModel.getData().put(PrimaryKeyData.class, primaryKeyData.values());
            }
        }

        if (exportForeignKeys) {
            if (exportDirectForeignKeys) {
                // collect foreign keys
                Map<String, ForeignKeyData> foreignKeyData = keyDataFactory
                    .getImportedKeys(md, catalog, schema, tableName);
                if (!foreignKeyData.isEmpty()) {
                    Collection<ForeignKeyData> foreignKeysToGenerate = new HashSet<ForeignKeyData>();
                    for (ForeignKeyData fkd : foreignKeyData.values()) {
                        if (namingStrategy.shouldGenerateForeignKey(schemaAndTable, fkd)) {
                            foreignKeysToGenerate.add(fkd);
                        }
                    }

                    if (!foreignKeysToGenerate.isEmpty()) {
                        classModel.getData().put(ForeignKeyData.class, foreignKeysToGenerate);
                    }
                }
            }

            if (exportInverseForeignKeys) {
                // collect inverse foreign keys
                Map<String, InverseForeignKeyData> inverseForeignKeyData = keyDataFactory
                    .getExportedKeys(md, catalog, schema, tableName);
                if (!inverseForeignKeyData.isEmpty()) {
                    classModel.getData().put(InverseForeignKeyData.class, inverseForeignKeyData.values());
                }
            }
        }

        // collect columns
        try (ResultSet columns = md.getColumns(catalog, schema, tableName.replace("/", "//"), null)) {
            while (columns.next()) {
                handleColumn(classModel, tableName, columns);
            }
        }

        // serialize model
        serialize(classModel, schemaAndTable);

        System.out.println("Exported " + tableName + " successfully");
        return classModel;
    }

    private void handleColumn(EntityType classModel, String tableName, ResultSet columns) throws SQLException {
        String columnName = columns.getString("COLUMN_NAME");
        String normalizedColumnName = namingStrategy.normalizeColumnName(columnName);
        int columnType = columns.getInt("DATA_TYPE");
        String typeName = columns.getString("TYPE_NAME");
        Number columnSize = (Number)columns.getObject("COLUMN_SIZE");
        Number columnDigits = (Number)columns.getObject("DECIMAL_DIGITS");
        int columnIndex = columns.getInt("ORDINAL_POSITION");
        int nullable = columns.getInt("NULLABLE");
        final String remarks = columns.getString(REMARKS);

        String propertyName = namingStrategy.getPropertyName(normalizedColumnName, classModel);
        Class<?> clazz = configuration.getJavaType(columnType,
            typeName,
            columnSize != null ? columnSize.intValue() : 0,
            columnDigits != null ? columnDigits.intValue() : 0,
            tableName, columnName);
        if (clazz == null) {
            clazz = Object.class;
        }
        TypeCategory fieldType = TypeCategory.get(clazz.getName());
        if (Number.class.isAssignableFrom(clazz)) {
            fieldType = TypeCategory.NUMERIC;
        }
        else if (Enum.class.isAssignableFrom(clazz)) {
            fieldType = TypeCategory.ENUM;
        }
        Type typeModel = new ClassType(fieldType, clazz);
        Property property = createProperty(classModel, propertyName, typeModel);
        ColumnMetadata column = ColumnMetadata.named(normalizedColumnName).ofType(columnType).withIndex(columnIndex);
        if (nullable == DatabaseMetaData.columnNoNulls) {
            column = column.notNull();
        }
        if (columnSize != null) {
            column = column.withSize(columnSize.intValue());
        }
        if (columnDigits != null) {
            column = column.withDigits(columnDigits.intValue());
        }
        property.getData().put("COLUMN", column);

        property.getData().put(REMARKS, remarks);

        classModel.addProperty(property);
    }

    private void serialize(EntityType type, SchemaAndTable schemaAndTable) {
        try {
            String fileSuffix = ".java";

            String packageName = normalizePackage(beanPackageName, schemaAndTable);
            String path = packageName.replace('.', File.separatorChar) + File.separatorChar + type.getSimpleName() + fileSuffix;
            write(beanSerializer, new File(beansTargetFolder, path), type);

            String otherPath = entityToWrapped.get(type).getFullName().replace('.', File.separatorChar) + fileSuffix;
            write(serializer, new File(targetFolder, otherPath), type);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void write(Serializer serializer, File targetFile, EntityType type) throws IOException {
        if (!classes.add(targetFile.getPath())) {
            throw new IllegalStateException("Attempted to write multiple times to " +
                targetFile.getPath() + ", please check your configuration");
        }
        StringWriter w = new StringWriter();
        CodeWriter writer = new JavaWriter(w);
        serializer.serialize(type, SimpleSerializerConfig.DEFAULT, writer);

        // conditional creation
        boolean generate = true;
        byte[] bytes = w.toString().getBytes(sourceEncoding);
        if (targetFile.exists() && targetFile.length() == bytes.length) {
            String str = Files.toString(targetFile, Charset.forName(sourceEncoding));
            if (str.equals(w.toString())) {
                generate = false;
            }
        }
        else {
            targetFile.getParentFile().mkdirs();
        }

        if (generate) {
            Files.write(bytes, targetFile);
        }
    }

    private void write(File targetFile, List<EntityType> tables) {
        if (tables != null && !tables.isEmpty()) {
            try {
                if (!classes.add(targetFile.getPath())) {
                    throw new IllegalStateException("Attempted to write multiple times to " +
                        targetFile.getPath() + ", please check your configuration");
                }
                StringWriter w = new StringWriter();
                CodeWriter writer = new JavaWriter(w);

                writer.packageDecl(module.getPackageName());
                writer.javadoc("Класс сгенерирован автоматически, для БД"
                    , ""
                    , "@author " + getClass().getName() + " on " + DATE_FORMAT.format(new Date()));
                writer.beginClass(new SimpleType("TablesConst"));
                for (EntityType table : tables) {
                    String remarks = (String)table.getData().get(QueryDslMetaDataExporter.REMARKS);
                    if (remarks != null) {
                        writer.javadoc(remarks);
                    }
                    writer.publicStaticFinal(new SimpleType(table.getSimpleName() + "Const"), table.getSimpleName(), table.getSimpleName() + "Const." + table.getSimpleName());
                }
                writer.end();

                byte[] bytes = w.toString().getBytes(sourceEncoding);
                targetFile.getParentFile().mkdirs();

                Files.write(bytes, targetFile);
            }
            catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /**
     * Override the configuration
     *
     * @param configuration override configuration for custom type mappings etc
     */
    public void setConfiguration(Configuration configuration) {
        module.bind(Configuration.class, configuration);
    }

    /**
     * Set the target folder
     *
     * @param targetFolder target source folder to create the sources into (e.g. target/generated-sources/java)
     */
    public void setTargetFolder(File targetFolder) {
        this.targetFolder = targetFolder;
    }

    /**
     * Set the target folder for beans
     *
     * <p>defaults to the targetFolder value</p>
     *
     * @param targetFolder target source folder to create the bean sources into
     */
    public void setBeansTargetFolder(File targetFolder) {
        this.beansTargetFolder = targetFolder;
    }

    /**
     * Set the package name
     *
     * @param packageName package name for sources
     */
    public void setPackageName(String packageName) {
        module.bind(SQLCodegenModule.PACKAGE_NAME, packageName);
    }

    /**
     * Override the bean package name (default: packageName)
     *
     * @param beanPackageName package name for bean sources
     */
    public void setBeanPackageName(@Nullable String beanPackageName) {
        this.beanPackageName = beanPackageName;
    }

    /**
     * Override the name prefix for the classes (default: Q)
     *
     * @param namePrefix name prefix for querydsl-types (default: Q)
     */
    public void setNamePrefix(String namePrefix) {
        module.bind(CodegenModule.PREFIX, namePrefix);
    }

    /**
     * Override the name suffix for the classes (default: "")
     *
     * @param nameSuffix name suffix for querydsl-types (default: "")
     */
    public void setNameSuffix(String nameSuffix) {
        module.bind(CodegenModule.SUFFIX, nameSuffix);
    }

    /**
     * Override the bean prefix for the classes (default: "")
     *
     * @param beanPrefix bean prefix for bean-types (default: "")
     */
    public void setBeanPrefix(String beanPrefix) {
        module.bind(SQLCodegenModule.BEAN_PREFIX, beanPrefix);
    }

    /**
     * Override the bean suffix for the classes (default: "")
     *
     * @param beanSuffix bean suffix for bean-types (default: "")
     */
    public void setBeanSuffix(String beanSuffix) {
        module.bind(SQLCodegenModule.BEAN_SUFFIX, beanSuffix);
    }

    /**
     * Override the NamingStrategy (default: new DefaultNamingStrategy())
     *
     * @param namingStrategy naming strategy to override (default: new DefaultNamingStrategy())
     */
    public void setNamingStrategy(NamingStrategy namingStrategy) {
        module.bind(NamingStrategy.class, namingStrategy);
    }

    /**
     * Set the Bean serializer class to create bean types as well
     *
     * @param beanSerializerClass serializer for JavaBeans (default: null)
     */
    public void setBeanSerializerClass(Class<? extends Serializer> beanSerializerClass) {
        module.bind(SQLCodegenModule.BEAN_SERIALIZER, beanSerializerClass);
    }

    /**
     * Set whether inner classes should be created for keys
     *
     * @param innerClassesForKeys
     */
    public void setInnerClassesForKeys(boolean innerClassesForKeys) {
        module.bind(SQLCodegenModule.INNER_CLASSES_FOR_KEYS, innerClassesForKeys);
    }

    /**
     * Set the column comparator class
     *
     * @param columnComparatorClass
     */
    public void setColumnComparatorClass(Class<? extends Comparator<Property>> columnComparatorClass) {
        module.bind(SQLCodegenModule.COLUMN_COMPARATOR, columnComparatorClass);
    }

    /**
     * Set the serializer class
     *
     * @param serializerClass
     */
    public void setSerializerClass(Class<? extends Serializer> serializerClass) {
        module.bind(Serializer.class, serializerClass);
    }

    /**
     * Set the type mappings to use
     *
     * @param typeMappings
     */
    public void setTypeMappings(TypeMappings typeMappings) {
        module.bind(TypeMappings.class, typeMappings);
    }

    /**
     * Set whether schema names should be appended to the package name.
     *
     * <p><b>!!! Important !!!</b><i> {@link NamingStrategy#getPackage(String, SchemaAndTable)}
     * will be invoked only if <code>schemaToPackage</code> is set to <code>true</code>.</i></p>
     *
     * @param schemaToPackage
     * @deprecated This flag will not be necessary in the future because the generated package name can be controlled in
     * method {@link NamingStrategy#getPackage(String, SchemaAndTable)}.
     */
    @Deprecated
    public void setSchemaToPackage(boolean schemaToPackage) {
        this.schemaToPackage = schemaToPackage;
        module.bind(SQLCodegenModule.SCHEMA_TO_PACKAGE, schemaToPackage);
    }

    /**
     * Set whether tables should be exported
     *
     * @param exportTables
     */
    public void setExportTables(boolean exportTables) {
        this.exportTables = exportTables;
    }

    /**
     * Set whether views should be exported
     *
     * @param exportViews
     */
    public void setExportViews(boolean exportViews) {
        this.exportViews = exportViews;
    }

    /**
     * Set whether primary keys should be exported
     *
     * @param exportPrimaryKeys
     */
    public void setExportPrimaryKeys(boolean exportPrimaryKeys) {
        this.exportPrimaryKeys = exportPrimaryKeys;
    }

    /**
     * Set whether foreign keys should be exported
     *
     * @param exportForeignKeys
     */
    public void setExportForeignKeys(boolean exportForeignKeys) {
        this.exportForeignKeys = exportForeignKeys;
    }

    /**
     * Set whether direct foreign keys should be exported
     *
     * @param exportDirectForeignKeys
     */
    public void setExportDirectForeignKeys(boolean exportDirectForeignKeys) {
        this.exportDirectForeignKeys = exportDirectForeignKeys;
    }

    /**
     * Set whether inverse foreign keys should be exported
     *
     * @param exportInverseForeignKeys
     */
    public void setExportInverseForeignKeys(boolean exportInverseForeignKeys) {
        this.exportInverseForeignKeys = exportInverseForeignKeys;
    }
}
