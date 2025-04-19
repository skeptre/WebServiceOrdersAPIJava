package com.ali.webservice.presentation.controllers;

import com.ali.webservice.application.services.OrderService;
import com.ali.webservice.domain.models.Order;
import com.ali.webservice.domain.repositories.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/checkout")
    public Order checkout(
            @RequestParam int customerId,
            @RequestParam String cardNumber,
            @RequestParam String expiry // e.g. "2026-01-01"
    ) {
        LocalDate expiryDate = LocalDate.parse(expiry);
        return orderService.checkout(customerId, cardNumber, expiryDate);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}