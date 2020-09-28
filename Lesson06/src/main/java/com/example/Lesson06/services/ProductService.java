package com.example.Lesson06.services;

import com.example.Lesson06.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long product_id);

    Product save(Product product);

    List<Product> getByPrice(Double startFilter, Double endFilter);
}
