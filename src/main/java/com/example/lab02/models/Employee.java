package com.example.lab02.models;

import com.example.lab02.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "employees")
@Table(name = "employees")
@AttributeOverride(name = "Id", column = @Column(name = "employee_id"))
public class Employee extends Person{
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('ACTIVE', 'IN_ACTIVE', 'TERMINATE')")
    @JsonProperty("status")
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    public Employee(String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus status) {
        super(fullName, dob, email, phone, address);
        this.status = status;
    }

    public Employee(){
        super();
    }

}
