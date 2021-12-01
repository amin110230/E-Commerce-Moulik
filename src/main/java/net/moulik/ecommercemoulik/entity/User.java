package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 36)
    private UUID id;

    @Column(name = "firstName", nullable = false, length = 128)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 128)
    private String lastName;

    @Column(name = "userName", nullable = false, length = 128)
    private String userName;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "password", nullable = false, length = 128)
    private String mobile;

    @Column(name = "createdAt", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false, length = 128)
    private Date updatedAt;
}
