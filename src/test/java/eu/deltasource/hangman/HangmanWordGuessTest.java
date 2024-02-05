package eu.deltasource.hangman;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HangmanWordGuessTest {
    HangmanWordGuess hangmanword = new HangmanWordGuess();

    @Test
    public void getGuessedWithOneGuessedCharacter() {
        // given
        hangmanword.setWord("apple");
        List<Character> listOfCharacters = new ArrayList<>();
        listOfCharacters.add('a');
        hangmanword.setGuessedCharacters(listOfCharacters);
        // When
        String result = hangmanword.getGuessedWord();

        // Then
        assertThat(result).isEqualTo("a----");
    }

    @Test
    public void getGuessedWithNoGuessedCharacter() {
        // given
        hangmanword.setWord("work");
        List<Character> listOfCharacters = new ArrayList<>();
        listOfCharacters.add('a');
        listOfCharacters.add('h');
        hangmanword.setGuessedCharacters(listOfCharacters);

        // When
        String result = hangmanword.getGuessedWord();

        // Then
        assertThat(result).isEqualTo("----");
    }

    @Test
    public void getGuessedWithAllGuessedCharacter() {
        // given
        hangmanword.setWord("work");
        List<Character> listOfCharacters = new ArrayList<>();
        listOfCharacters.add('w');
        listOfCharacters.add('o');
        listOfCharacters.add('r');
        listOfCharacters.add('k');
        hangmanword.setGuessedCharacters(listOfCharacters);

        // When
        String result = hangmanword.getGuessedWord();

        // Then

        assertThat(result).isEqualTo("work");
    }

    @Test
    public void getGuessTrue() {
        // Given
        hangmanword.setWord("work");

        // When
        boolean guessCharacter = hangmanword.guessCharacter('o');

        // Then
        assertThat(guessCharacter).isTrue();
    }

    @Test
    public void getGuessFalse() {
        // Given
        hangmanword.setWord("work");

        // When
        boolean guessCharacter = hangmanword.guessCharacter('a');

        // Then
        assertThat(guessCharacter).isFalse();
    }

    @Test
    public void removeOneAvailableCharacter() {
        // Given
        hangmanword.guessCharacter('a');

        // When
        String result = hangmanword.getAvailableCharacters();

        // Then
        assertThat(result).isEqualTo("bcdefghijklmnopqrstuvwxyz");
    }

    @Test
    public void removeTwoAvailableCharacter() {
        // Given
        hangmanword.guessCharacter('a');
        hangmanword.guessCharacter('c');

        // When
        String result = hangmanword.getAvailableCharacters();

        // Then
        assertThat(result).isEqualTo("bdefghijklmnopqrstuvwxyz");

    }
}
