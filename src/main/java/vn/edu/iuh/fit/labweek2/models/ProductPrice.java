package vn.edu.iuh.fit.labweek2.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice implements Serializable {
    @Id
    @Column(name = "price_date_time", columnDefinition = "datetime(6)")
    private LocalDateTime priceDateTime;
    @Column(columnDefinition = "varchar(255)")
    private String note;
    @Column(nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductPrice() {
    }
}
