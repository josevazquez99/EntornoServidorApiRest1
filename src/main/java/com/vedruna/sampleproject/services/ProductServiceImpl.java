package com.vedruna.sampleproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.sampleproject.persistance.models.Product;
import com.vedruna.sampleproject.persistance.repository.ProductRepositoryI;

@Service
public class ProductServiceImpl implements ProductServiceI {

    
    @Autowired
    ProductRepositoryI productRepo;

    @Override
    public List<Product> showAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product showProductByname(String product_name) {
        return productRepo.findByname(product_name);

    }
    public Product findProductById(Integer id) {
        return productRepo.findById(id).orElse(null); 
    }
    
    @Override
    public void saveProduct(Product product) {
            productRepo.save(product);
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        product.setId(id);
        productRepo.save(product);
    }


    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

}