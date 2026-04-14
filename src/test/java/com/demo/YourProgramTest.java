package com.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// RENAME THIS FILE to match your program e.g. ShoppingCartTest.java

public class YourProgramTest {

    private YourProgram program;

    @BeforeEach
    void setUp() {
        program = new YourProgram();
    }

    @Test
    void testBasicSuccess() {
        assertNotNull(program);
    }

    @Test
    void testAnotherScenario() {
        assertTrue(true);
    }
}
