package des.home.services;

import des.home.domain.Product;
import des.home.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product findById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
