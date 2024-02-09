package eu.deltasource.hangman;

/**
 * See https://stackoverflow.com/questions/57019143/build-executable-jar-with-javafx11-from-maven
 * Wrapper needed, because it seems the "main" class cannot extend the Javafx Application class
 */
public class JavaFxMain {
    public static void main(String[] args) {
        HangmanMain.main(args);
    }
}
