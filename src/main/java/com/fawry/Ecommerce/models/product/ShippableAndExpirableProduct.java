package com.fawry.Ecommerce.models.product;

import com.fawry.Ecommerce.utility.DateUtils;
import com.fawry.Ecommerce.utility.ValidationUtils;

import java.time.LocalDate;


public class ShippableAndExpirableProduct extends Product {

    private LocalDate expiryDate;
    private double weight;

    public ShippableAndExpirableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        ValidationUtils.validateNotNull(expiryDate, "Expiry date");
        ValidationUtils.validatePositive(weight, "Weight");
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isShippable() { return true; }

    @Override
    public double getWeight() { return weight; }

    @Override
    public boolean hasExpiry() { return true; }

    @Override
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public boolean isExpired() { return DateUtils.isExpired(expiryDate); }


}



