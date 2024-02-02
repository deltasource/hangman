package eu.deltasource.hangman;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class HangmanWordGuessTest {
    HangmanWordGuess hangmanword = new HangmanWordGuess();

    @Test
    public void getGuessedWithOneGuessedCharacter() {
	// given
	hangmanword.setWord("apple");
	List<Character> listOfCharacters = new ArrayList<Character>();
	listOfCharacters.add('a');
	hangmanword.setGuessedCharacters(listOfCharacters);
	// When
	String result = hangmanword.getGuessedWord();

	// Then

	assertEquals("a----", result);
    }

    @Test
    public void getGuessedWithNoGuessedCharacter() {
	// given
	hangmanword.setWord("work");
	List<Character> listOfCharacters = new ArrayList<Character>();
	listOfCharacters.add('a');
	listOfCharacters.add('h');
	hangmanword.setGuessedCharacters(listOfCharacters);

	// When
	String result = hangmanword.getGuessedWord();

	// Then

	assertEquals("----", result);
    }

    @Test
    public void getGuessedWithAllGuessedCharacter() {
	// given
	hangmanword.setWord("work");
	List<Character> listOfCharacters = new ArrayList<Character>();
	listOfCharacters.add('w');
	listOfCharacters.add('o');
	listOfCharacters.add('r');
	listOfCharacters.add('k');
	hangmanword.setGuessedCharacters(listOfCharacters);

	// When
	String result = hangmanword.getGuessedWord();

	// Then

	assertEquals("work", result);
    }

    @Test
    public void getGuessTrue() {
	// Given
	hangmanword.setWord("work");

	// When
	boolean guessCharacter = hangmanword.guessCharacter('o');
	
	// Then
	assertTrue(guessCharacter);
    }

    @Test
    public void getGuessFalse() {
	// Given
	hangmanword.setWord("work");
	
	// When
	boolean guessCharacter = hangmanword.guessCharacter('a');
	
	// Then
	assertFalse(guessCharacter);
    }
    
    @Test
    public void removeOneAvailableCharacter() {
	// Given
	hangmanword.guessCharacter('a');
	
	// When
	String result = hangmanword.getAvailableCharacters();
	
	// Then
	assertEquals("bcdefghijklmnopqrstuvwxyz", result);
    }
    
    @Test
    public void removeTwoAvailableCharacter() {
	// Given
	hangmanword.guessCharacter('a');
	hangmanword.guessCharacter('c');
	
	// When
	String result = hangmanword.getAvailableCharacters();
	
	// Then
	assertEquals("bdefghijklmnopqrstuvwxyz", result);
    }
}
