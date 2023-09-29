package vn.edu.iuh.fit.labweek2.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(nullable = false)
    private double quantity;
    @Column(nullable = false)
    private double price;
    @Column(columnDefinition = "VARCHAR(255)")
    private String note;

    public OrderDetail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return Double.compare(quantity, that.quantity) == 0 && Double.compare(price, that.price) == 0 && Objects.equals(orders, that.orders) && Objects.equals(product, that.product) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, product, quantity, price, note);
    }
}
