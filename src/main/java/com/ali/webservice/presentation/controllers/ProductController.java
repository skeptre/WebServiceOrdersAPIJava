package com.ali.webservice.presentation.controllers;

import com.ali.webservice.domain.models.Product;
import com.ali.webservice.domain.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepo;

    public ProductController(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepo.getAllProducts();
    }
}