package com.example;

import java.sql.*;
import java.io.File;

public class DatabaseConnection {
    private static final String DB_DIRECTORY = "./database/";
    private static final String DB_FILE = "coffee.accdb";
    private static final String DB_PATH = DB_DIRECTORY + DB_FILE;
    private static final String ACCESS_URL = "jdbc:ucanaccess://" + DB_PATH;

    private static final String TEST_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "";
    private static final String PASSWORD = "";

    static {
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
        String sql = "CREATE TABLE coffee (" +
                "id AUTOINCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "type VARCHAR(50) NOT NULL, " +
                "weight DOUBLE NOT NULL, " +
                "volume DOUBLE NOT NULL, " +
                "price DOUBLE NOT NULL, " +
                "package_weight DOUBLE, " +
                "package_type VARCHAR(50), " +
                "quantity INTEGER DEFAULT 0)";

        try (Connection conn = getConnection(); Statement statement = conn.createStatement()) {
            try {
                statement.execute("DROP TABLE coffee");
            } catch (SQLException e) {
                // Table doesn't exist, ignore
            }
            statement.execute(sql);
            System.out.println("Table created successfully");

            // Вставляем тестовые данные
            insertSampleData(conn);
        }
    }

    private static void insertSampleData(Connection conn) throws SQLException {
        String[] sqls = {
                "INSERT INTO coffee (name, type, weight, volume, price, package_weight, package_type, quantity) " +
                        "VALUES ('Arabica Premium', 'BEAN', 1.0, 0.002, 25.50, 0.05, 'Бумажный пакет', 100)",

                "INSERT INTO coffee (name, type, weight, volume, price, package_weight, package_type, quantity) " +
                        "VALUES ('Robusta Gold', 'GROUND', 0.5, 0.0015, 18.75, 0.03, 'Фольгированный пакет', 150)",

                "INSERT INTO coffee (name, type, weight, volume, price, package_weight, package_type, quantity) " +
                        "VALUES ('Nescafe Classic', 'INSTANT_JAR', 0.2, 0.0008, 12.30, 0.15, 'Стеклянная банка', 80)",

                "INSERT INTO coffee (name, type, weight, volume, price, package_weight, package_type, quantity) " +
                        "VALUES ('Jacobs Monarch', 'INSTANT_SACHET', 0.025, 0.0001, 1.20, 0.005, 'Пакетик', 500)",

                "INSERT INTO coffee (name, type, weight, volume, price, package_weight, package_type, quantity) " +
                        "VALUES ('Colombian Supremo', 'BEAN', 2.0, 0.004, 45.00, 0.08, 'Вакуумная упаковка', 60)"
        };

        try (Statement statement = conn.createStatement()) {
            for (String sql : sqls) {
                statement.execute(sql);
            }
            System.out.println("Sample data inserted");
        }
    }

    public static String getDatabasePath() {
        return new File(DB_PATH).getAbsolutePath();
    }
}