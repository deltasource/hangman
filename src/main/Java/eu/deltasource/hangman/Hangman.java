package eu.deltasource.hangman;

public class Hangman {

    private int maxErrors;
    private int error;

    public Hangman() {
        setMaxErrors(6);
        error = 0;
    }

    public String printHead(int error) {
        return error >= 1 ? "0" : "";
    }

    public String printBody(int error) {
        return error == 2 ? " |" : error > 2 ? "|" : " ";
    }

    public String printLeftArm(int error) {
        return error >= 3 ? "\\" : "";
    }

    public String printRightArm(int error) {
        return error >= 4 ? "/" : "";
    }

    public String printLeftLeg(int error) {
        return error >= 5 ? "/" : "";
    }

    public String printRightLeg(int error) {
        return error >= 6 ? "\\" : "";
    }

    public void printGallow(int error) {
        System.out.println("   -------");
        System.out.println("   |     |");
        System.out.println("   |     " + printHead(error));
        System.out.println("   |    " + printLeftArm(error) + printBody(error) + printRightArm(error));
        System.out.println("   |	" + printLeftLeg(error) + " " + printRightLeg(error));
        System.out.println(" __|___");
        System.out.println("/      \\");
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
