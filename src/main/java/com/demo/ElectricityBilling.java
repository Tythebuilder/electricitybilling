package com.demo;

public class ElectricityBilling {

    private static final double FIXED_CHARGE = 50.0;

    public double calculateBill(int units) {
        if (units < 0) {
            throw new IllegalArgumentException("Units consumed cannot be negative.");
        }
        double charge = 0.0;
        if (units <= 100) {
            charge = units * 1.50;
        } else if (units <= 200) {
            charge = (100 * 1.50) + ((units - 100) * 2.50);
        } else if (units <= 500) {
            charge = (100 * 1.50) + (100 * 2.50) + ((units - 200) * 4.00);
        } else {
            charge = (100 * 1.50) + (100 * 2.50) + (300 * 4.00) + ((units - 500) * 6.00);
        }
        return charge + FIXED_CHARGE;
    }

    public String getBillSummary(String customerName, int units) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        double total = calculateBill(units);
        return "Customer: " + customerName + " | Units: " + units + " | Bill: Rs." + total;
    }

    public static void main(String[] args) {
        System.out.println("=== Smart Electricity Billing System ===");
        ElectricityBilling billing = new ElectricityBilling();
        System.out.println(billing.getBillSummary("Alice", 80));
        System.out.println(billing.getBillSummary("Bob", 150));
        System.out.println(billing.getBillSummary("Charlie", 350));
        System.out.println(billing.getBillSummary("David", 600));
    }
}