package com.example.project;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    //Table
    @FXML
    private TableView<Product> myTable;

    //Columns
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;
    @FXML
    private TableColumn<Product, Integer> priceColumn;
    @FXML
    private TableColumn<Product, String> createdColumn;
    @FXML
    private TableColumn<Product, String> updatedColumn;

    private MainController viewController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));
        createdColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("createdAt"));
        updatedColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("updatedAt"));

        loadProducts();
    }
    private void loadProducts() {
        ObservableList<Product> products = Inventory.getAllProducts();
        myTable.setItems(products);
    }

    public void setViewController(MainController controller) {
        this.viewController = controller;
    }
}


