package com.example;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Database location: " + DatabaseConnection.getDatabasePath());

            var userDAO = new UserDAO();

            // Создание таблицы
            DatabaseConnection.createTable();

            // CREATE - добавление пользователей
            System.out.println("=== CREATE USERS ===");
            userDAO.insertUser(new User("John Doe", "john@example.com"));
            userDAO.insertUser(new User("Jane Smith", "jane@example.com"));
            userDAO.insertUser(new User("Bob Johnson", "bob@example.com"));

            // READ - получение всех пользователей
            System.out.println("\n=== ALL USERS ===");
            var users = userDAO.getAllUsers();
            users.forEach(System.out::println);

            // READ - поиск по ID
            System.out.println("\n=== FIND USER BY ID ===");
            var foundUser = userDAO.getUserById(1);
            System.out.println("Found: " + foundUser);

            // UPDATE - обновление пользователя
            System.out.println("\n=== UPDATE USER ===");
            var userToUpdate = userDAO.getUserById(2);
            if (userToUpdate != null) {
                var updatedUser = new User(userToUpdate.id(), "Jane Updated", "jane.updated@example.com");
                userDAO.updateUser(updatedUser);
            }

            // Чтение после обновления
            System.out.println("\n=== USERS AFTER UPDATE ===");
            userDAO.getAllUsers().forEach(System.out::println);

            // DELETE - удаление пользователя
            System.out.println("\n=== DELETE USER ===");
            userDAO.deleteUser(3);

            // Финальный список
            System.out.println("\n=== FINAL USERS LIST ===");
            userDAO.getAllUsers().forEach(System.out::println);

            userDAO.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}