package eu.deltasource.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanWordGenerator {

    private List<String> wordList = new ArrayList<String>();
    

    public HangmanWordGenerator() {
	readFile();
    }

    public void readFile() {
	try {
	    File file = new File("../hangman/src/main/resources/wordList.txt");
	    Scanner scanner = new Scanner(file);

	    while (scanner.hasNextLine()) {
		wordList.add(scanner.nextLine());
	    }
	    scanner.close();
	} catch (FileNotFoundException e) {
	    System.err.println("Error reading word list file: " + e.getMessage());
	    System.exit(1);
	}
    }

    public String getWord() {
	return wordList.get((int) (Math.random() * wordList.size()));
    }

}
