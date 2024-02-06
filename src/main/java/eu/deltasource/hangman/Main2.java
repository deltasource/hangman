package eu.deltasource.hangman;
import java.io.FileNotFoundException;
import java.util.Scanner;

import eu.deltasource.hangman.Hangman;
import eu.deltasource.hangman.HangmanWordGuess;

public class Main2 {

    public static void main(String[] args) throws FileNotFoundException {
   	Hangman hangman = new Hangman();
   	HangmanWordGuess hangmanwordguess = new HangmanWordGuess();
   	//System.out.println(hangmanwordguess.getWord());
   	System.out.println("If you want to stop te game click '-'");
   	Scanner scanner = new Scanner(System.in);
   	Character character = null;
   	String letter;
   	
   	Runtime.getRuntime().addShutdownHook(new Thread()
           {
               @Override
               public void run()
               {
                   System.out.println("Shutdown hook ran!");
               }
           });

   	while (!hangmanwordguess.getGuessedWord().equals(hangmanwordguess.getWord())
   		&& hangman.getError() != hangman.getMaxErrors()) {
   	    hangman.printGallow(hangman.getError());;
   	    System.out.println("Guessed Word: " + hangmanwordguess.getGuessedWord());
   	    System.out.println("Pick a letter");
   	    letter = scanner.next();
   	    
   	    if(letter.equals("-")) {
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

   	if (hangman.getError() == hangman.getMaxErrors()) {
   	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |    \\|/\r\n"
   		    + "   |	/ \\\r\n" + " __|___\r\n" + "/      \\");
   	    System.out.println("You lose The word was: " + hangmanwordguess.getWord());
   	} else {
   	    System.out.println("You win");
   	    System.out.println("The word is: " + hangmanwordguess.getWord());
   	}
   	scanner.close();
       }
}
