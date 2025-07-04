package com.fawry.Ecommerce.services.productService;

import com.fawry.Ecommerce.models.product.Product;
import com.fawry.Ecommerce.services.validationService.ValidationService;
import com.fawry.Ecommerce.utility.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private  List<Product> products;
    private ValidationService validationService;

    public ProductServiceImpl(ValidationService validationService) {
        this.products = new ArrayList<>();
        this.validationService = validationService;
    }
    @Override
    public void addProduct(Product product) {
        ValidationUtils.validateNotNull(product, "Product");
        products.add(product);
    }

    @Override
    public Product getProductByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public List<Product> getAllAvailableProducts() {
        return products.stream()
                .filter(Product::isAvailable)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    @Override
    public void validateProductForCart(Product product, int quantity) {
        validationService.validateProductAvailability(product);
        validationService.validateProductQuantityInStock(product, quantity);
    }
}
