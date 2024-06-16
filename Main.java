package com.example.assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PIB de Colombia");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));

        // Button to change the view
        Button barChartButton = new Button("Ver Gráfico de Barras");
        barChartButton.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pib_colombia.fxml"));
                Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Button to change the view
        Button tableViewButton = new Button("Ver Datos en Tabla");
        tableViewButton.setOnAction(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("all_data_view.fxml"));
                Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox vBox = new VBox(barChartButton, tableViewButton);
        Scene initialScene = new Scene(vBox, 300, 200);

        primaryStage.setScene(initialScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
