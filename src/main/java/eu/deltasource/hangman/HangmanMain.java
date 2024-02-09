package eu.deltasource.hangman;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HangmanMain extends Application {
    private Logger log = LoggerFactory.getLogger(HangmanMain.class);
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = HangmanMain.class.getResource("/sample.fxml");
        log.debug("resource: {}", resource);
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
