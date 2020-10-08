package home.des.domain;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "products_tbl")
@SequenceGenerator(name = "product_seq", initialValue = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "product_seq")
    @Column(name = "product_id")
    private Long id;
    @Column(name = "price_fld")
    private Double price;
    @Column(name = "title_fld")
    private String title;

    public Product() {
    }

    public Product(Long id, Double price, String title) {
        this.id = id;
        this.price = price;
        this.title = title;
    }

    public static List<Product> getByPrice(List<Product> products, Double start, Double end){
        return products.stream()
                .filter(product-> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
