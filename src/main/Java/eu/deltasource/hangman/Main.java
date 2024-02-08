package eu.deltasource.hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//	Parent root = /*FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../../../../resources/sample.fxml")));*/
//        FXMLLoader.load(getClass().getClassLoader().getResource("/resources/sample.fxml"));
//
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("/resources/sample.fxml"));
        fxmlLoader.setRoot(new AnchorPane());
        Parent root = fxmlLoader.load();
	primaryStage.setTitle("Hangman");
	primaryStage.setScene(new Scene(root));
	primaryStage.show();

    }

    public static void main(String[] args) {
	launch(args);
    }

}
