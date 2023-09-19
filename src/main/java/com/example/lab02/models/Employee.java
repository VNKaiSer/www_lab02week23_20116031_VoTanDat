package com.example.lab02.models;

import com.example.lab02.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "employees")
@AttributeOverride(name = "Id", column = @Column(name = "employee_id"))
public class Employee extends Person{
    @Column(name = "status", columnDefinition = "enum('ACTIVE', 'IN_ACTIVE', 'TERMINATE')")
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;



}
