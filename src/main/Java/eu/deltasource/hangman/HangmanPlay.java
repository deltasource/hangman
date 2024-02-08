package eu.deltasource.hangman;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangmanPlay {

    public static void main(String[] args) throws FileNotFoundException {
	Hangman hangman = new Hangman();
	HangmanWordGuess hangmanwordguess = new HangmanWordGuess();
	System.out.println("If you want to stop te game click '-'");
	Scanner scanner = new Scanner(System.in);
	Character character = null;
	String letter;

	Runtime.getRuntime().addShutdownHook(new Thread() {
	    @Override
	    public void run() {
		System.out.println("Shutdown hook ran!");
	    }
	});

	while (!hangmanwordguess.getGuessedWord().equals(hangmanwordguess.getWord())
		&& hangman.getError() != hangman.maxErrors(6)) {
	    hangman.printGallow(hangman.getError());
	    System.out.println("Guessed Word: " + hangmanwordguess.getGuessedWord());
	    System.out.println("Pick a letter");
	    letter = scanner.next();

	    if (letter.equals("-")) {
		System.exit(0);
	    }
	    if (letter.length() == 1) {
		character = letter.charAt(0);
	    } else {
		System.out.println("only one letter please");
		continue;
	    }
	    if (hangmanwordguess.guessCharacter(character) == false) {
		hangman.setError(hangman.getError() + 1);
	    }

	    System.out.println();
	    System.out.println("Available Characters: " + hangmanwordguess.getAvailableCharacters());
	    letter = null;
	}

	if (hangman.getError() == hangman.maxErrors(6)) {
	    hangman.printGallow(hangman.getError());
	    System.out.println("You lose The word was: " + hangmanwordguess.getWord());
	} else {
	    System.out.println("You win");
	    System.out.println("The word is: " + hangmanwordguess.getWord());
	}
	scanner.close();
    }
}
