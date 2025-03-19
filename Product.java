package com.example.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// This class will read the values of the inputted variable
    //  and save the values
public class Product {
    // declaring variables
    private int idColumn;
    private String nameColumn;
    private double priceColumn;
    private int quantityColumn;
    private String createdAt;
    private String updatedAt;

    // This is the format i want in the table
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Constructor
    public Product(int id, String name, int quantity, double price) {
        this.idColumn = id;
        this.nameColumn = name;
        this.priceColumn = price;
        this.quantityColumn = quantity;
        this.createdAt = LocalDateTime.now().format(formatter); // To set the creation timestamp
        this.updatedAt = LocalDateTime.now().format(formatter); // To set the updated timestamp
    }

    // Getters and setter
    public int getId() {
        return idColumn;
    }

    public String getName() {
        return nameColumn;
    }

    public void setName(String name) {
        this.nameColumn = name;
    }

    public double getPrice() {
        return priceColumn;
    }

    public void setPrice(double price) {
        this.priceColumn = price;
    }

    public int getQuantity() {
        return quantityColumn;
    }

    public void setQuantity(int quantity) {
        this.quantityColumn = quantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(){
        this.updatedAt = LocalDateTime.now().format(formatter);
    }
}
