package des.home.services;

import des.home.domain.Product;
import des.home.repositories.ProductJpaDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl{
    private final ProductJpaDAORepository productJpaDAORepository;

    public ProductServiceImpl(ProductJpaDAORepository productJpaDAORepository) {
        this.productJpaDAORepository = productJpaDAORepository;
    }

    public List<Product> getProducts(){
        return findAll();
    }

    public List<Product> getByPrice(Integer start, Integer end){
        return productJpaDAORepository.findAll().stream()
                .filter(product -> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingInt(Product::getPrice))
                .collect(Collectors.toList());
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

    @Autowired
    public List<Product> findAll(){
        return productJpaDAORepository.findAll();
    }
}
