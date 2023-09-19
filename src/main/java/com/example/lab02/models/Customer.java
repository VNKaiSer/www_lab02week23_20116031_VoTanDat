package com.example.lab02.models;

import com.example.lab02.enums.CustomerStatus;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@AttributeOverride(name = "Id", column = @Column(name = "customer_id"))
public class Customer extends Person{
    @Column(name = "status", columnDefinition = "enum('ACTIVE', 'IN_ACTIVE')")
    private CustomerStatus status;
}
