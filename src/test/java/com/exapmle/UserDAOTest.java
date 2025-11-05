package com.exapmle;

import com.example.DatabaseConnection;
import com.example.User;
import com.example.UserDAO;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDAOTest {

    private Connection testConnection;
    private UserDAO userDAO;

    @BeforeAll
    void setUp() throws Exception {
        // Используем H2 для тестов
        testConnection = DatabaseConnection.getTestConnection();
        DatabaseConnection.createTestTable();
    }

    @BeforeEach
    void init() throws SQLException {
        // Очищаем таблицу перед каждым тестом
        try (var statement = testConnection.createStatement()) {
            statement.execute("DELETE FROM users");
        }
        userDAO = new UserDAO(testConnection);
    }

    @AfterAll
    void tearDown() throws SQLException {
        if (testConnection != null && !testConnection.isClosed()) {
            testConnection.close();
        }
    }

    @Test
    void testInsertUser() throws SQLException {
        // Given
        var user = new User("Test User", "test@example.com");

        // When
        userDAO.insertUser(user);

        // Then
        var users = userDAO.getAllUsers();
        assertEquals(1, users.size());
        assertEquals("Test User", users.get(0).name());
        assertEquals("test@example.com", users.get(0).email());
    }

    @Test
    void testGetAllUsers() throws SQLException {
        // Given
        userDAO.insertUser(new User("User1", "user1@example.com"));
        userDAO.insertUser(new User("User2", "user2@example.com"));

        // When
        List<User> users = userDAO.getAllUsers();

        // Then
        assertEquals(2, users.size());
    }

    @Test
    void testGetUserById() throws SQLException {
        // Given
        userDAO.insertUser(new User("Test User", "test@example.com"));
        var allUsers = userDAO.getAllUsers();
        var userId = allUsers.get(0).id();

        // When
        var foundUser = userDAO.getUserById(userId);

        // Then
        assertNotNull(foundUser);
        assertEquals("Test User", foundUser.name());
        assertEquals("test@example.com", foundUser.email());
    }

    @Test
    void testUpdateUser() throws SQLException {
        // Given
        userDAO.insertUser(new User("Old Name", "old@example.com"));
        var allUsers = userDAO.getAllUsers();
        var userToUpdate = allUsers.get(0);
        var updatedUser = new User(userToUpdate.id(), "New Name", "new@example.com");

        // When
        userDAO.updateUser(updatedUser);

        // Then
        var result = userDAO.getUserById(userToUpdate.id());
        assertEquals("New Name", result.name());
        assertEquals("new@example.com", result.email());
    }

    @Test
    void testDeleteUser() throws SQLException {
        // Given
        userDAO.insertUser(new User("To Delete", "delete@example.com"));
        var allUsers = userDAO.getAllUsers();
        var userId = allUsers.get(0).id();

        // When
        userDAO.deleteUser(userId);

        // Then
        var usersAfterDelete = userDAO.getAllUsers();
        assertTrue(usersAfterDelete.isEmpty());
    }

    @Test
    void testGetUserById_NotFound() throws SQLException {
        // When
        var result = userDAO.getUserById(999);

        // Then
        assertNull(result);
    }
}