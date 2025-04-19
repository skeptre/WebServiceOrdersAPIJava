package com.ali.webservice.domain.models;

public class Promotion {
    private String code;
    private double discountPercentage;

    public Promotion(String code, double discountPercentage) {
        this.code = code;
        this.discountPercentage = discountPercentage;
    }

    public String getCode() { return code; }
    public double getDiscountPercentage() { return discountPercentage; }
}