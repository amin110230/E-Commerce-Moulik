package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_role_mapping")
public class UserRoleMapping {
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
}
