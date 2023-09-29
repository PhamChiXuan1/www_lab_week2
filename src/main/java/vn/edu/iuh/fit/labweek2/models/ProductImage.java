package vn.edu.iuh.fit.labweek2.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product_image")
public class ProductImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long id;
    @Column(columnDefinition = "varchar(250)", nullable = false)
    private String path;
    @Column(columnDefinition = "varchar(250)")
    private String alternative;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductImage() {
    }
}
