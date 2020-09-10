package des.home.service;

import des.home.domain.Product;
import des.home.repository.ProductImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl {

    private ProductImpl productImpl;

    public ProductServiceImpl(ProductImpl productImpl) {
        this.productImpl = productImpl;
    }

    public Product getById(int id){
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

    public void removeProduct(int id){
        productImpl.removeProduct(id);
    }
}
