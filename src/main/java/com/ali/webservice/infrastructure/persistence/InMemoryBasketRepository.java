package com.ali.webservice.infrastructure.persistence;

import com.ali.webservice.domain.models.Basket;
import com.ali.webservice.domain.repositories.BasketRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryBasketRepository implements BasketRepository {

    private final Map<Integer, Basket> basketMap = new HashMap<>();

    @Override
    public Basket getBasketByCustomerId(int customerId) {
        return basketMap.get(customerId);
    }

    @Override
    public void saveBasket(Basket basket) {
        basketMap.put(basket.getCustomerId(), basket);
    }
}