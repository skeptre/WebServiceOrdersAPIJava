package com.ali.webservice.domain.models;

public class Customer {
    private int customerId;

    public Customer(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }
}