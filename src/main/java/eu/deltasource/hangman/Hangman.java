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
