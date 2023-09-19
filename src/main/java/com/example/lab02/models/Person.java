package com.example.lab02.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @Column(nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "full_name", nullable = true, length = 255)
    private String fullName;
    @Column(name = "dob", nullable = true, length = 10)
    private LocalDateTime dob;
    @Column(name = "email", nullable = true, length = 255)
    private String email;
    @Column(name = "phone", nullable = true, length = 11)
    private String phone;
    @Column(name = "address", nullable = true, length = 255)
    private String address;
}
