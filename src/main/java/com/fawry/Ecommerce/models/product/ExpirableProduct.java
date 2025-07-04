package com.fawry.Ecommerce.models.product;

import com.fawry.Ecommerce.utility.DateUtils;
import com.fawry.Ecommerce.utility.ValidationUtils;

import java.time.LocalDate;


public class ExpirableProduct extends Product {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        ValidationUtils.validateNotNull(expiryDate, "Expiry date");
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isShippable() { return false; }

    @Override
    public double getWeight() { return 0.0; }

    @Override
    public boolean hasExpiry() { return true; }

    @Override
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public boolean isExpired() { return DateUtils.isExpired(expiryDate); }


}


