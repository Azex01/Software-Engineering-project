package com.example.sweproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
public class kfupmProject extends Application {

    static Page page = new Page();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(kfupmProject.class.getResource("KFUPMProject.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KFUPMProject");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws IOException {
        launch();
    }
}