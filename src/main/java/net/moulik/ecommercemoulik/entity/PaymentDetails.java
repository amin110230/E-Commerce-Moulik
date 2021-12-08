package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "amount", nullable = false, length = 128)
    private double amount;

    @Column(name = "provider", nullable = false, length = 128)
    private String provider;

    @Column(name = "status", nullable = false, length = 128)
    private String status;

    @OneToOne
    @JoinColumn(name = "order_details_id", referencedColumnName = "id")
    private OrderDetails orderDetailsId;

    @OneToOne
    @JoinColumn(name = "stock_id")
    private Stock stockId;

    public PaymentDetails() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderDetails getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(OrderDetails orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Stock getStockId() {
        return stockId;
    }

    public void setStockId(Stock stockId) {
        this.stockId = stockId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
