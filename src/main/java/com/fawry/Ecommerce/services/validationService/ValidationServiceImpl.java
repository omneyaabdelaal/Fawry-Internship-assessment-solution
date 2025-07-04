package com.fawry.Ecommerce.services.validationService;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.Customer;
import com.fawry.Ecommerce.models.product.Product;
import com.fawry.Ecommerce.utility.FormatUtils;

public class ValidationServiceImpl implements ValidationService{

    @Override
    public void validateProductAvailability(Product product) {
        if (!product.isAvailable()) {
            throw new IllegalArgumentException("Product " + product.getName() + " is not available");
        }
    }

    @Override
    public void validateCartEmptiness(Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

    }

    @Override
    public void validateProductQuantityInStock(Product product, int requestedQuantity) {
        if (product.getQuantity() < requestedQuantity) {
            throw new IllegalArgumentException("Insufficient stock for " + product.getName() +
                    ". Available: " + product.getQuantity() +
                    ", Requested: " + requestedQuantity);
        }
    }



    public void validateCustomerBalance(Customer customer, double amount) {
        if (customer.insufficientBalance(amount)) {
            throw new IllegalArgumentException("Insufficient balance. Required: $" +
                    FormatUtils.formatMoney(amount) +
                    ", Available: $" + FormatUtils.formatMoney(customer.getBalance()));
        }
    }
}
