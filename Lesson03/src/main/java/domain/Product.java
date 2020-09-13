package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products_tbl")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue
    private Integer id;

    @Column(name = "title_fld")
    private String title;

    @Column(name = "price_fld")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
