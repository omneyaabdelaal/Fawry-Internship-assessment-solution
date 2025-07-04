package com.fawry.Ecommerce.services.shippingService;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.CartItem;
import com.fawry.Ecommerce.models.ShippingCalculator;
import com.fawry.Ecommerce.utility.FormatUtils;
import com.fawry.Ecommerce.utility.ValidationUtils;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {

    private ShippingCalculator calculator;

    public ShippingServiceImpl(ShippingCalculator calculator) {
        ValidationUtils.validateNotNull(calculator, "Shipping calculator");
        this.calculator = calculator;
    }
    @Override
    public double calculateShippingFee(Cart cart) {
        return calculator.calculateShipping(cart.getTotalWeight());
    }

    @Override
    public void printShipmentNotice(Cart cart) {
        List<CartItem> shippableItems = cart.getShippableItems();
        if (shippableItems.isEmpty()) {
            return;
        }


        System.out.println("**Shipment notice**");

        for (CartItem item : shippableItems) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() +
                    " " + FormatUtils.formatWeightInGram(item.getTotalWeight()) );
        }

        System.out.println("Total package weight " + FormatUtils.formatWeightInKg(cart.getTotalWeight()) + "kg");
        System.out.println("\n");
    }

    }

