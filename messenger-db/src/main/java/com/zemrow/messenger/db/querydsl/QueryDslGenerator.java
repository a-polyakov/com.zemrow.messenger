package com.zemrow.messenger.db.querydsl;

import com.querydsl.codegen.EntityType;
import com.querydsl.sql.codegen.OrdinalPositionComparator;
import com.querydsl.sql.codegen.OriginalNamingStrategy;
import com.zemrow.messenger.constants.DBConst;
import com.zemrow.messenger.dao.QueryDslConfiguration;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Актуализация констант, актуализация сущностей
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class QueryDslGenerator {
    public static List<EntityType> generate(final String url, final String username,
                                            final String password) throws ClassNotFoundException, SQLException {

        // Актуализация констант
        Class.forName(DBConst.DRIVER_CLASS_NAME);
        try (Connection dbConn = DriverManager.getConnection(url, username, password)) {

            final File targetFolder = new File("messenger-entity\\src\\main\\java");
            final QueryDslMetaDataExporter exporter = new QueryDslMetaDataExporter();
            exporter.setExportTables(true);
            exporter.setExportViews(true);
            // формирование DSL
            exporter.setTargetFolder(targetFolder);
            exporter.setPackageName("com.zemrow.messenger.entity.constants");
            exporter.setNamePrefix("");
            exporter.setNameSuffix("Const");
            exporter.setSerializerClass(QueryDslMetaDataSerializer.class);

            exporter.setExportPrimaryKeys(true); // Генерировать DSL для первичного ключа
            exporter.setExportForeignKeys(true); // Генерировать DSL для внешнего ключа
            exporter.setExportDirectForeignKeys(true); // Генерировать DSL для внешнего ключа (на другие таблицы)
            exporter.setExportInverseForeignKeys(false); // Не генерировать DSL для внешнего ключа (от других таблиц)
            exporter.setColumnComparatorClass(OrdinalPositionComparator.class); // Сортировать поля в соответствии с порядком полей в таблице
            // формирование entity
            exporter.setBeansTargetFolder(targetFolder);
            exporter.setBeanPackageName("com.zemrow.messenger.entity");
            exporter.setBeanPrefix("");
            exporter.setBeanSuffix("");
            exporter.setBeanSerializerClass(QueryDslEntitySerializer.class);

            exporter.setNamingStrategy(new OriginalNamingStrategy());
            exporter.setConfiguration(QueryDslConfiguration.CUSTOM);

            final List<EntityType> entityTypeList = exporter.export(dbConn.getMetaData());
            return entityTypeList;
        }
    }
}