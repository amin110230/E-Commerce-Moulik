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

    @OneToOne() // need clarification
    private Supplier supplierId;

    @OneToMany() // need clarification
    private List<Product> products;

    @OneToOne() // need clarification
    private User userId;

    @Column(name = "quantity", nullable = false, length = 128)
    private int quantity;

    @Column(name = "unitPrice", nullable = false, length = 128)
    private double unitPrice;

    @Column(name = "total", nullable = false, length = 128)
    private double total;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;
}
