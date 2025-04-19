package com.ali.webservice.infrastructure.persistence;

import com.ali.webservice.domain.models.Product;
import com.ali.webservice.domain.repositories.ProductRepository;

import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> productMap = new HashMap<>();

    public InMemoryProductRepository() {
        productMap.put("P1", new Product("P1", "Keyboard", 50.00));
        productMap.put("P2", new Product("P2", "Mouse", 25.00));
        productMap.put("P3", new Product("P3", "Monitor", 150.00));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product getProductByCode(String code) {
        return productMap.get(code);
    }
}