package com.fawry.Ecommerce.models.product;

import java.time.LocalDate;

public class BasicProduct extends Product {

    public BasicProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public double getWeight() {
        return 0.0;
    }

    @Override
    public boolean hasExpiry() {
        return false;
    }

    @Override
    public LocalDate getExpiryDate() {
        return null;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
