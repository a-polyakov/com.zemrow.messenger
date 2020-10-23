package com.zemrow.messenger.db;

import com.zemrow.messenger.constants.DBConst;
import com.zemrow.messenger.constants.SystemPropertiesConst;
import com.zemrow.messenger.db.querydsl.QueryDslGenerator;
import liquibase.integration.commandline.Main;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Обновление БД, актуализация констант, актуализация сущностей
 *
 * @author Alexandr Polyakov on 2020.05.07
 */
public class RunUpdateDB {

    private static final List<String> excludeFile = Arrays.asList("AbstractEntity.java", "AbstractEntityWithId.java");

    public static void main(String[] args) throws Exception {
        final PrintStream out = System.out;
        out.println("Обновление БД, актуализация констант, актуализация сущностей");
        final Properties properties = System.getProperties();
        final String url = properties.getProperty(SystemPropertiesConst.DATA_SOURCE_URL, DBConst.DEFAULT_URL);
        final String username = properties.getProperty(SystemPropertiesConst.DATA_SOURCE_USERNAME, DBConst.DEFAULT_USER);
        final String password = properties.getProperty(SystemPropertiesConst.DATA_SOURCE_PASSWORD, DBConst.DEFAULT_PASSWORD);
        out.println("URL " + url);
        out.println("username " + username);

        if (true) {
            out.println("Обновление БД (Запуск liquibase)");
            long time = System.currentTimeMillis();
            Main.run(new String[] {
                "--logLevel=debug",
                "--url=" + url,
                "--driver=" + DBConst.DRIVER,
                "--username=" + username,
                "--password=" + password,
                "--changeLogFile=script/messenger.xml",
                "update"
            });
            time = System.currentTimeMillis() - time;
            out.println("Время обновления БД " + time + "ms");
        }

        if (true) {
            // Актуализация констант
            //TODO
            deleteDirectory(new File("messenger-entity\\src\\main\\java\\com\\zemrow\\messenger\\entity\\"));

            long time = System.currentTimeMillis();

            QueryDslGenerator.generate(url, username, password);

            time = System.currentTimeMillis() - time;
            out.println("Время генерации констант " + time + "ms");
        }
    }

    public static void deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                for (File aFile : files) {
                    deleteDirectory(aFile);
                }
            }
            dir.delete();
        }
        else {
            if (!excludeFile.contains(dir.getName())) {
                dir.delete();
            }
        }
    }
}
