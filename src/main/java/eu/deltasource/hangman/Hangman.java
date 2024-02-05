package eu.deltasource.hangman;

import java.util.Scanner;

public class Hangman {

    private int maxErrors;
    private static final int MAX_ERRORS = 6;
    private static int error;

    private static HangmanDraw hangmanDraw;


    public Hangman() {
        hangmanDraw = new HangmanDraw();
        error = 0;
    }


    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        HangmanWordGuess hangmanwordguess = new HangmanWordGuess();

        System.out.println("If you want to stop te game click '-'");

        Scanner scanner = new Scanner(System.in);
        char character;
        String letter;

        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Shutdown hook ran!")));

        while (!hangmanwordguess.getGuessedWord().equals(hangmanwordguess.getWord())
                && hangman.getError() != MAX_ERRORS) {
            hangmanDraw.printGallows(error);
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

            if (!hangmanwordguess.guessCharacter(character)) {
                hangman.setError(hangman.getError() + 1);
            }

            System.out.println();
            System.out.println("Available Characters: " + hangmanwordguess.getAvailableCharacters());

        }

        if (hangman.getError() == MAX_ERRORS) {
            hangmanDraw.printGallows(MAX_ERRORS);
            System.out.println("You lose The word was: " + hangmanwordguess.getWord());
        } else {
            System.out.println("You win");
            System.out.println("The word is: " + hangmanwordguess.getWord());
        }
        scanner.close();
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        Hangman.error = error;
    }

}
