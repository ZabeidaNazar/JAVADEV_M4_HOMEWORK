package com.test_jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        try {
            Statement statement = connection.createStatement();
            for (String queries : SqlParser.getSqlCommands("sql/populate_db.sql", 1)) {
                int i = statement.executeUpdate(queries);
                System.out.println("Updated rows: " + i);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException("SQLException. \nReason: " + e.getMessage());
        }
    }
}
