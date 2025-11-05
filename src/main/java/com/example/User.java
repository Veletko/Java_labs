package com.example;

public record User(Integer id, String name, String email) {
    // Конструктор без ID для вставки новых записей
    public User(String name, String email) {
        this(null, name, email);
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', email='%s'}", id, name, email);
    }
}