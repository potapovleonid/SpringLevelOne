package com.example.Lesson06.domain;

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
    private Long product_id;
    @Column(name = "price_fld")
    private Double price;
    @Column(name = "title_fld")
    private String title_fld;

    public Product() {
    }

    public Product(Long product_id, String title_fld, Double price) {
        this.product_id = product_id;
        this.title_fld = title_fld;
        this.price = price;
    }

    public static List<Product> getByPrice(List<Product> products, Double start, Double end){
        return products.stream()
                .filter(product-> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getTitle_fld() {
        return title_fld;
    }

    public void setTitle_fld(String title_fld) {
        this.title_fld = title_fld;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price_fld) {
        this.price = price_fld;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", title_fld='" + title_fld + '\'' +
                ", price_fld=" + price +
                '}';
    }
}
