package com.example.lab02.models;

import com.example.lab02.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@AttributeOverride(name = "Id", column = @Column(name = "customer_id"))
@Setter
@Getter
public class Customer extends Person{
    @Column(name = "status", columnDefinition = "enum('ACTIVE', 'IN_ACTIVE')")
    private CustomerStatus status;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
