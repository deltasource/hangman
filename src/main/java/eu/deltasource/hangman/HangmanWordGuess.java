package eu.deltasource.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HangmanWordGuess {

    private List<Character> guessedCharacters = new ArrayList<Character>();
    private String word;
    private List<Character> listOfAvailableCharacters = new ArrayList<Character>();
    public HangmanWordGenerator hangmanword = new HangmanWordGenerator();

    public HangmanWordGuess() {
	listOfAvailableCharacters.addAll(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
	this.chooseWord();
    }

    private void chooseWord() {
	this.setWord(hangmanword.getWord());
    }

    public boolean guessCharacter(Character character) {
	guessedCharacters.add(character);
	listOfAvailableCharacters.remove(character);

	return word.contains(String.valueOf(character));
    }

    public String getGuessedWord() {
	StringBuilder guessedWord = new StringBuilder();
	for (int i = 0; i < word.length(); i++) {
	    if (guessedCharacters.contains(word.charAt(i))) {
		guessedWord.append(word.charAt(i));
	    } else {
		guessedWord.append("-");
	    }
	}

	return guessedWord.toString();

    }

    public String getAvailableCharacters() {
	StringBuilder available = new StringBuilder();
	for (int i = 0; i <= listOfAvailableCharacters.size() - 1; i++) {
	    available.append(listOfAvailableCharacters.get(i).toString());
	}
	return available.toString();
    }

    public List<Character> getGuessedCharacters() {
	return guessedCharacters;
    }

    public void setGuessedCharacters(List<Character> guessedCharacters) {
	this.guessedCharacters = guessedCharacters;
    }

    public String getWord() {
	return word;
    }

    public void setWord(String word) {
	this.word = word;
    }
}
