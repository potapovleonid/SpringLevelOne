package des.home.domain;

public class Product {

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
