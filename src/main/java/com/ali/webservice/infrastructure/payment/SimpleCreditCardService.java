package com.ali.webservice.infrastructure.payment;

import java.time.LocalDate;

public class SimpleCreditCardService implements CreditCardService {

    @Override
    public boolean isValid(String cardNumber, LocalDate expiryDate) {
        return expiryDate.isAfter(LocalDate.now());
    }
}