package com.ali.webservice.domain.models;

import java.util.Map;

public class Order {
    private int customerId;
    private Map<Product, Integer> items;
    private double totalPrice;

    public Order(int customerId, Map<Product, Integer> items, double totalPrice) {
        this.customerId = customerId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public int getCustomerId() { return customerId; }
    public Map<Product, Integer> getItems() { return items; }
    public double getTotalPrice() { return totalPrice; }
}