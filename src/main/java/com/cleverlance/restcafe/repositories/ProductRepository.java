package com.cleverlance.restcafe.repositories;

import com.cleverlance.restcafe.entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    public  List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
