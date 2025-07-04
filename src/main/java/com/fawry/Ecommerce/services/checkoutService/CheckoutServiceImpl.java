package com.fawry.Ecommerce.services.checkoutService;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.CartItem;
import com.fawry.Ecommerce.models.CheckoutResult;
import com.fawry.Ecommerce.models.Customer;
import com.fawry.Ecommerce.services.shippingService.ShippingService;
import com.fawry.Ecommerce.services.validationService.ValidationService;
import com.fawry.Ecommerce.utility.FormatUtils;

public class CheckoutServiceImpl implements CheckoutService {

    private final ValidationService validationService;
    private final ShippingService shippingService;

    public CheckoutServiceImpl(ValidationService validationService, ShippingService shippingService) {
        this.validationService = validationService;
        this.shippingService = shippingService;
    }
    @Override
    public CheckoutResult checkout(Customer customer, Cart cart) {
        try {
            validationService.validateCartEmptiness(cart);

            double subtotal = cart.getSubtotal();
            double shippingFee = shippingService.calculateShippingFee(cart);
            double totalAmount = subtotal + shippingFee;

            validationService.validateCustomerBalance(customer, totalAmount);

            // Process payment and reduce stock
            customer.pay(totalAmount);
            reduceProductStock(cart);

            return new CheckoutResult(subtotal, shippingFee, totalAmount,
                    customer.getBalance(), true, null);

        } catch (Exception e) {
            return new CheckoutResult(0, 0, 0, customer.getBalance(), false, e.getMessage());
        }
    }


    public void printCheckoutReceipt(CheckoutResult result, Cart cart) {
        System.out.println("**Checkout receipt**");

        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() +
                    " " + String.format("%.0f", item.getTotalPrice()));
        }

        System.out.println("----------------------");
        System.out.println("Subtotal " + String.format("%.0f", result.getSubtotal()));
        System.out.println("Shipping " + String.format("%.0f", result.getShippingFee()));
        System.out.println("Amount " + String.format("%.0f", result.getTotalAmount()));

    }

    private void reduceProductStock(Cart cart) {
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }
    }



}


