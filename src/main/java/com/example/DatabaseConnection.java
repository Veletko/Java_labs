package com.example;

import java.sql.*;
import java.io.File;

public class DatabaseConnection {
    private static final String DB_DIRECTORY = "./database/";
    private static final String DB_FILE = "example.accdb";
    private static final String DB_PATH = DB_DIRECTORY + DB_FILE;
    private static final String ACCESS_URL = "jdbc:ucanaccess://" + DB_PATH;

    private static final String TEST_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "";
    private static final String PASSWORD = "";

    static {
        // Явная загрузка драйвера
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load UCanAccess driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        createDatabaseIfNotExists();
        return DriverManager.getConnection(ACCESS_URL, USER, PASSWORD);
    }

    public static Connection getTestConnection() throws SQLException {
        return DriverManager.getConnection(TEST_URL, USER, PASSWORD);
    }

    private static void createDatabaseIfNotExists() {
        try {
            File dbDir = new File(DB_DIRECTORY);
            File dbFile = new File(DB_PATH);

            if (!dbDir.exists()) {
                dbDir.mkdirs();
                System.out.println("Created database directory: " + dbDir.getAbsolutePath());
            }

            if (!dbFile.exists()) {
                String tempUrl = "jdbc:ucanaccess://" + DB_PATH + ";newdatabaseversion=V2003";
                Connection tempConn = DriverManager.getConnection(tempUrl, USER, PASSWORD);
                tempConn.close();
                System.out.println("Created new database: " + dbFile.getAbsolutePath());
            }
        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE users (id AUTOINCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL)";

        try (Connection conn = getConnection(); Statement statement = conn.createStatement()) {
            try {
                statement.execute("DROP TABLE users");
            } catch (SQLException e) {
                // Table doesn't exist, ignore
            }
            statement.execute(sql);
            System.out.println("Table created successfully");
        }
    }

    public static void createTestTable() throws SQLException {
        String sql = "CREATE TABLE users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL)";

        try (Connection conn = getTestConnection(); Statement statement = conn.createStatement()) {
            statement.execute(sql);
        }
    }

    public static String getDatabasePath() {
        return new File(DB_PATH).getAbsolutePath();
    }
}