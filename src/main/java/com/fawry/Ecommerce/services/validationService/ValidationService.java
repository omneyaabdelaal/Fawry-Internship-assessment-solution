package com.fawry.Ecommerce.services.validationService;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.Customer;
import com.fawry.Ecommerce.models.product.Product;

public interface ValidationService {

    void validateProductAvailability(Product product);
    void validateCartEmptiness(Cart cart);
    void validateCustomerBalance(Customer customer,double amount);
    void validateProductQuantityInStock(Product product, int requestedQuantity);

}
