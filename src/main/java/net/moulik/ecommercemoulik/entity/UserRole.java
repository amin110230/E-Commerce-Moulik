package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @OneToOne() // need clarification
    private User userId;

    @OneToOne() // need clarification
    private Role roleId;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;
}
