package com.fawry.Ecommerce.models.product;

import com.fawry.Ecommerce.utility.FormatUtils;
import com.fawry.Ecommerce.utility.ValidationUtils;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        ValidationUtils.validateNotEmpty(name, "Product name");
        ValidationUtils.validateNonNegative(price, "Product price");
        ValidationUtils.validateNonNegativeInt(quantity, "Product quantity");

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Business logic
    public boolean isAvailable() {
        return quantity > 0 && !isExpired();
    }

    public void reduceQuantity(int amount) {
        ValidationUtils.validatePositiveInt(amount, "Reduce amount");
        if (amount > quantity) {
            throw new IllegalArgumentException("Cannot reduce quantity more than available");
        }
        this.quantity -= amount;
    }

    public void setQuantity(int quantity) {
        ValidationUtils.validateNonNegativeInt(quantity, "Quantity");
        this.quantity = quantity;
    }


    public abstract boolean isShippable();
    public abstract double getWeight();
    public abstract boolean hasExpiry();
    public abstract LocalDate getExpiryDate();
    public abstract boolean isExpired();

}



