package com.example.lab02.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    public Person(long id){
        this.Id = id;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
