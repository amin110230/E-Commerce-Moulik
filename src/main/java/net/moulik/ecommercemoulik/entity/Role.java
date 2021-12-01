package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;

    @Column(name = "deletedAt", nullable = false, length = 128)
    private Date deletedAt;
}
