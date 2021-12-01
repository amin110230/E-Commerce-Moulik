package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @OneToOne() // need clarification
    private Purchase PurchaseId;

    @Column(name = "quantity", nullable = false, length = 128)
    private double quantity;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;

    @Column(name = "deletedAt", nullable = false, length = 128)
    private Date deletedAt;
}
