package eu.deltasource.hangman;

import java.util.HashSet;
import java.util.Set;

public class HangmanWord {
    private String secretWord;
    private Set<Character> guessedLetters;

    public void initializeWord(String secretWord) {
        this.secretWord = secretWord;
        this.guessedLetters = new HashSet<>();
    }

    public void displayWord() {
        for (char letter : secretWord.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    public void makeGuess(char letter) {
        guessedLetters.add(letter);
    }

    public boolean isWordGuessed() {
        for (char letter : secretWord.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    public String getSecretWord() {
        return secretWord;
    }
}