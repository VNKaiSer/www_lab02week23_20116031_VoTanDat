package com.example.lab02.models;

import jakarta.persistence.Entity;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
@TableGenerator(name = "customer_id", initialValue = 1, allocationSize = 1)
public class Customer extends Person{


}
