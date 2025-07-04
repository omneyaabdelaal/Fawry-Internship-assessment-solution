package com.fawry.Ecommerce.models;

import com.fawry.Ecommerce.models.product.Product;
import com.fawry.Ecommerce.utility.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        ValidationUtils.validateNotNull(item, "Cart item");
        this.items.add(item);
    }

    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double getTotalWeight() {
        return items.stream()
                .filter(item -> item.getProduct().isShippable())
                .mapToDouble(CartItem::getTotalWeight)
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public List<CartItem> getShippableItems() {
        return items.stream()
                .filter(item -> item.getProduct().isShippable())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
