package net.moulik.ecommercemoulik.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    /*@OneToOne(mappedBy = "supplierId", orphanRemoval = true, fetch = FetchType.LAZY)
    private Purchase purchase;*/

    public Supplier() {
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

}
