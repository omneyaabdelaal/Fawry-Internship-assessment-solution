package com.fawry.Ecommerce.services.productService;

import com.fawry.Ecommerce.models.product.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);
    Product getProductByName(String name);
    List<Product> getAllProducts();
    List<Product> getAllAvailableProducts();
    void validateProductForCart(Product product, int quantity);

}
