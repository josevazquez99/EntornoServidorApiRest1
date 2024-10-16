package com.vedruna.sampleproject.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.sampleproject.persistance.models.Product;

@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Integer>{
    //https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    Product findByname(String product_name);

}
