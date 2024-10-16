package com.vedruna.sampleproject.services;

import java.util.List;

import com.vedruna.sampleproject.persistance.models.Product;

public interface ProductServiceI {
    List<Product> showAllProducts();
    Product showProductByname(String product_name);
    void saveProduct(Product product);
    void updateProduct(Integer id,Product product);
    void deleteProduct(Integer id);
}