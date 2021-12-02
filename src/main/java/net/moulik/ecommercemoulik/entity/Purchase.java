package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @OneToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplierId;

    @OneToMany() // need clarification
    private List<Product> products;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "quantity", nullable = false, length = 128)
    private int quantity;

    @Column(name = "unitPrice", nullable = false, length = 128)
    private double unitPrice;

    @Column(name = "total", nullable = false, length = 128)
    private double total;

    @Column(name = "created_at", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, length = 128)
    private Date updatedAt;

    @OneToOne(mappedBy = "purchaseId", orphanRemoval = true, fetch = FetchType.LAZY)
    private Stock stock;

    public Purchase() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
