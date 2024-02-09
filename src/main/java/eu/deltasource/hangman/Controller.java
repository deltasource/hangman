package eu.deltasource.hangman;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    public Label geussedWord;
    public Label print;
    public TextField letter;
    public Hangman hangman;
    public HangmanWordGuess hangmanwordguess;
    public ImageView printGallow;
    public Label availableChar;
    public Button restart;

    public void initialize() {
        hangman = new Hangman();
        hangmanwordguess = new HangmanWordGuess();
        printGallow.setImage(new Image(gallow(1)));
        geussedWord.setText(hangmanwordguess.getGuessedWord());
        availableChar.setText(hangmanwordguess.getAvailableCharacters());
        restart.setVisible(false);
    }

    public String gallow(int gallow) {
        return "/img/galg_" + gallow + ".png";
    }

    public void guess() {
        Character character = null;
        if (!restart.isVisible()) {

            if (letter.getText().length() == 1) {
                character = letter.getText().charAt(0);
            } else {
                print.setText("only one letter please");
            }

            if (!hangmanwordguess.guessCharacter(character)) {
                hangman.setError(hangman.getError() + 1);
            }

            availableChar.setText(hangmanwordguess.getAvailableCharacters());
            geussedWord.setText(hangmanwordguess.getGuessedWord());
            letter.clear();

            printGallow.setImage(new Image(gallow(hangman.getError() + 1)));

            if (hangman.getError() == hangman.getMaxErrors()) {
                print.setText("You lose The word was: " + hangmanwordguess.getWord());
                restart.setVisible(true);
            } else if (hangmanwordguess.getWord().equals(geussedWord.getText())) {
                print.setText("You win");
                restart.setVisible(true);
            } else {
                print.setText("");
            }
        }
    }

    public void stop() {
        restart.setVisible(true);
        print.setText("You lose The word was: " + hangmanwordguess.getWord());
    }

    public void restart() {
        hangman.setError(0);
        printGallow.setImage(new Image(gallow(1)));
        hangmanwordguess = new HangmanWordGuess();
        geussedWord.setText(hangmanwordguess.getGuessedWord());
        availableChar.setText(hangmanwordguess.getAvailableCharacters());
        print.setText("");
        restart.setVisible(false);
    }
}
