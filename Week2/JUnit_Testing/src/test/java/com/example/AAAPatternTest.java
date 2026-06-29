package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures,
 *             Setup and Teardown Methods
 *
 * The AAA pattern is a simple way to organize each test method:
 *   Arrange — set up the objects and data you need
 *   Act     — call the method you're testing
 *   Assert  — verify that the result is what you expected
 *
 * @Before runs before EACH test method  — good for setting up shared objects
 * @After  runs after EACH test method   — good for cleaning up resources
 *
 * Think of it like this:
 *   @Before  = "get the classroom ready before each lesson"
 *   test     = "run the lesson"
 *   @After   = "clean up the classroom after the lesson"
 */
public class AAAPatternTest {

    // This is our "test fixture" — shared state set up before each test
    private Calculator calculator;

    /**
     * Setup method — runs before each test.
     * Creates a fresh Calculator object so each test starts clean.
     */
    @Before
    public void setUp() {
        System.out.println("--- Setting up: creating new Calculator instance ---");
        calculator = new Calculator();
    }

    /**
     * Teardown method — runs after each test.
     * In this case we don't have resources to release, but in real projects
     * this is where you'd close database connections, delete temp files, etc.
     */
    @After
    public void tearDown() {
        System.out.println("--- Tearing down: cleaning up after test ---\n");
        calculator = null; // releasing the reference
    }

    @Test
    public void testAddition() {
        // Arrange — input values are ready, calculator is set up by @Before
        int a = 15;
        int b = 25;

        // Act — perform the operation we want to test
        int result = calculator.add(a, b);

        // Assert — check that the result matches our expectation
        assertEquals("15 + 25 should be 40", 40, result);
        System.out.println("testAddition passed: " + a + " + " + b + " = " + result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 50;
        int b = 18;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals("50 - 18 should be 32", 32, result);
        System.out.println("testSubtraction passed: " + a + " - " + b + " = " + result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 7;
        int b = 8;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals("7 * 8 should be 56", 56, result);
        System.out.println("testMultiplication passed: " + a + " * " + b + " = " + result);
    }

    @Test
    public void testDivision() {
        // Arrange
        int a = 100;
        int b = 4;

        // Act
        double result = calculator.divide(a, b);

        // Assert — using delta for floating point comparison
        assertEquals("100 / 4 should be 25.0", 25.0, result, 0.001);
        System.out.println("testDivision passed: " + a + " / " + b + " = " + result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act — this should throw ArithmeticException
        // The @Test(expected) annotation handles the Assert part for us
        calculator.divide(a, b);

        // If we reach here, the test fails because no exception was thrown
        System.out.println("testDivisionByZero — exception was thrown as expected");
    }

    @Test
    public void testFactorialWithAAA() {
        // Arrange
        int input = 5;
        int expectedResult = 120; // 5! = 5*4*3*2*1 = 120

        // Act
        Integer result = calculator.factorial(input);

        // Assert
        assertNotNull("Factorial result should not be null", result);
        assertEquals("5! should equal 120", expectedResult, result.intValue());
        System.out.println("testFactorial passed: " + input + "! = " + result);
    }

    @Test
    public void testIsPositiveWithAAA() {
        // Arrange
        int positiveNumber = 42;
        int negativeNumber = -10;
        int zero = 0;

        // Act & Assert — sometimes we combine these for simple boolean checks
        assertTrue("42 should be positive", calculator.isPositive(positiveNumber));
        assertFalse("-10 should not be positive", calculator.isPositive(negativeNumber));
        assertFalse("0 should not be positive", calculator.isPositive(zero));

        System.out.println("testIsPositive passed for values: " + positiveNumber
                + ", " + negativeNumber + ", " + zero);
    }
}
