package eu.deltasource.hangman;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = Main.class.getResource("/sample.fxml");
        System.out.println("resource: " + resource);
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
