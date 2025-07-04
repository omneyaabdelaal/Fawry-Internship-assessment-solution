package com.fawry.Ecommerce.services.cartService;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.CartItem;
import com.fawry.Ecommerce.models.product.Product;
import com.fawry.Ecommerce.services.validationService.ValidationService;
import com.fawry.Ecommerce.utility.ValidationUtils;

public class CartServiceImpl implements CartService {
    private ValidationService validationService;

    public CartServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Cart createCart() {
        return new Cart();
    }
    @Override
    public void addProductToCart(Cart cart, Product product, int quantity) {
        ValidationUtils.validateNotNull(cart, "Cart");
        ValidationUtils.validateNotNull(product, "Product");
        ValidationUtils.validatePositiveInt(quantity, "Quantity");

        validationService.validateProductAvailability(product);


        CartItem existingItem = findCartItem(cart, product);
        if (existingItem != null) {
            int totalQuantity = existingItem.getQuantity() + quantity;
            validationService.validateProductQuantityInStock(product, totalQuantity);
            existingItem.addQuantity(quantity);
        } else {
            validationService.validateProductQuantityInStock(product, quantity);
            cart.addItem(new CartItem(product, quantity));
        }
    }


    @Override
    public void removeProductFromCart(Cart cart, Product product) {
        ValidationUtils.validateNotNull(cart, "Cart");
        ValidationUtils.validateNotNull(product, "Product");
        cart.removeProduct(product);
    }

    @Override
    public void clearCart(Cart cart) {
        ValidationUtils.validateNotNull(cart, "Cart");
        cart.clear();
    }


    private CartItem findCartItem(Cart cart, Product product) {
        return cart.getItems().stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst()
                .orElse(null);
    }
}
