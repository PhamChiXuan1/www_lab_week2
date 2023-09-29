package vn.edu.iuh.fit.labweek2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.labweek2.enums.ProductStatus;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
@NamedQueries(@NamedQuery(name = "Product.findAll",query = "select p from  Product p where p.status = ?1"))
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    @Column(name = "name", columnDefinition = "varchar(150)", nullable = false)
    private String name;
    @Column(name = "description", columnDefinition = "varchar(250)", nullable = false)
    private String description;
    @Column(name = "unit", columnDefinition = "varchar(25)", nullable = false)
    private String unit;
    @Column(name = "manufacturer_name", columnDefinition = "varchar(100)", nullable = false)
    private String manufacturerName;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;
    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;
    @OneToMany(mappedBy = "product")
    private Set<ProductPrice> productPrices;

    public Product() {
    }

    public Product(long id, String name, String description, String unit, String manufacturerName, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

    public Product(String name, String description, String unit, String manufacturerName, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Set<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public Set<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }
}
