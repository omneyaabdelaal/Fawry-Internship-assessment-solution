package com.fawry.Ecommerce.app;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.Customer;
import com.fawry.Ecommerce.models.product.BasicProduct;

import com.fawry.Ecommerce.models.product.ShippableAndExpirableProduct;
import com.fawry.Ecommerce.models.product.ShippableProduct;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        ECommerceApplication app = new ECommerceApplication();


        app.addProduct(new ShippableAndExpirableProduct("Cheese", 100, 10, LocalDate.now().plusDays(5), 0.2));
        app.addProduct(new ShippableProduct("TV", 500, 5, 15.0));
        app.addProduct(new BasicProduct("Scratch Card", 25, 100));
        app.addProduct(new ShippableAndExpirableProduct("Biscuits", 150, 20, LocalDate.now().plusDays(30), 0.7));


        Customer customer = new Customer("Omneya", 2000.0);

        // Test successful checkout
        System.out.println("=== SUCCESSFUL CHECKOUT ===");
        Cart cart = app.createCart();

        try {
            app.addToCart(cart, app.getProduct("Cheese"), 2);
            app.addToCart(cart, app.getProduct("TV"), 1);
            app.addToCart(cart, app.getProduct("Scratch Card"), 1);
            app.addToCart(cart, app.getProduct("Biscuits"), 1);

            app.checkout(customer, cart);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Test edge cases
        System.out.println("\n=== EDGE CASE TESTING ===");


        Cart emptyCart = app.createCart();
        app.checkout(customer, emptyCart);


        Customer poorCustomer = new Customer("mohamed", 10.0);
        Cart expensiveCart = app.createCart();
        try {
            app.addToCart(expensiveCart, app.getProduct("TV"), 1);
            app.checkout(poorCustomer, expensiveCart);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }


        try {
            Cart bigCart = app.createCart();
            app.addToCart(bigCart, app.getProduct("TV"), 100); // Only left 5 in stock
        } catch (Exception e) {
            System.err.println("Stock error: " + e.getMessage());
        }

    }
}