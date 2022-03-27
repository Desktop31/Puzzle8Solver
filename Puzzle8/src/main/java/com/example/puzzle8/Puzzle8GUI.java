package com.example.puzzle8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Puzzle8GUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Puzzle8GUI.class.getResource("puzzle8view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 500);
        stage.setTitle("Puzzle 8 Solver");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}