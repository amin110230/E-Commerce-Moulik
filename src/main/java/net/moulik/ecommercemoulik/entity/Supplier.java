package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "firstName", nullable = false, length = 128)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 128)
    private String lastName;

    @Column(name = "mobile", nullable = false, length = 128)
    private String mobile;

    @Column(name = "Address", nullable = false, length = 128)
    private String Address;

    @Column(name = "created_at", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, length = 128)
    private Date updatedAt;

    @OneToOne(mappedBy = "supplierId", orphanRemoval = true, fetch = FetchType.LAZY)
    private Purchase purchase;
}
