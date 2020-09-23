package com.example.Lesson06.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long product_id;
    private String title_fld;
    private Float price_fld;

    public Product() {
    }

    public Product(Long product_id, String title_fld, Float price_fld) {
        this.product_id = product_id;
        this.title_fld = title_fld;
        this.price_fld = price_fld;
    }

    public static List<Product> getByPrice(List<Product> products, Double start, Double end){
        return products.stream()
                .filter(product-> product.getPrice_fld() >= start && product.getPrice_fld() <= end)
                .sorted(Comparator.comparingDouble(Product::getPrice_fld))
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

    public Float getPrice_fld() {
        return price_fld;
    }

    public void setPrice_fld(Float price_fld) {
        this.price_fld = price_fld;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", title_fld='" + title_fld + '\'' +
                ", price_fld=" + price_fld +
                '}';
    }
}
