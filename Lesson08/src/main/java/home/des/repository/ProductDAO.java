package home.des.repository;


import home.des.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceBetween(Double startFilter, Double endFilter);
    void deleteProductById(Long id);
}
