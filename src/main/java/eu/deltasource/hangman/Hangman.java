package eu.deltasource.hangman;

import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String letter = "";
		
		while(!letter.equalsIgnoreCase("-")) {
			System.out.println("geef een letter in");
			letter = scanner.next();
			System.out.println(letter);
		}
		System.out.println("while loop is gestopt");
		
		
	}
}
