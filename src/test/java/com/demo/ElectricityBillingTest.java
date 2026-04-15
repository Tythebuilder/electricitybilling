package com.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ElectricityBillingTest {

    private ElectricityBilling billing;

    @BeforeEach
    void setUp() { billing = new ElectricityBilling(); }

    @Test
    void testSlab1Under100Units() {
        assertEquals(125.0, billing.calculateBill(50), 0.01);
    }

    @Test
    void testSlab1Exactly100Units() {
        assertEquals(200.0, billing.calculateBill(100), 0.01);
    }

    @Test
    void testSlab2Between101And200Units() {
        assertEquals(325.0, billing.calculateBill(150), 0.01);
    }

    @Test
    void testSlab2Exactly200Units() {
        assertEquals(450.0, billing.calculateBill(200), 0.01);
    }

    @Test
    void testSlab3Between201And500Units() {
        assertEquals(1050.0, billing.calculateBill(350), 0.01);
    }

    @Test
    void testSlab4Above500Units() {
        assertEquals(2250.0, billing.calculateBill(600), 0.01);
    }

    @Test
    void testZeroUnits() {
        assertEquals(50.0, billing.calculateBill(0), 0.01);
    }

    @Test
    void testNegativeUnitsThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> billing.calculateBill(-10));
    }

    @Test
    void testBillSummaryContainsCustomerName() {
        String summary = billing.getBillSummary("Alice", 50);
        assertTrue(summary.contains("Alice"));
        assertTrue(summary.contains("125.0"));
    }

    @Test
    void testEmptyCustomerNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> billing.getBillSummary("", 100));
        assertThrows(IllegalArgumentException.class, () -> billing.getBillSummary(null, 100));
    }
}