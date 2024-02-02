package eu.deltasource.hangman;

import java.util.Scanner;

public class Hangman {

    private int maxErrors;
    private int error;

    public void hangman() {
	switch (error) {
	case 0:
	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |\r\n" + "   |\r\n" + "   |\r\n"
		    + " __|___\r\n" + "/      \\");
	    break;
	case 1:
	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |\r\n" + "   |\r\n"
		    + " __|___\r\n" + "/      \\");
	    break;
	case 2:
	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |     |\r\n" + "   |\r\n"
		    + " __|___\r\n" + "/      \\");
	    break;
	case 3:
	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |    \\|\r\n" + "   |\r\n"
		    + " __|___\r\n" + "/      \\");
	    break;
	case 4:
	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |    \\|/\r\n" + "   |\r\n"
		    + " __|___\r\n" + "/      \\");
	    break;
	case 5:
	    System.out.println("  -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |    \\|/\r\n"
		    + "   |	/\r\n" + " __|___\r\n" + "/      \\");
	    break;
	default:
	    System.out.println("404 error");
	}
    }

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
	    hangman.hangman();
	    System.out.println("Guessed Word: " + hangmanwordguess.getGuessedWord());
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

	    System.out.println();
	    System.out.println("Available Characters: " + hangmanwordguess.getAvailableCharacters());
	    letter = null;
	}

	if (hangman.getError() == hangman.getMaxErrors()) {
	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |    \\|/\r\n"
		    + "   |	/ \\\r\n" + " __|___\r\n" + "/      \\");
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
