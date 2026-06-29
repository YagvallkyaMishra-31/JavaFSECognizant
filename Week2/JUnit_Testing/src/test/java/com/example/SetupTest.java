package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Exercise 1: Setting Up JUnit
 *
 * This test class demonstrates that JUnit is properly configured in our project.
 * After adding the JUnit dependency to pom.xml, we can write and run test methods
 * using the @Test annotation. If this class compiles and the test passes,
 * our JUnit setup is working correctly.
 *
 * How to run:
 * - In IntelliJ: Right-click on this class -> Run 'SetupTest'
 * - Via Maven: mvn test
 * - In Eclipse: Right-click -> Run As -> JUnit Test
 */
public class SetupTest {

    @Test
    public void testJUnitSetup() {
        // If this test runs without errors, JUnit is set up correctly
        // We'll do a simple assertion just to verify everything works
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);

        assertEquals("JUnit is working! 2 + 3 should equal 5", 5, result);
        System.out.println("JUnit setup verified successfully — tests are running!");
    }

    @Test
    public void testBasicSubtraction() {
        // Another quick test to confirm everything is good
        Calculator calc = new Calculator();
        int result = calc.subtract(10, 4);

        assertEquals(6, result);
        System.out.println("Subtraction test passed.");
    }
}
