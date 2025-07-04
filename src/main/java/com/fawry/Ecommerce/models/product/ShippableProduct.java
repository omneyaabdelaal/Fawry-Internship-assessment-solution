package com.fawry.Ecommerce.models.product;

import com.fawry.Ecommerce.utility.FormatUtils;
import com.fawry.Ecommerce.utility.ValidationUtils;

import java.time.LocalDate;

public class ShippableProduct extends Product {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        ValidationUtils.validatePositive(weight, "Weight");
        this.weight = weight;
    }

    @Override
    public boolean isShippable() { return true; }

    @Override
    public double getWeight() { return weight; }

    @Override
    public boolean hasExpiry() { return false; }

    @Override
    public LocalDate getExpiryDate() { return null; }

    @Override
    public boolean isExpired() { return false; }

}
