package eu.deltasource.hangman;

import java.util.ArrayList;
import java.util.List;

public class HangmanWordGenerator {

    private List<String> wordList = new ArrayList<String>();

    public HangmanWordGenerator() {
	wordList.add("work");
	wordList.add("school");
	wordList.add("apple");
	wordList.add("hangman");
	wordList.add("guess");
	wordList.add("word");

    }

    public String getWord() {
	return wordList.get((int) (Math.random() * wordList.size()));
    }

}