package eu.deltasource.hangman;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

  // group your variables together. Put all view-related components together, put all model-related components together.
  public Label geussedWord; // typo
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
    printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_1.png").getFile()));
    geussedWord.setText(hangmanwordguess.getGuessedWord());
    availableChar.setText(hangmanwordguess.getAvailableCharacters());
    restart.setVisible(false);
  }

  public void guess() {
    Character character = null;
    if (teller == 0) {

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
      letter.clear();

      switch (hangman.getError()) {
        case 0:
          printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_1.png").getFile()));
          break;
        case 1:
          printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_2.png").getFile()));
          break;
        case 2:
          printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_3.png").getFile()));
          break;
        case 3:
          printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_4.png").getFile()));
          break;
        case 4:
          printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_5.png").getFile()));
          break;
        case 5:
          printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_6.png").getFile()));
          break;
        case 6:
          printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_7.png").getFile()));
      }

      if (hangman.getError() == hangman.getMaxErrors()) {
        print.setText("You lose The word was: " + hangmanwordguess.getWord());
        teller++;
        restart.setVisible(true);
      } else if (hangmanwordguess.getWord().equals(geussedWord.getText())) {
        print.setText("You win");
        teller++;
        restart.setVisible(true);
      } else {
        print.setText("");
      }
    } else {

    }
  }

  public void stop() {
    teller++;
    restart.setVisible(true);
    print.setText("You lose The word was: " + hangmanwordguess.getWord());
  }

  public void restart() {
    teller = 0;
    hangman.setError(0);
    printGallow.setImage(new Image(this.getClass().getClassLoader().getResource("galg_1.png").getFile()));
    hangmanwordguess = new HangmanWordGuess();
    geussedWord.setText(hangmanwordguess.getGuessedWord());
    availableChar.setText(hangmanwordguess.getAvailableCharacters());
    print.setText("");
    restart.setVisible(false);
  }
}
