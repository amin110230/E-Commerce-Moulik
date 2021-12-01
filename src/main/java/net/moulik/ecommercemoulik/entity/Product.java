package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne() // need clarification
    private ProductCategory productCategoryId;

    @Column(name = "sku", nullable = false, length = 128)
    private String sku;

    @Column(name = "price", nullable = false, length = 128)
    private double price;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;

    @Column(name = "deletedAt", nullable = false, length = 128)
    private Date deletedAt;
}
