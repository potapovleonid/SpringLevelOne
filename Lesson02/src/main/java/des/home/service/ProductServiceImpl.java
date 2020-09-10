package des.home.service;

import des.home.domain.Product;
import des.home.repository.ProductImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {

    private ProductImpl productImpl;

    public ProductServiceImpl(ProductImpl productImpl) {
        this.productImpl = productImpl;
    }

    public Product getById(long id){
        return productImpl.getById(id);
    }

    public List<Product> getProducts(){
        List<Product> products = productImpl.getProducts();
        products.sort(Comparator.comparing(Product::getId));
        return products;
    }

    public Product save(Product product){
        return productImpl.save(product);
    }

    public void removeProduct(long id){
        productImpl.removeProduct(id);
    }

    public List<Product> getByPrice(Double start, Double end){
        return productImpl.getProducts().stream()
                .filter(product -> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }
}
