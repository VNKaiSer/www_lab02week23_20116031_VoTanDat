package com.example.lab02.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductModel {
    @JsonProperty("product_id")
    private long id;
    @JsonProperty("product_name")
    private  String name;
    @JsonProperty("product_price")
    private double price;
    @JsonProperty("description")
    private String description;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("manufacturer_number")
    private String manufacturer;

    public ProductModel() {
    }

    public ProductModel(String name, double price, String description, String unit, String manufacturer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
