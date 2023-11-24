package com.example.lab02.models;

import com.example.lab02.enums.ProductStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@Entity
@NamedQueries({
    @NamedQuery(name = "Product.getProductsActive", query = "SELECT p FROM Product p WHERE p.status = :status"),
    @NamedQuery(name = "Product.deleteProduct", query = "UPDATE Product p SET p.status = 'IN_ACTIVE' WHERE p.id = :id")
})
public class Product {
    @Id
    @Column(name = "product_id", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("product_id")
    private long id;

    @Column(name = "product_name" ,nullable = false, length = 100)
    @JsonProperty("product_name")
    private String productName;

    @Column(nullable = false, length = 255)
    @JsonProperty("description")
    private String description;

    @Column(nullable = false, length = 50)
    @JsonProperty("unit")
    private String unit;

    @Column(name = "manufacturer_name" ,nullable = false, length = 100)
    @JsonProperty("manufacturer_name")
    private String manufacturerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('ACTIVE', 'IN_ACTIVE', 'TERMINATE')" ,nullable = false, length = 10)
    @JsonProperty("status")
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    @PrimaryKeyJoinColumn(name = "product_id")
    private List<ProductPrice> productPrices;

    @OneToMany(mappedBy = "product")
    @PrimaryKeyJoinColumn(name = "product_id")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    public Product(){}

    public Product(String productName, String description, String unit, String manufacturerName, ProductStatus status) {
        this.productName = productName;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
