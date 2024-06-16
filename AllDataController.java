package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AllDataController {

    @FXML
    private TableView<PIBData> tableView;

    @FXML
    private TableColumn<PIBData, Integer> yearColumn;

    @FXML
    private TableColumn<PIBData, Double> gdpColumn;

    @FXML
    public void initialize() {
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        gdpColumn.setCellValueFactory(new PropertyValueFactory<>("gdp"));

        ObservableList<PIBData> data = FXCollections.observableArrayList();

        try {
            // MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connecting database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassignment1", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT year, gdp FROM pib_colombia");

            // Adding data to the list
            while (resultSet.next()) {
                int year = resultSet.getInt("year");
                double gdp = resultSet.getDouble("gdp");
                data.add(new PIBData(year, gdp));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tableView.setItems(data);
    }
}
