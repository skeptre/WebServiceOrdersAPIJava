package com.ali.webservice.application.services;

import com.ali.webservice.domain.models.Basket;
import com.ali.webservice.domain.models.Order;
import com.ali.webservice.domain.models.Product;
import com.ali.webservice.domain.models.Promotion;
import com.ali.webservice.domain.repositories.BasketRepository;
import com.ali.webservice.domain.repositories.OrderRepository;

import java.time.LocalDate;
import java.util.Map;

public class OrderService {

    private final BasketRepository basketRepository;
    private final OrderRepository orderRepository;

    public OrderService(BasketRepository basketRepository, OrderRepository orderRepository) {
        this.basketRepository = basketRepository;
        this.orderRepository = orderRepository;
    }

    public Order checkout(int customerId, String cardNumber, LocalDate expiryDate) {
        // Simulate card expiry check
        if (expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Credit card expired.");
        }

        Basket basket = basketRepository.getBasketByCustomerId(customerId);
        if (basket == null) {
            throw new IllegalArgumentException("No basket found for customer " + customerId);
        }

        double total = calculateTotal(basket);
        Order order = new Order(customerId, basket.getItems(), total);
        orderRepository.saveOrder(order);

        return order;
    }

    private double calculateTotal(Basket basket) {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : basket.getItems().entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }

        Promotion promo = basket.getPromotion();
        if (promo != null) {
            double discount = promo.getDiscountPercentage() / 100.0;
            total -= total * discount;
        }

        return total;
    }
}