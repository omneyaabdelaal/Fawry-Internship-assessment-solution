package com.fawry.Ecommerce.services.shippingService;

import com.fawry.Ecommerce.models.Cart;

public interface ShippingService {
    double calculateShippingFee(Cart cart);
    void printShipmentNotice(Cart cart);

}
