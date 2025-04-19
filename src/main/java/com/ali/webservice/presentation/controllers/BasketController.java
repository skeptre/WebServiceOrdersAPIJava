package com.ali.webservice.presentation.controllers;

import com.ali.webservice.application.services.BasketService;
import com.ali.webservice.domain.models.Basket;
import com.ali.webservice.domain.models.Promotion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/{customerId}")
    public Basket createBasket(@PathVariable int customerId) {
        return basketService.createBasket(customerId);
    }

    @PostMapping("/{customerId}/add")
    public Basket addProductToBasket(
            @PathVariable int customerId,
            @RequestParam String productCode,
            @RequestParam int quantity
    ) {
        return basketService.addProductToBasket(customerId, productCode, quantity);
    }

    @PostMapping("/{customerId}/promotion")
    public Basket applyPromotion(
            @PathVariable int customerId,
            @RequestParam String code
    ) {
        Promotion promo = switch (code) {
            case "DISCOUNT10" -> new Promotion("DISCOUNT10", 10);
            case "DISCOUNT20" -> new Promotion("DISCOUNT20", 20);
            default -> null;
        };
        return basketService.applyPromotionToBasket(customerId, promo);
    }

    @GetMapping("/{customerId}")
    public Basket getBasket(@PathVariable int customerId) {
        return basketService.getBasket(customerId);
    }
}