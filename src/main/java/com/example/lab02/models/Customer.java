package com.example.lab02.models;

import com.example.lab02.enums.CustomerStatus;
import com.example.lab02.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "customers")
@AttributeOverride(name = "Id", column = @Column(name = "customer_id"))
@Setter
@Getter
public class Customer extends Person{
    @Column(name = "status", columnDefinition = "enum('ACTIVE', 'IN_ACTIVE')")
    @JsonProperty("status")
    private CustomerStatus status;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(String fullName, LocalDateTime dob, String email, String phone, String address, CustomerStatus status) {
        super(fullName, dob, email, phone, address);
        this.status = status;
    }
}
