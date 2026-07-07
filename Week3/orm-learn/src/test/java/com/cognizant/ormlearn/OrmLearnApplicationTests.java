package com.cognizant.ormlearn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * OrmLearnApplicationTests - Basic test to verify the Spring context loads.
 *
 * The @SpringBootTest annotation spins up a real Spring ApplicationContext
 * for testing. If any bean fails to load or config is wrong, this test fails —
 * so it acts as a good sanity check that the whole application wires up OK.
 */
@SpringBootTest
class OrmLearnApplicationTests {

    @Test
    void contextLoads() {
        // If the Spring context loads without throwing any exception,
        // this test automatically passes. Simple but effective.
    }
}
