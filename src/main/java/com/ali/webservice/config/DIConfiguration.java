package com.ali.webservice.config;

import com.ali.webservice.application.services.BasketService;
import com.ali.webservice.application.services.OrderService;
import com.ali.webservice.domain.repositories.BasketRepository;
import com.ali.webservice.domain.repositories.OrderRepository;
import com.ali.webservice.domain.repositories.ProductRepository;
import com.ali.webservice.infrastructure.payment.CreditCardService;
import com.ali.webservice.infrastructure.payment.SimpleCreditCardService;
import com.ali.webservice.infrastructure.persistence.InMemoryBasketRepository;
import com.ali.webservice.infrastructure.persistence.InMemoryOrderRepository;
import com.ali.webservice.infrastructure.persistence.InMemoryProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfiguration {

    @Bean
    public ProductRepository productRepository() {
        return new InMemoryProductRepository();
    }

    @Bean
    public BasketRepository basketRepository() {
        return new InMemoryBasketRepository();
    }

    @Bean
    public OrderRepository orderRepository() {
        return new InMemoryOrderRepository();
    }

    @Bean
    public BasketService basketService(ProductRepository productRepo, BasketRepository basketRepo) {
        return new BasketService(basketRepo, productRepo);
    }

    @Bean
    public OrderService orderService(BasketRepository basketRepo, OrderRepository orderRepo) {
        return new OrderService(basketRepo, orderRepo);
    }

    @Bean
    public CreditCardService creditCardService() {
        return new SimpleCreditCardService();
    }
}