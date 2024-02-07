package eu.deltasource.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanWordGenerator {

    private List<String> wordList = new ArrayList<String>();
    
    public HangmanWordGenerator(){
	readFile();
    }

    public void readFile(){
	try {
    URL resource = this.getClass().getClassLoader().getResource("wordList.txt");
    File file = new File(resource.getFile());
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                wordList.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error reading word list file: " + e.getMessage());
            System.exit(1); // don't do this in non-main classes: throw an exception here, let main class handle it.
        }
    }
    
    

    public String getWord() {
	return wordList.get((int) (Math.random() * wordList.size()));
    }

}
