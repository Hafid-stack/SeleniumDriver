package com.test.testdataobjects;

public class CheckoutData {
    private String firstName;
    private String lastName;
    private String postalCode;

    // ✅ Constructor
    public CheckoutData(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    // ✅ Getters (VERY IMPORTANT for clean usage)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    // ✅ Factory method
    public static CheckoutData validCheckout() {
        return new CheckoutData("John", "Doe", "12345");
    }
}