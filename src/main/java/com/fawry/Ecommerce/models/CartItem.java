package com.fawry.Ecommerce.models;

import com.fawry.Ecommerce.models.product.Product;
import com.fawry.Ecommerce.utility.ValidationUtils;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        ValidationUtils.validateNotNull(product, "Product");
        ValidationUtils.validatePositiveInt(quantity, "Quantity");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public double getTotalWeight() {
        return product.getWeight() * quantity;
    }

    public void addQuantity(int amount) {
        ValidationUtils.validatePositiveInt(amount, "Amount");
        this.quantity += amount;
    }


}
