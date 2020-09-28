package com.example.Lesson06.services;

import com.example.Lesson06.domain.Product;
import com.example.Lesson06.repository.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
        initializDB();
    }

    private void initializDB() {
        productDAO.saveAll(Arrays.asList(
                new Product(null, "Bread", 15.25),
                new Product(null, "Butter", 16.35),
                new Product(null, "Apple", 5.05),
                new Product(null, "Orange", 10.50)
        ));
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
    public List<Product> getByPrice(Double startFilter, Double endFilter) {
        return productDAO.findAllByPriceBetween(startFilter, endFilter);
    }
}
