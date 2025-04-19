package com.ali.webservice.application.services;

import com.ali.webservice.domain.models.Basket;
import com.ali.webservice.domain.models.Product;
import com.ali.webservice.domain.models.Promotion;
import com.ali.webservice.domain.repositories.BasketRepository;
import com.ali.webservice.domain.repositories.ProductRepository;

public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;

    public BasketService(BasketRepository basketRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

    public Basket createBasket(int customerId) {
        Basket basket = new Basket(customerId);
        basketRepository.saveBasket(basket);
        return basket;
    }

    public Basket addProductToBasket(int customerId, String productCode, int quantity) {
        Basket basket = basketRepository.getBasketByCustomerId(customerId);
        if (basket == null) {
            basket = createBasket(customerId);
        }
        Product product = productRepository.getProductByCode(productCode);
        if (product != null) {
            basket.addItem(product, quantity);
            basketRepository.saveBasket(basket);
        }
        return basket;
    }

    public Basket applyPromotionToBasket(int customerId, Promotion promotion) {
        Basket basket = basketRepository.getBasketByCustomerId(customerId);
        if (basket != null) {
            basket.applyPromotion(promotion);
            basketRepository.saveBasket(basket);
        }
        return basket;
    }

    public Basket getBasket(int customerId) {
        return basketRepository.getBasketByCustomerId(customerId);
    }
}