package com.vedruna.sampleproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.sampleproject.persistance.models.Product;
import com.vedruna.sampleproject.services.ProductServiceI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductServiceI productServiceI;
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productServiceI.showAllProducts();
    }

    @GetMapping("/name/{product_name}")
    public Product showProductByname(@PathVariable String product_name) {
        return productServiceI.showProductByname(product_name);
    }

    @PostMapping("/insert")
    public String postUser(@RequestBody Product product) {
        productServiceI.saveProduct(product);

        return "Product saved";
    }
    
    @PutMapping("edit/{id}")
    public String editProduct(@PathVariable Integer id, @RequestBody Product product) {
        productServiceI.updateProduct(id, product);
        
        return "Product modified";
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productServiceI.deleteProduct(id);
        
        return "Product deleted";
    }

}
