module eu.deltasource.hangman {
    requires javafx.controls;
    requires javafx.fxml;

    opens eu.deltasource.hangman to javafx.fxml;
    exports eu.deltasource.hangman;
}