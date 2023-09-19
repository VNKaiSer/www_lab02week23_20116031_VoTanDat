package com.example.lab02.models;

import com.example.lab02.enums.EmployeeStatus;
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
public class Employee extends Person{

    private EmployeeStatus status;



}
