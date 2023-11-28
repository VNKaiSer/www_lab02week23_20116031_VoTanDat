package com.example.lab02.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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
    @JsonProperty("manufacturer")
    private String manufacturer;
    @JsonProperty("product_image")
    private String productImage;

    public ProductModel() {
    }

    public ProductModel(String name, double price, String description, String unit, String manufacturer, String productImage) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.productImage = productImage;
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

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "{'product_id':" + id + ", 'product_name':" + name + ", 'product_price':" + price + ", 'description':" + description + ", 'unit':" + unit + ", 'manufacturer':" + manufacturer + ", 'product_image':" + productImage + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel that = (ProductModel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
