package com.example.lab02.backend.models;

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

    public LocalDateTime getId() {
        return id;
    }

    public void setId(LocalDateTime id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", price=" + price +
                ", node='" + node + '\'' +
//                ", product=" + product +
                '}';
    }
}
