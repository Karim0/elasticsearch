package com.example.elasticsearch.controllers;

import com.example.elasticsearch.dao.ProductDAO;
import com.example.elasticsearch.entitys.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @RequestMapping("/all")
    public List<Product> getAllProducts() {
        return productDAO.getAllProduct();
    }

    @RequestMapping("/id/{userId}")
    public Product getProduct(@PathVariable Long userId) {
        Product user = productDAO.getProductById(userId);
        return user;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Product addNewProducts(@RequestBody Product user) {
        productDAO.addNewProduct(user);
        return user;
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.POST)
    public List<Product> addNewProducts(@PathVariable String name) {
        return productDAO.getProductByName(name);
    }
}
