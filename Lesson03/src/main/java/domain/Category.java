package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories_tbl")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Integer id;

    @Column(name = "title_fld")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
