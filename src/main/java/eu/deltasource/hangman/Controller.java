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
    public int teller = 0;

    public void initialize() {
	hangman = new Hangman();
	hangmanwordguess = new HangmanWordGuess();
	printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_1.png"));
	geussedWord.setText(hangmanwordguess.getGuessedWord());
	availableChar.setText(hangmanwordguess.getAvailableCharacters());
	restart.setVisible(false);
    }

    public void guess() {
	Character character = null;
	if (teller == 0) {

	    if (letter.getText().length() == 1) {
		character = letter.getText().charAt(0);
	    } else{
		print.setText("only one letter please");
	    }

	    if (hangmanwordguess.guessCharacter(character) == false) {
		hangman.setError(hangman.getError() + 1);
	    }
	    
	    availableChar.setText(hangmanwordguess.getAvailableCharacters());
	    geussedWord.setText(hangmanwordguess.getGuessedWord());
	    letter.clear();

	    switch (hangman.getError()) {
	    case 0:
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_1.png"));
		break;
	    case 1:
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_2.png"));
		break;
	    case 2:
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_3.png"));
		break;
	    case 3:
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_4.png"));
		break;
	    case 4:
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_5.png"));
		break;
	    case 5:
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_6.png"));
		break;
	    case 6:
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_7.png"));
	    }

	    if (hangman.getError() == hangman.getMaxErrors()) {
		print.setText("You lose The word was: " + hangmanwordguess.getWord());
		teller++;
	    } else if (hangmanwordguess.getWord().equals(geussedWord.getText())) {
		print.setText("You win");
		teller++;
	    } else {
		print.setText("");
	    }
	} else {

	}
    }

    public void stop() {
	teller++;
	restart.setVisible(true);
    }
    
    public void restart() {
	teller = 0;
	hangman.setError(0);
	printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_1.png"));
	hangmanwordguess = new HangmanWordGuess();
	geussedWord.setText(hangmanwordguess.getGuessedWord());
	availableChar.setText(hangmanwordguess.getAvailableCharacters());
	restart.setVisible(false);
    }
}
