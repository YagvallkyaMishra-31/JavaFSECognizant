package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 3: Assertions in JUnit
 *
 * This test class shows how to use the different assertion methods
 * available in JUnit 4. Each assertion checks a different kind of condition:
 *
 * - assertEquals  : checks that two values are equal
 * - assertTrue    : checks that a condition is true
 * - assertFalse   : checks that a condition is false
 * - assertNull    : checks that an object is null
 * - assertNotNull : checks that an object is NOT null
 * - assertArrayEquals : checks that two arrays have the same contents
 *
 * If any assertion fails, the test method fails and JUnit reports it.
 */
public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        // assertEquals checks that two values match
        // Good for verifying calculation results
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
        assertEquals(12, calc.multiply(3, 4));
        assertEquals("Testing string equality", "hello", "hello");
    }

    @Test
    public void testAssertTrue() {
        // assertTrue verifies that a condition evaluates to true
        Calculator calc = new Calculator();
        assertTrue(calc.isPositive(42));
        assertTrue("5 should be greater than 3", 5 > 3);
        assertTrue(calc.add(1, 1) == 2);
    }

    @Test
    public void testAssertFalse() {
        // assertFalse is the opposite — checks that a condition is false
        Calculator calc = new Calculator();
        assertFalse(calc.isPositive(-7));
        assertFalse("5 is not less than 3", 5 < 3);
        assertFalse(calc.add(2, 2) == 5);
    }

    @Test
    public void testAssertNull() {
        // assertNull checks that a reference is null
        // Our factorial method returns null for negative inputs
        Calculator calc = new Calculator();
        assertNull("Factorial of negative number should be null", calc.factorial(-1));
    }

    @Test
    public void testAssertNotNull() {
        // assertNotNull verifies that something exists (is not null)
        Calculator calc = new Calculator();
        assertNotNull("Factorial of 5 should not be null", calc.factorial(5));
        assertNotNull(new Object());
    }

    @Test
    public void testAssertArrayEquals() {
        // assertArrayEquals checks that two arrays have equal elements
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = {1, 2, 3, 4, 5};
        assertArrayEquals("Arrays should be equal", expected, actual);
    }

    @Test
    public void testAllAssertionsTogether() {
        // combining multiple assertions in one test — like the exercise shows
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }
}
