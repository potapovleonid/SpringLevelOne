package home.des.services;

import home.des.domain.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(Long id);

    Product save(Product product);

    List<Product> getByPrice(Double startFilter, Double endFilter);
}
