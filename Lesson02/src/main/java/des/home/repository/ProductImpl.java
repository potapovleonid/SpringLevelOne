package des.home.repository;

import des.home.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductImpl {
    private HashMap<Long, Product> products = new HashMap<>();
    private long id = 0;

    {
        products.put(++id, new Product(id, "Cheese", 635.5));
        products.put(++id, new Product(id, "Milk", 66.0));
        products.put(++id, new Product(id, "Chocolate", 96.0));
        products.put(++id, new Product(id, "Bread", 39.0));
        products.put(++id, new Product(id, "Beer", 88.0));
    }

    public Product getById(long id){
        return products.get(id);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void removeProduct(long id){
        products.remove(id);
    }

    public Product save(Product product){
        if(product.getId() == null){
            product.setId(++id);
        }
        products.put(product.getId(), product);
        return product;
    }
}
