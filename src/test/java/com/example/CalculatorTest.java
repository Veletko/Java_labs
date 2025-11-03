package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(2, -3));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(5, calculator.subtract(2, -3));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(5, 0));
        assertEquals(-6, calculator.multiply(2, -3));
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(-2.0, calculator.divide(-6, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class,
            () -> calculator.divide(5, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testFactorial() {
        assertEquals(1, calculator.factorial(0));
        assertEquals(1, calculator.factorial(1));
        assertEquals(120, calculator.factorial(5));
        assertEquals(3628800, calculator.factorial(10));
    }

    @Test
    void testFactorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> calculator.factorial(-5));
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }
}