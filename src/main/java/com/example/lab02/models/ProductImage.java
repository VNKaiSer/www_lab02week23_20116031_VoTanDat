package com.example.lab02.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @Column(name = "image_id", nullable = false, length = 10)
    private long id;
    private String alternative;
    private String path;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "product_id")
    private Product product;
}
