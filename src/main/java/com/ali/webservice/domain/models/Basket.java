package com.ali.webservice.domain.models;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private int customerId;
    private Map<Product, Integer> items = new HashMap<>();
    private Promotion promotion;

    public Basket(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() { return customerId; }
    public Map<Product, Integer> getItems() { return items; }
    public Promotion getPromotion() { return promotion; }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void applyPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}