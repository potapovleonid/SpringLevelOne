package des.home.services;

import des.home.domain.Product;
import des.home.repositories.ProductDAO;
import des.home.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductDAO {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    @Transactional
    public void remove(Product product) {
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
