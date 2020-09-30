package home.des.domain;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "products_tbl")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long product;
    @Column(name = "price_fld")
    private Double price;
    @Column(name = "title_fld")
    private String title;

    public Product() {
    }

    public Product(Long product,String title , Double price) {
        this.product = product;
        this.price = price;
        this.title = title;
    }

    public static List<Product> getByPrice(List<Product> products, Double start, Double end){
        return products.stream()
                .filter(product-> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }


    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
