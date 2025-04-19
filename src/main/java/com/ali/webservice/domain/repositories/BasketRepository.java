package com.ali.webservice.domain.repositories;

import com.ali.webservice.domain.models.Basket;

public interface BasketRepository {
    Basket getBasketByCustomerId(int customerId);
    void saveBasket(Basket basket);
}