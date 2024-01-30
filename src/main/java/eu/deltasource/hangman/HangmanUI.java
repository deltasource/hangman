package eu.deltasource.hangman;

public class HangmanUI {
    private static final int MAX_INCORRECT_GUESSES = 6;

    public void displayRules() {
        System.out.println("Welcome to Hangman!");
        System.out.println("Guess the word by entering letters.");
        System.out.println("You can make up to 6 incorrect guesses.");
    }

    public void displayGameState(HangmanGame hangmanGame) {
        clearScreen();
        displayHangman(hangmanGame.getIncorrectGuesses());
        displayHangmanWord(hangmanGame.getHangmanWord());
    }

    private void displayHangman(int incorrectGuesses) {
        System.out.println("     ________");
        System.out.println("     |      |");

        switch (incorrectGuesses) {
            case 1:
                System.out.println("     |      O");
                System.out.println("     |");
                System.out.println("     |");
                break;
            case 2:
                System.out.println("     |      O");
                System.out.println("     |      |");
                System.out.println("     |");
                break;
            case 3:
                System.out.println("     |      O");
                System.out.println("     |     \\|");
                System.out.println("     |");
                break;
            case 4:
                System.out.println("     |      O");
                System.out.println("     |     \\|/");
                System.out.println("     |");
                break;
            case 5:
                System.out.println("     |      O");
                System.out.println("     |     \\|/");
                System.out.println("     |     /");
                break;
            case 6:
                System.out.println("     |      O");
                System.out.println("     |     \\|/");
                System.out.println("     |     / \\");
                break;
            default:
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                break;
        }

        System.out.println(" ____|_________");
        System.out.println("/              \\");
    }

    private void displayHangmanWord(HangmanWord hangmanWord) {
        System.out.print("Word: ");
        hangmanWord.displayWord();
        System.out.println();
    }

    public void displayWinScreen() {
        clearScreen();
        System.out.println("Congratulations! You've won!");
        System.out.println();
    }

    public void displayLossScreen(String secretWord) {
        clearScreen();
        System.out.println("Sorry, you've run out of guesses.");
        System.out.println("The correct word was: " + secretWord);
        displayHangman(MAX_INCORRECT_GUESSES);
    }

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
