package com.example.lab02.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @Column(nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "full_name", nullable = true, length = 255)
    @JsonProperty("full_name")
    private String fullName;

    @Column(name = "dob", nullable = true, length = 10)
    @JsonProperty("dob")
    private LocalDateTime dob;

    @Column(name = "email", nullable = true, length = 255)
    @JsonProperty("email")
    private String email;

    @Column(name = "phone", nullable = true, length = 11)
    @JsonProperty("phone")
    private String phone;

    @Column(name = "address", nullable = true, length = 255)
    @JsonProperty("address")
    private String address;

    public Person(String fullName, LocalDateTime dob, String email, String phone, String address) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Person(){

    }
}
