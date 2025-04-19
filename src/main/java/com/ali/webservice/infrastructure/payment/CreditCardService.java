package com.ali.webservice.infrastructure.payment;

import java.time.LocalDate;

public interface CreditCardService {
    boolean isValid(String cardNumber, LocalDate expiryDate);
}