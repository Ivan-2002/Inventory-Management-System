package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
    //  This will store all the products
    static final ObservableList<Product> allProducts = FXCollections.observableArrayList();

    //  This method will add an input product to the inventory
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    //  This method searches the inventory for a Product by Product ID
    public static Product getProduct(int productId) {
        for (Product product : allProducts) {
            if (product.getId() == productId) {
                // This is for testing purposes to ensure that the system runs correctly or where to find the mistake if it doesn't
                System.out.println("Product found: " + product.getName() + " with ID: " + productId);
                return product;
            }
        }
        // This is for testing purposes to ensure that the system runs correctly or where to find the mistake if it doesn't
        System.out.println("No product found with ID: " + productId);
        return null;
    }

    //  This method will replace a product with a new product
    public static boolean updateProduct(int productId, String newName, int newQuantity, double newPrice) {
        for (Product product : allProducts) {
            if(product.getId() == productId){
                product.setName(newName);
                product.setQuantity(newQuantity);
                product.setPrice(newPrice);
                product.setUpdatedAt();
                return true;
            }
        }
        return false; //encase product was not found
    }

    // this method will get all the products in the table
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    //  This will delete the product by id and no by reference
    public static void deleteProduct(Product selectedProduct) {
        allProducts.removeIf(product -> product.getId() == selectedProduct.getId());
    }
}
