package com.usermanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASS");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }
}