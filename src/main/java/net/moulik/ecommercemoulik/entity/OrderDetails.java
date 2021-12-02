package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "total", nullable = false, length = 128)
    private double total;

    @Column(name = "details", nullable = false, length = 128)
    private String details;

    @Column(name = "status", nullable = false, length = 128)
    private String status;

    @Column(name = "created_at", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, length = 128)
    private Date updatedAt;

    @Column(name = "deleted_at", nullable = false, length = 128)
    private Date deletedAt;

    @OneToOne(mappedBy = "orderDetailsId", orphanRemoval = true, fetch = FetchType.LAZY)
    private OrderItems orderItems;

    @OneToOne(mappedBy = "orderDetailsId", orphanRemoval = true, fetch = FetchType.LAZY)
    private PaymentDetails paymentDetails;

    public OrderDetails() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
