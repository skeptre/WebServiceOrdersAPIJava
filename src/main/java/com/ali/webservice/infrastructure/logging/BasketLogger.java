package com.ali.webservice.infrastructure.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BasketLogger {

    private static final Logger logger = LoggerFactory.getLogger(BasketLogger.class);

    public void logConversion(int customerId, double totalPrice) {
        logger.info("Basket for customer {} converted to Order. Total price: ${}", customerId, totalPrice);
    }
}