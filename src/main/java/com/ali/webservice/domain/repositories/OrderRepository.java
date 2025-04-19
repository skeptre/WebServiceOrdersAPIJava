package com.ali.webservice.domain.repositories;

import com.ali.webservice.domain.models.Order;
import java.util.List;

public interface OrderRepository {
    void saveOrder(Order order);
    List<Order> getAllOrders();
}