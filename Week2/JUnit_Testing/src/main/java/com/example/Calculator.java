package com.example;

/**
 * A simple calculator utility class.
 * This is the class we'll be writing tests for in our JUnit exercises.
 * Nothing fancy — just basic arithmetic so we can focus on learning JUnit itself.
 */
public class Calculator {

    // Adds two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Subtracts second number from first
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplies two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Divides first number by second, throws exception if dividing by zero
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    // Checks if a number is positive
    public boolean isPositive(int number) {
        return number > 0;
    }

    // Returns the factorial of a non-negative integer
    // Returns null for negative inputs to demonstrate assertNull
    public Integer factorial(int n) {
        if (n < 0) {
            return null; // undefined for negatives
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
