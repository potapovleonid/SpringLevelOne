package des.home.services;

import des.home.domain.Product;
import des.home.repositories.ProductJpaDAORepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl{
    private final ProductJpaDAORepository productJpaDAORepository;

    public ProductServiceImpl(ProductJpaDAORepository productJpaDAORepository) {
        this.productJpaDAORepository = productJpaDAORepository;
    }

    @Transactional
    public void save(Product product) {
        productJpaDAORepository.save(product);
    }

    @Transactional
    public void update(Product product) {
        productJpaDAORepository.saveAndFlush(product);
    }

    @Transactional
    public void remove(Product product) {
        productJpaDAORepository.delete(product);
    }

    @Transactional
    public Product findById(Long id){
        return productJpaDAORepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Product> findAll(){
        return productJpaDAORepository.findAll();
    }
}
