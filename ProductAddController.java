package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProductAddController {
//This class provides control over the Product Add Page GUI

    // Ensure ID is generated or obtained correctly
    // Starting from 1
    private static int idCounter = 1;

    //Table
    @FXML
    private TableView<Product> myTable;

    // Text input
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField quantityTextField;

    private MainController mainController;

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }

    /* This will add the information to the table and return to Main GUI page
        How this method works:
        MainController opens the "Add Product" window and passes itself to ProductAddController.
        ProductAddController calls addProductToTable() to update the main TableView in MainController.
        The window closes after adding the product to improve user experience.
     */
    @FXML
    public void AddtoTextTable(ActionEvent event) {
        try {
            // Get user input
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int quantity = Integer.parseInt(quantityTextField.getText());

            // Validate inputs
            if (name.isEmpty() || priceTextField.getText().isEmpty() || quantityTextField.getText().isEmpty()) {
                throw new IllegalArgumentException("All fields must be filled.");
            }

            // Unique ID
            int productID = idCounter++;

            // Create new product
            Product newProduct = new Product(productID, name, quantity, price);

            // Only add to Inventory
            Inventory.addProduct(newProduct);

            // Ensure mainController is not null before adding product
            if (mainController != null) {
                mainController.addProductToTable(newProduct);
            } else {
                System.out.println("Error: MainController reference is null");
            }

            // Clear input fields
            nameTextField.clear();
            priceTextField.clear();
            quantityTextField.clear();

            // This will close the Add Product window and return to Main GUI window once a product was added
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();

            // This will catch multiple exceptions and return an error message
            // I added multiple exceptions as it is common practice to catch exceptions by name if possible
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format");
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Input Error");
            a.setHeaderText("Invalid Number Format");
            a.setContentText("Please enter valid numbers for price and quantity.");
            a.show();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Input Error");
            a.setHeaderText("Missing Fields");
            a.setContentText(e.getMessage());
            a.show();
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Unexpected Error");
            a.setHeaderText("Something went wrong");
            a.setContentText("Please try again.");
            a.show();
        }
    }
}
