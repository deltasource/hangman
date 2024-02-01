package eu.deltasource.hangman;

import java.util.Scanner;

public class Hangman {

    private int maxErrors;
    private int error;

    public Hangman() {
	setMaxErrors(6);
	error = 0;
    }

    public static void main(String[] args) {
	Hangman hangman = new Hangman();
	HangmanWordGuess hangmanwordguess = new HangmanWordGuess();
	System.out.println(hangmanwordguess.getWord());
	Scanner scanner = new Scanner(System.in);
	Character character = null;
	String letter;

	while (!hangmanwordguess.getGuessedWord().equals(hangmanwordguess.getWord())
		&& hangman.getError() != hangman.getMaxErrors()) {
	    System.out.println("Pick a letter");
	    letter = scanner.next();

	    if (letter.length() == 1) {
		character = letter.charAt(0);
	    } else {
		System.out.println("only one lettre please");
		continue;
	    }

	    if (hangmanwordguess.guessCharacter(character) == false) {
		hangman.setError(hangman.getError() + 1);
	    }

	    System.out.println("Guessed Word: " + hangmanwordguess.getGuessedWord());
	    System.out.println();
	    System.out.println("Available Characters: " + hangmanwordguess.getAvailableCharacters());
	}

	if (hangman.getError() == hangman.getMaxErrors()) {
	    System.out.println("You lose The word was: " + hangmanwordguess.getWord());
	} else {
	    System.out.println("You win");
	}

    }

    public int getError() {
	return error;
    }

    public void setError(int error) {
	this.error = error;
    }

    public int getMaxErrors() {
	return maxErrors;
    }

    public void setMaxErrors(int maxErrors) {
	this.maxErrors = maxErrors;
    }
}
