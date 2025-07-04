package com.fawry.Ecommerce.services.cartService;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.CartItem;
import com.fawry.Ecommerce.models.product.Product;

public interface CartService {
    Cart createCart();
    void addProductToCart(Cart cart, Product product, int quantity);
    void removeProductFromCart(Cart cart, Product product);
    void clearCart(Cart cart);

}
