package eu.deltasource.hangman;

public class HangmanDraw {

    public HangmanDraw() {
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
            return "/";
        }
        else if(error ==0) {
            return "";
        }
        return "";
    }
    public String printRightArm(int error) {
        if(error >= 4) {
            return "\\";
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

    public void printGallows(int error) {
        StringBuilder printedGallows = new StringBuilder();
        printedGallows
                .append("   -------").append(System.lineSeparator())
                .append("   |     |").append(System.lineSeparator())
                .append("   |     ").append(printHead(error)).append(System.lineSeparator())
                .append("   |    ").append(printLeftArm(error)).append(printBody(error)).append(printRightArm(error)).append(System.lineSeparator())
                .append("   |	").append(printLeftLeg(error)).append(" ").append(printRightLeg(error)).append(System.lineSeparator())
                .append(" __|___").append(System.lineSeparator())
                .append("/      \\");
        System.out.println(printedGallows);
    }
}
