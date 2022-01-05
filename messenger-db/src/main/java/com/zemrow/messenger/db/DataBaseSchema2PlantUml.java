package com.zemrow.messenger.db;

import com.querydsl.codegen.EntityType;
import com.querydsl.codegen.Property;
import com.querydsl.sql.codegen.support.ForeignKeyData;
import com.querydsl.sql.codegen.support.KeyData;
import com.zemrow.messenger.db.querydsl.QueryDslEntitySerializer;
import com.zemrow.messenger.db.querydsl.QueryDslMetaDataExporter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Построение схемы базы данных в plantuml
 * <p>
 * //TODO together {}
 *
 * @author Alexandr Polyakov on 2022.01.04
 */
public class DataBaseSchema2PlantUml {
    private final PrintWriter out;

    public DataBaseSchema2PlantUml(PrintWriter out) {
        this.out = out;
    }

    public static void write(List<EntityType> entityTypeList, String outFilePath) {
        try (FileWriter fileWriter = new FileWriter(outFilePath)) {
            DataBaseSchema2PlantUml uml = new DataBaseSchema2PlantUml(new PrintWriter(fileWriter));
            uml.writeStart();
            for (EntityType entityType : entityTypeList) {
                uml.writeEntity(entityType);
            }
            uml.writeForeignKeys(entityTypeList);
            uml.writeEnd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeStart() {
        out.println("@startuml");
        out.println("'Скрыть иконку класса");
        out.println("hide circle");
        out.println("'Скрыть раздел с полями если он пустой");
        out.println("hide empty fields");
        out.println("'Скрыть раздел с методами если он пустой");
        out.println("hide empty methods");
    }

    /**
     * Сократить комментарий. Оставить текст до первой точки.
     *
     * @param remarks исходный комментарий
     * @return краткий комментарий
     */
    private String trimRemarks(String remarks) {
        if (remarks != null) {
            int dotIndex = remarks.indexOf('.');
            if (dotIndex > 0) {
                remarks = remarks.substring(0, dotIndex);
            }
        }
        return remarks;
    }

    private void writeEntity(EntityType entityType) {
        final String tableRemarks = trimRemarks((String) entityType.getData().get(QueryDslMetaDataExporter.REMARKS));
        String comment;
        if (tableRemarks != null) {
            comment = " <<" + tableRemarks + ">>";
        } else {
            comment = "";
        }
        out.println("class " + entityType.getSimpleName() + comment + "{");
        final ArrayList<Property> properties = QueryDslEntitySerializer.getSortProperties(entityType);
        for (Property property : properties) {
            out.print("   {field} " + property.getType().getSimpleName() + " " + property.getEscapedName() + ";");
            final String remarks = trimRemarks((String) property.getData().get(QueryDslMetaDataExporter.REMARKS));
            if (remarks != null) {
                out.print(" // " + remarks);
            }
            out.println();
        }
        out.println("}");
    }

    private void writeForeignKeys(List<EntityType> entityTypeList) {
        final Set<String> foreignKeySet = new TreeSet<>();
        for (EntityType entityType : entityTypeList) {
            final Collection<ForeignKeyData> foreignKeys = (Collection<ForeignKeyData>) entityType.getData().get(ForeignKeyData.class);
            // foreign keys
            if (foreignKeys != null) {
                for (KeyData foreignKey : foreignKeys) {
                    final String firstColumn = foreignKey.getForeignColumns().get(0);
                    String color = "";
                    if (foreignKey.getForeignColumns().size() == 1) {
                        final String lowerFirstColumn = firstColumn.toLowerCase();
                        if (lowerFirstColumn.endsWith("userid")) {
                            color = "[#00FF00]";
                        } else if (lowerFirstColumn.endsWith("chatid")) {
                            color = "[#FF0000]";
                        } else if (lowerFirstColumn.endsWith("messageid")) {
                            color = "[#0000FF]";
                        }
                    }

                    if (foreignKey.getForeignColumns().size() == 1 &&
                            ("createdBy".equals(firstColumn) || "updatedBy".equals(firstColumn) || "deletedBy".equals(firstColumn))
                    ) {
//                        foreignKeySet.add(entityType.getSimpleName() + "::" + firstColumn + " }-[#00FF00,dotted]- " + foreignKey.getType().getSimpleName());
                    } else {
                        String field;
                        if (foreignKey.getForeignColumns().size() == 1) {
                            field = "::" + firstColumn;
                        } else {
                            field = "";
                        }
                        foreignKeySet.add(entityType.getSimpleName() + field + " }-" + color + "- " + foreignKey.getType().getSimpleName());
                    }
                }
            }
        }
        for (String foreignKey : foreignKeySet) {
            out.println(foreignKey);
        }
    }

    private void writeEnd() {
        out.print("@enduml");
    }
}
