package com.zemrow.messenger.server;

import com.zemrow.messenger.constants.DBConst;
import org.apache.commons.cli.*;

import java.io.File;

/**
 * Конфигурация приложения
 *
 * @author Alexandr Polyakov on 2018.10.09
 */
public class ServerConfiguration {
    /**
     * Адрес БД
     */
    private String databaseUrl;
    /**
     * Логин пользователя к БД
     */
    private String databaseUsername;
    /**
     * Пароль пользователя к БД
     */
    private String databasePassword;
    /**
     * TODO
     */
    private int webServerPort;
    /**
     * Директория со статическим контентом (html, css, js, ...). По умолчанию папка webapp в ресурсах приложения.
     */
    private File webServerStaticDir;

    public ServerConfiguration(String[] args) throws ParseException {
        final Options options = new Options();

        final Option databaseUrlOption = new Option("dbUrl", "databaseUrl", true, "Database address");
        options.addOption(databaseUrlOption);

        final Option databaseUsernameOption = new Option("dbUser", "databaseUsername", true, "User's login to the database");
        options.addOption(databaseUsernameOption);

        final Option databasePasswordOption = new Option("dbPass", "databasePassword", true, "The user's password to the database");
        options.addOption(databasePasswordOption);

        final Option webServerPortOption = new Option("port", "webServerPort", true, "TODO");
        webServerPortOption.setType(Integer.class);
        options.addOption(webServerPortOption);

        final Option webStaticDirOption = new Option("webDir", "webServerStaticDir", true, "Directory with static content (html, css, js,...). Default, the webapp folder in the application resources.");
        webStaticDirOption.setType(File.class);
        options.addOption(webStaticDirOption);

        try {
            final CommandLineParser parser = new DefaultParser();
            final CommandLine cl = parser.parse(options, args);

            databaseUrl = getOptionValue(cl, databaseUrlOption, DBConst.DEFAULT_URL);
            databaseUsername = getOptionValue(cl, databaseUsernameOption, DBConst.DEFAULT_USER);
            databasePassword = getOptionValue(cl, databasePasswordOption, DBConst.DEFAULT_PASSWORD);
            webServerPort = getOptionValue(cl, webServerPortOption, 80);
            webServerStaticDir = getOptionValue(cl, webStaticDirOption, null);

            // TODO проверка корректности
            // TODO log current value

        } catch (ParseException e) {
            System.err.println(e.getMessage());
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("TODO", options);
            System.out.println();

            throw e;
        }
    }

    private static <T> T getOptionValue(final CommandLine cl, final Option option, T defaultValue) throws ParseException {
        Object value = cl.getParsedOptionValue(option.getLongOpt());
        if (value == null) {
            value = defaultValue;
        }
        return (T) value;
    }

//================================ AUTO GENERATE ==============================

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public int getWebServerPort() {
        return webServerPort;
    }

    public void setWebServerPort(int webServerPort) {
        this.webServerPort = webServerPort;
    }

    public File getWebServerStaticDir() {
        return webServerStaticDir;
    }

    public void setWebServerStaticDir(File webServerStaticDir) {
        this.webServerStaticDir = webServerStaticDir;
    }
}
