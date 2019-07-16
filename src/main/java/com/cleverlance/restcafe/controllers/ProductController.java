package com.cleverlance.restcafe.controllers;

import com.cleverlance.restcafe.entities.Product;
import com.cleverlance.restcafe.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAll() {
        return productRepository.getProducts();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Product product) {
        if (product.getName() == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        if (product.getPrice() <= 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<Product> existingProducts = productRepository.getProducts();
        for (Product existingProduct : existingProducts) {
            if (existingProduct.getName().equals(product.getName())) {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        }
        productRepository.addProduct(product);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
