package eu.deltasource.hangman;

import java.util.Scanner;

public class HangmanGame {
    private static final int MAX_INCORRECT_GUESSES = 6;
    private final HangmanWord hangmanWord;
    private int incorrectGuesses;
    private GameState gameState;

    public HangmanGame() {
        this.hangmanWord = new HangmanWord();
        this.incorrectGuesses = 0;
        this.gameState = GameState.ONGOING;
    }

    public void startNewGame(String secretWord) {
        hangmanWord.initializeWord(secretWord);
        incorrectGuesses = 0;
        gameState = GameState.ONGOING;
    }

    public void makeGuess(char letter) {
        if (!hangmanWord.isWordGuessed()) {
            hangmanWord.makeGuess(letter);

            if (hangmanWord.isWordGuessed()) {
                gameState = GameState.WON;
            } else if (!hangmanWord.getSecretWord().contains(String.valueOf(letter))) {
                incorrectGuesses++;

                if (incorrectGuesses >= MAX_INCORRECT_GUESSES) {
                    gameState = GameState.LOST;
                }
            }
        }
    }

    public boolean isGameOver() {
        return gameState != GameState.ONGOING;
    }

    public boolean isGameWon() {
        return gameState == GameState.WON;
    }

    public void displayGameState() {
        HangmanUI hangmanUI = new HangmanUI();
        hangmanUI.displayGameState(this);
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public char getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your guess: ");
        String userInput = scanner.nextLine().toLowerCase();

        while (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
            System.out.println("Invalid input. Please enter a single letter.");
            System.out.print("Enter your guess: ");
            userInput = scanner.nextLine().toLowerCase();
        }

        return userInput.charAt(0);
    }

    public HangmanWord getHangmanWord() {
        return hangmanWord;
    }

    private enum GameState {
        ONGOING,
        WON,
        LOST
    }
}
