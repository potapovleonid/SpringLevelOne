package com.example.Lesson06.services;

import com.example.Lesson06.domain.Product;
import com.example.Lesson06.repository.ProductDAO;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    private void initializDB(){
        // Создание какие то продуктов
    }

    @Override
    public List<Product> getAll() {
        return productDAO.findAll();
    }

    @Override
    public Product getById(Long product_id) {
        return productDAO.getOne(product_id);
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public List<Product> getByPrice(Float startFilter, Float endFilter) {
        return productDAO.findAllByPrice_fldBetween(startFilter, endFilter);
    }
}
