package com.fawry.Ecommerce.app;

import com.fawry.Ecommerce.models.Cart;
import com.fawry.Ecommerce.models.CheckoutResult;
import com.fawry.Ecommerce.models.Customer;
import com.fawry.Ecommerce.models.ShippingCalculator;
import com.fawry.Ecommerce.models.product.Product;
import com.fawry.Ecommerce.services.cartService.CartService;
import com.fawry.Ecommerce.services.cartService.CartServiceImpl;
import com.fawry.Ecommerce.services.checkoutService.CheckoutService;
import com.fawry.Ecommerce.services.checkoutService.CheckoutServiceImpl;
import com.fawry.Ecommerce.services.productService.ProductService;
import com.fawry.Ecommerce.services.productService.ProductServiceImpl;
import com.fawry.Ecommerce.services.shippingService.ShippingService;
import com.fawry.Ecommerce.services.shippingService.ShippingServiceImpl;
import com.fawry.Ecommerce.services.validationService.ValidationService;
import com.fawry.Ecommerce.services.validationService.ValidationServiceImpl;

class ECommerceApplication {
    private final ProductService productService;
    private final CartService cartService;
    private final CheckoutService checkoutService;
    private final ShippingService shippingService;

    public ECommerceApplication() {
        ValidationService validationService = new ValidationServiceImpl();
        ShippingCalculator shippingCalculator = new ShippingCalculator(10.0, 20.0);

        this.productService = new ProductServiceImpl(validationService);
        this.cartService = new CartServiceImpl(validationService);
        this.shippingService = new ShippingServiceImpl(shippingCalculator);
        this.checkoutService = new CheckoutServiceImpl(validationService, shippingService);
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public Product getProduct(String name) {
        return productService.getProductByName(name);
    }

    public Cart createCart() {
        return cartService.createCart();
    }

    public void addToCart(Cart cart, Product product, int quantity) {
        cartService.addProductToCart(cart, product, quantity);
    }

    public CheckoutResult checkout(Customer customer, Cart cart) {
        CheckoutResult result = checkoutService.checkout(customer, cart);

        if (result.isSuccess()) {
            shippingService.printShipmentNotice(cart);
            checkoutService.printCheckoutReceipt(result, cart);
        } else {
            System.err.println("Checkout failed: " + result.getErrorMessage());
        }

        return result;
    }
}