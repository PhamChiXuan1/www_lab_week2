package vn.edu.iuh.fit.labweek2.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customer")
@NamedQueries(@NamedQuery(name = "Customer.findAll",query = "select c from Customer c"))
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long id;

    @Column(name = "cust_name", nullable = false, columnDefinition = "VARCHAR(150)")
    private String custName;
    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(150)")
    private String email;
    @Column(name = "phone", nullable = false, columnDefinition = "VARCHAR(15)")
    private String phone;
    @Column(name = "address", nullable = false, columnDefinition = "VARCHAR(250)")
    private String address;
    @OneToMany(mappedBy = "customer")
    private Set<Orders> orders;

    public Customer() {
    }

    public Customer(long id, String custName, String email, String phone, String address) {
        this.id = id;
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String custName, String email, String phone, String address) {
        this.custName = custName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustomerName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
