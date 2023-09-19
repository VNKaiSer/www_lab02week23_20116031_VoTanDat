package com.example.lab02.models;

import com.example.lab02.enums.EmployeeStatus;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
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



}
