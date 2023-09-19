package com.example.lab02.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductPrice {
    @Id
    @Column(name = "price_date_time", nullable = false, length = 10)
    private LocalDateTime id;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "node", nullable = true, length = 100)
    private String node;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @JoinColumn(name = "product_id")
    private Product product;

}
