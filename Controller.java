package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    public void initialize() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("PIB");
        //Connecting Database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaassignment1", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT year, gdp FROM pib_colombia");

            while (resultSet.next()) {
                String year = String.valueOf(resultSet.getInt("year"));
                double gdp = resultSet.getDouble("gdp");
                series.getData().add(new XYChart.Data<>(year, gdp));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        barChart.getData().add(series);
    }
}
