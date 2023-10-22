package com.test_jdbc;

import com.test_jdbc.props.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database instance = new Database();
    private Connection connection;

    private Database() {
        try {
            this.connection = DriverManager.getConnection(PropertyReader.getConnectionUrlToPostgres(),
                    PropertyReader.getUserToPostgres(),
                    PropertyReader.getPasswordToPostgres());
        } catch (SQLException e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        }
    }

    public static Database getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void close() {
        try {
            instance.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
