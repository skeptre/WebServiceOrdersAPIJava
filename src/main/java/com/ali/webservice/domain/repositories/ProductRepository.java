package com.ali.webservice.domain.repositories;

import com.ali.webservice.domain.models.Product;
import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductByCode(String code);
}