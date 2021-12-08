package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItems extends BaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "quantity", nullable = false, length = 128)
    private double quantity;

    @OneToOne
    @JoinColumn(name = "order_details_id")
    private OrderDetails orderDetailsId;

    @OneToOne
    @JoinColumn(name = "stock_id")
    private Stock stockId;

    public OrderItems() {
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
