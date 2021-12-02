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

    @Column(name = "created_at", nullable = false, length = 128)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, length = 128)
    private Date updatedAt;

    @OneToOne(mappedBy = "userId", orphanRemoval = true, fetch = FetchType.LAZY)
    private OrderDetails orderDetails;

    @OneToOne(mappedBy = "userId", orphanRemoval = true, fetch = FetchType.LAZY)
    private Purchase purchase;

    @OneToOne(mappedBy = "userId", orphanRemoval = true, fetch = FetchType.LAZY)
    private UserRole userRole;

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }
}
