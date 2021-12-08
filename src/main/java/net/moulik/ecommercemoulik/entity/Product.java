package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product extends BaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "description", nullable = false, length = 128)
    private String description;

    @Column(name = "code", nullable = false, length = 128)
    private String code;

    @Column(name = "size", nullable = false, length = 128)
    private String size;

    @Column(name = "sku", nullable = false, length = 128)
    private String sku;

    @Column(name = "price", nullable = false, length = 128)
    private double price;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @OneToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategoryId;

    public Product() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ProductCategory getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(ProductCategory productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
