package com.example.lab02.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "orders")
//@NamedQueries({
//    @NamedQuery(name = "", query = "SELECT o FROM Order o WHERE o.status = :status")
//})
public class Order {
    @Id
    @Column(name = "order_id", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("order_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonProperty("customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonProperty("employee_id")
    private Employee employee;

    @JsonProperty("order_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order() {

    }

    public Order(Customer customer, Employee employee, LocalDateTime orderDate) {
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
    }
}
