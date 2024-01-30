package eu.deltasource.hangman;

public class HangmanApp {
    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        HangmanUI hangmanUI = new HangmanUI();
        BagOfWords bagOfWords = new BagOfWords();
        bagOfWords.addWord("example"); // Add words to the bag

        HangmanGameManager gameManager = new HangmanGameManager(hangmanGame, hangmanUI, bagOfWords);
        gameManager.startNewGame();
        gameManager.runGameLoop();
    }
}