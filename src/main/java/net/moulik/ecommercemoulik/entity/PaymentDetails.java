package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "payment_details")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @OneToOne() // need clarification
    private OrderDetails orderDetailsId;

    @OneToOne() // need clarification
    private Stock stockId;

    @Column(name = "amount", nullable = false, length = 128)
    private double amount;

    @Column(name = "provider", nullable = false, length = 128)
    private String provider;

    @Column(name = "status", nullable = false, length = 128)
    private String status;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;
}
