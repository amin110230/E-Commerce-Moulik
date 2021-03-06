package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "stocks")
public class Stock extends BaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "quantity", nullable = false, length = 128)
    private double quantity;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchaseId;

    /*@OneToOne(mappedBy = "stockId", orphanRemoval = true, fetch = FetchType.LAZY)
    private OrderItems orderItems;

    @OneToOne(mappedBy = "stockId", orphanRemoval = true, fetch = FetchType.LAZY)
    private PaymentDetails paymentDetails;*/

    public Stock() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
