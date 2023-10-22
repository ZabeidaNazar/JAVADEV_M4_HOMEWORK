package com.test_jdbc.props;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final File appConfigPath = new File("src\\main\\resources\\app.properties");
    public static String getConnectionUrlToPostgres() {
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url;

        try {
            url = new StringBuilder("jdbc:postgresql://")
                    .append(appProps.getProperty("postgres.db.host"))
                    .append(":")
                    .append(appProps.getProperty("postgres.db.port"))
                    .append("/")
                    .append(appProps.getProperty("postgres.db.database"))
                    .toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public static String getUserToPostgres() {
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return appProps.getProperty("postgres.db.username");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getPasswordToPostgres() {
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return appProps.getProperty("postgres.db.password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
