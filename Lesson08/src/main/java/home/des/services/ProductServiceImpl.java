package home.des.services;


import home.des.domain.Product;
import home.des.repository.ProductDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                new Product(null, 15.25, "Bread"),
                new Product(null, 16.35, "Butter"),
                new Product(null, 5.05, "Apple"),
                new Product(null, 10.50, "Orange")
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
    @Transactional
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public List<Product> getByPrice(Double startFilter, Double endFilter) {
        return productDAO.findAllByPriceBetween(startFilter, endFilter);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productDAO.deleteProductById(id);
    }
}
