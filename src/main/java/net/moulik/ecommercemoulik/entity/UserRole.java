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

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToOne()
    @JoinColumn(name = "role_id")
    private Role roleId;

    @Column(name = "created_at", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, length = 128)
    private Date updatedAt;
}
