package com.example.Lesson06.repository;

import com.example.Lesson06.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceBetween(Double startFilter, Double endFilter);
}
