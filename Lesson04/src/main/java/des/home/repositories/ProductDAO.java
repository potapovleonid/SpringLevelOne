package des.home.repositories;

import des.home.domain.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void update(Product product);
    void remove(Product product);
}
