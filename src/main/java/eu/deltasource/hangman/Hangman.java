package eu.deltasource.hangman;

import java.util.Scanner;

public class Hangman {

    private int maxErrors;
    private int error;
    
    public Hangman() {
	setMaxErrors(6);
	error = 0;
    }
    
    public String printHead(int error) {
	if(error >= 1) {
	    return "0";
	}
	else if(error ==0) {
	    return "";
	}
	return "";
    }
    
    public String printBody(int error) {
	if(error == 2) {
	    return " |";
	}
	else if(error > 2) {
	    return "|";
	}
	else if(error ==0) {
	    return "";
	}
	return "";
    }
    public String printLeftArm(int error) {
	if(error >= 3) {
	    return "\\";
	}
	else if(error ==0) {
	    return "";
	}
	return "";
    }
    public String printRightArm(int error) {
	if(error >= 4) {
	    return "/";
	}
	else if(error ==0) {
	    return "";
	}
	return "";
    }
    public String printLeftLeg(int error) {
	if(error >= 5) {
	    return "/";
	}
	else if(error ==0) {
	    return "";
	}
	return "";
    }
    public String printRightLeg(int error) {
	if(error >= 6) {
	    return "\\";
	}
	else if(error ==0) {
	    return "";
	}
	return "";
    }

    public void printGallow(int error) {
	System.out.println("   -------");
	System.out.println("   |     |");
	System.out.println("   |     "+printHead(error));
	System.out.println("   |    "+printLeftArm(error)+printBody(error)+printRightArm(error));
	System.out.println("   |	"+printLeftLeg(error)+" "+printRightLeg(error));
	System.out.println(" __|___");
	System.out.println("/      \\");
    }

    public static void main(String[] args) {
	Hangman hangman = new Hangman();
	HangmanWordGuess hangmanwordguess = new HangmanWordGuess();
	//System.out.println(hangmanwordguess.getWord());
	System.out.println("If you want to stop te game click '-'");
	Scanner scanner = new Scanner(System.in);
	Character character = null;
	String letter;
	
	Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Shutdown hook ran!");
            }
        });

	while (!hangmanwordguess.getGuessedWord().equals(hangmanwordguess.getWord())
		&& hangman.getError() != hangman.getMaxErrors()) {
	    hangman.printGallow(hangman.error);;
	    System.out.println("Guessed Word: " + hangmanwordguess.getGuessedWord());
	    System.out.println("Pick a letter");
	    letter = scanner.next();
	    
	    if(letter.equals("-")) {
		System.exit(0);
	    }
	    if (letter.length() == 1) {
		character = letter.charAt(0);
	    } else {
		System.out.println("only one letter please");
		continue;
	    }

	    if (hangmanwordguess.guessCharacter(character) == false) {
		hangman.setError(hangman.getError() + 1);
	    }

	    System.out.println();
	    System.out.println("Available Characters: " + hangmanwordguess.getAvailableCharacters());
	    letter = null;
	}

	if (hangman.getError() == hangman.getMaxErrors()) {
	    System.out.println("   -------\r\n" + "   |     |\r\n" + "   |     0\r\n" + "   |    \\|/\r\n"
		    + "   |	/ \\\r\n" + " __|___\r\n" + "/      \\");
	    System.out.println("You lose The word was: " + hangmanwordguess.getWord());
	} else {
	    System.out.println("You win");
	    System.out.println("The word is: " + hangmanwordguess.getWord());
	}
	scanner.close();
    }

    public int getError() {
	return error;
    }

    public void setError(int error) {
	this.error = error;
    }

    public int getMaxErrors() {
	return maxErrors;
    }

    public void setMaxErrors(int maxErrors) {
	this.maxErrors = maxErrors;
    }
}
