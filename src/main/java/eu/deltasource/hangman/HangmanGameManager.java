package eu.deltasource.hangman;

import java.util.Scanner;

public class HangmanGameManager {
    private final HangmanGame hangmanGame;
    private final HangmanUI hangmanUI;
    private final BagOfWords bagOfWords;

    public HangmanGameManager(HangmanGame hangmanGame, HangmanUI hangmanUI, BagOfWords bagOfWords) {
        this.hangmanGame = hangmanGame;
        this.hangmanUI = hangmanUI;
        this.bagOfWords = bagOfWords;
    }

    public void startNewGame() {
        hangmanGame.startNewGame(bagOfWords.getRandomWord());
    }

    public void playGame() {
        hangmanUI.displayGameState(hangmanGame);
        while (!hangmanGame.isGameOver()) {
            char userGuess = hangmanGame.getUserInput();
            hangmanGame.makeGuess(userGuess);
            hangmanUI.displayGameState(hangmanGame);
        }

        if (hangmanGame.isGameWon()) {
            hangmanUI.displayWinScreen();
        } else {
            hangmanUI.displayLossScreen(hangmanGame.getHangmanWord().getSecretWord());
        }

        promptForNewGame();
    }

    private void promptForNewGame() {
        System.out.println("Press any key to start a new game.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Wait for any key press
        startNewGame();
        playGame();
    }

    public void runGameLoop() {
        hangmanUI.displayRules();
        promptForNewGame();
    }
}
