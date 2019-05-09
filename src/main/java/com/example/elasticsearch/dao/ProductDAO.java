package com.example.elasticsearch.dao;

import com.example.elasticsearch.entitys.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getAllProduct();
    Product getProductById(Long id);
    Product addNewProduct(Product product);
    List<Product> getProductByName(String name);
}
