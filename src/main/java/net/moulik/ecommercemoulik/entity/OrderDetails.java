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

    @OneToOne() // need clarification
    private User userId;

    @Column(name = "total", nullable = false, length = 128)
    private double total;

    @Column(name = "details", nullable = false, length = 128)
    private String details;

    @Column(name = "status", nullable = false, length = 128)
    private String status;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;

    @Column(name = "deletedAt", nullable = false, length = 128)
    private Date deletedAt;
}
