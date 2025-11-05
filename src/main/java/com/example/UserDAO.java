package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final Connection connection;

    // Для production - использует Access
    public UserDAO() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    // Для тестов - использует переданное соединение
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE - добавление пользователя
    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.name());
            statement.setString(2, user.email());
            statement.executeUpdate();

            // Получаем сгенерированный ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("User inserted with ID: " + id);
                }
            }
        }
    }

    // READ - получение всех пользователей
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
                users.add(user);
            }
        }
        return users;
    }

    // READ - поиск пользователя по ID
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("email")
                    );
                }
            }
        }
        return null;
    }

    // UPDATE - обновление пользователя
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.name());
            statement.setString(2, user.email());
            statement.setInt(3, user.id());

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows updated: " + rowsAffected);
        }
    }

    // DELETE - удаление пользователя
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows deleted: " + rowsAffected);
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}