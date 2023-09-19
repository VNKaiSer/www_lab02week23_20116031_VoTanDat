package com.example.lab02.models;

import com.example.lab02.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Product {
    @Id
    @Column(name = "product_id", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name" ,nullable = false, length = 100)
    private String productName;
    @Column(nullable = false, length = 255)
    private String description;
    @Column(nullable = false, length = 50)
    private String unit;
    @Column(name = "manufacturer_name" ,nullable = false, length = 100)
    private String manufacturerName;
    @Column(name = "status", columnDefinition = "enum('BUSSINESS', 'PAUSE', 'NOT_BUSSINESS')" ,nullable = false, length = 10)
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    @PrimaryKeyJoinColumn(name = "product_id")
    private List<ProductPrice> productPrices;

    @OneToMany(mappedBy = "product")
    @PrimaryKeyJoinColumn(name = "product_id")
    private List<ProductImage> productImages;
}
