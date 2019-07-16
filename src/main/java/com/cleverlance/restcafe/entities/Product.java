package com.cleverlance.restcafe.entities;

public class Product {
    private final String name;
    private final int price;
    private final ProductCategoryEnum category;

    public Product(String name, int price, ProductCategoryEnum category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ProductCategoryEnum getCategory() {
        return category;
    }
}
