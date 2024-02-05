package eu.deltasource.hangman;

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
    public int teller =0;
    
    public void initialize() {
	hangman = new Hangman();
	hangmanwordguess = new HangmanWordGuess();
	printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_1.png"));
	geussedWord.setText(hangmanwordguess.getGuessedWord());
	availableChar.setText(hangmanwordguess.getAvailableCharacters());
    }
    
    public void Guess() {
	    Character character = null;
	    	if(teller == 0) {
	    	    
	    if (letter.getText().length() == 1) {
		character = letter.getText().charAt(0);
	    } else {
		print.setText("only one letter please");
	    }
	    
	    if (hangmanwordguess.guessCharacter(character) == false) {
		hangman.setError(hangman.getError() + 1);
	    }
	    availableChar.setText(hangmanwordguess.getAvailableCharacters());
	    geussedWord.setText(hangmanwordguess.getGuessedWord());
	   // print.setText(String.valueOf(hangman.getError()));
	    letter.clear();
	    
	    if(hangman.getError() == 0) {
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_1.png"));
	    }
	    else if(hangman.getError() == 1) {
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_2.png"));
	    }
	    else if(hangman.getError() == 2) {
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_3.png"));
	    }
	    else if(hangman.getError() == 3) {
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_4.png"));
	    }
	    else if(hangman.getError() == 4) {
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_5.png"));
	    }
	    else if(hangman.getError() == 5) {
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_6.png"));
	    }
	    else if(hangman.getError() == 6) {
		printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_7.png"));
	    }
	
	if (hangman.getError() == hangman.getMaxErrors()) {
	    printGallow.setImage(new Image("eu/deltasource/hangman/foto/galg_7.png"));
	    print.setText("You lose The word was: " + hangmanwordguess.getWord());
	    teller++;
	} else if(hangmanwordguess.getWord().equals(geussedWord.getText())){
	    print.setText("You win");
	    teller++;
	}
	else {
	    print.setText("");
	}
	    	}
	    	else {
	    	    
	    	}
    }
    
    public void Stop() {
	System.exit(0);
    }
}
