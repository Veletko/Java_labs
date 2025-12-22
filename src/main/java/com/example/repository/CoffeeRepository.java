package com.example.repository;

import com.example.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    // Spring Data JPA автоматически создаст CRUD методы
}