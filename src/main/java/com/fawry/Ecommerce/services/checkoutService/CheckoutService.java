package com.fawry.Ecommerce.services.checkoutService;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.CheckoutResult;
import com.fawry.Ecommerce.models.Customer;

public interface CheckoutService {
    CheckoutResult checkout(Customer customer, Cart cart);
    void printCheckoutReceipt(CheckoutResult result, Cart cart);
}
