package com.ali.webservice.infrastructure.persistence;

import com.ali.webservice.domain.models.Order;
import com.ali.webservice.domain.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    @Override
    public void saveOrder(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}