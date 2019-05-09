package com.example.elasticsearch.controllers;

import com.example.elasticsearch.entitys.Product;
import com.example.elasticsearch.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/repository")
public class ProductRepositoryController {

    @Autowired
    ProductRepository repository;

    @RequestMapping("/all")
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    @RequestMapping("/id/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return repository.findOne(productId);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Product addNewProduct(@RequestBody Product product) {
        repository.save(product);
        return product;
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.POST)
    public List<Product> getProductByName(@PathVariable String name) {
        List<Product> list = new ArrayList<>();
        repository.findByProductNameEn(name, new PageRequest(0, 10)).forEach(list::add);
        return list;
    }
}
