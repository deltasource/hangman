package eu.deltasource.hangman;

public class Hangman {

    private int error;

    public Hangman() {
	error = 0;
    }
    
    public int maxErrors(int maxErrors) {
	return maxErrors;
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
	StringBuilder gallow = new StringBuilder();

	gallow.append("   -------").append(System.lineSeparator());
	gallow.append("   |     |").append(System.lineSeparator());
	gallow.append("   |     " + printHead(error)).append(System.lineSeparator());
	gallow.append("   |    " + printLeftArm(error) + printBody(error) + printRightArm(error)).append(System.lineSeparator());
	gallow.append("   |	" + printLeftLeg(error) + " " + printRightLeg(error)).append(System.lineSeparator());
	gallow.append(" __|___").append(System.lineSeparator());
	gallow.append("/      \\");
	
	System.out.println(gallow);
	}
    public int getError() {
	return error;
    }

    public void setError(int error) {
	this.error = error;
    }

    
}
