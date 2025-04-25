package info.hccis.squash.entity;

import info.hccis.util.CisUtility;

/**
 * Class represents a squash assessment
 *
 * @author Vy Phan
 * @since 20231129
 */
public class Assessment {

    //constants
    public static final int FACTOR_FOREHAND_DRIVE = 15;
    public static final int FACTOR_BACKHAND_DRIVE = 15;
    public static final int FACTOR_FOREHAND_VOLLEY_SUM = 10;
    public static final int FACTOR_FOREHAND_VOLLEY_MAX = 5;
    public static final int FACTOR_BACKHAND_VOLLEY_SUM = 10;
    public static final int FACTOR_BACKHAND_VOLLEY_MAX = 5;
    public static final int FACTOR_FIGURE_8_VOLLEY_SUM = 10;
    public static final int FACTOR_FIGURE_8_VOLLEY_MAX = 5;

    public static final int MAX_DRIVES = 50;
    public static final int MAX_VOLLEYS = 100;

    public static final String LEVEL_0_DESCRIPTION = "poor";
    public static final String LEVEL_1_DESCRIPTION = "good";
    public static final String LEVEL_2_DESCRIPTION = "great";
    public static final String LEVEL_3_DESCRIPTION = "super";

    public static final int LEVEL_1_AMATEUR = 800;
    public static final int LEVEL_2_AMATEUR = 950;
    public static final int LEVEL_3_AMATEUR = 1100;

    public static final int LEVEL_1_PROFESSIONAL = 900;
    public static final int LEVEL_2_PROFESSIONAL = 1050;
    public static final int LEVEL_3_PROFESSIONAL = 1300;

    //attributes
    private String assessmentDate;
    private String athleteName;
    private String assessorName;
    private String status;
    private String assessmentCode;
    private int numberOfForehandDrives;
    private int numberOfBackhandDrives;
    private int numberOfForehandVolleySum;
    private int numberOfForehandVolleyMax;
    private int numberOfBackhandVolleySum;
    private int numberOfBackhandVolleyMax;
    private int numberOfFigure8VolleySum;
    private int numberOfFigure8VolleyMax;
    private int score;
    
    //static attribute
    public static int sequenceNumber = 0;

    public Assessment() {
        this.assessmentDate = "";
        this.athleteName = "";
        this.assessorName = "";
        this.status = "";
        sequenceNumber++;
        
    }

    public Assessment(String assessmentDate, String athleteName, String assessorName, String status, String assessmentCode, int numberOfForehandDrives, int numberOfBackhandDrives, int numberOfForehandVolleySum, int numberOfForehandVolleyMax, int numberOfBackhandVolleySum, int numberOfBackhandVolleyMax, int numberOfFigure8VolleySum, int numberOfFigure8VolleyMax) {
        this.assessmentDate = assessmentDate;
        this.athleteName = athleteName;
        this.assessorName = assessorName;
        this.status = status;
        this.assessmentCode = assessmentCode;
        setNumberOfForehandDrives(numberOfForehandDrives);
        setNumberOfBackhandDrives(numberOfBackhandDrives);
        setNumberOfForehandVolleySum(numberOfForehandVolleySum);
        setNumberOfForehandVolleyMax(numberOfForehandVolleyMax);
        setNumberOfBackhandVolleySum(numberOfBackhandVolleySum);
        setNumberOfBackhandVolleyMax(numberOfBackhandVolleyMax);
        setNumberOfFigure8VolleySum(numberOfFigure8VolleySum);
        setNumberOfFigure8VolleyMax(numberOfFigure8VolleyMax);
        calculateScore();
        sequenceNumber++;
    }

    public void getInformation() {
        //Input
        System.out.println(System.lineSeparator() + "----- Enter assessment details -----" + System.lineSeparator());

        assessmentDate = CisUtility.getTodayString("yyyy-MM-dd");

        //VP 20231129 Using method to get valid entry.
        athleteName = CisUtility.getInputString("Athlete name:", 1, 50);
       

        while (!athleteName.contains(" ")) {
            System.out.println("Name must have a first and last name each of which are at least two characters in length");
            athleteName = CisUtility.getInputString("Athlete name:", 1, 50);

        }
        int indexOfSpace = athleteName.indexOf(" ");
        String firstName = athleteName.substring(0, indexOfSpace);
        String lastName = athleteName.substring(indexOfSpace + 1);
        
        while ((firstName.length() < 2) && (lastName.length() < 2) || firstName.length() < 2 || (lastName.length() < 2)) {
            System.out.println("Name must have a first and last name each of which are at least two characters in length");
            athleteName = CisUtility.getInputString("Athlete name:", 1, 50);
            indexOfSpace = athleteName.indexOf(" ");
            firstName = athleteName.substring(0, indexOfSpace);
            lastName = athleteName.substring(indexOfSpace + 1);
        }
        
        

        assessorName = CisUtility.getInputString("Assessor name:", 1, 50);
        while (!assessorName.contains(" ")) {
            System.out.println("Name must have a first and last name each of which are at least two characters in length");
            assessorName = CisUtility.getInputString("Assessor name:", 1, 50);

        }
        int indexOfSpace1 = assessorName.indexOf(" ");
        String firstName1 = assessorName.substring(0, indexOfSpace1);
        String lastName1 = assessorName.substring(indexOfSpace1 + 1);
        
        while ((firstName1.length() < 2) && (lastName1.length() < 2) || firstName1.length() < 2 || (lastName1.length() < 2)) {
            System.out.println("Name must have a first and last name each of which are at least two characters in length");
            assessorName = CisUtility.getInputString("Accessor name:", 1, 50);
            indexOfSpace1 = assessorName.indexOf(" ");
            firstName1 = assessorName.substring(0, indexOfSpace1);
            lastName1 = assessorName.substring(indexOfSpace1 + 1);
        }
        
        
        

        do {
            status = CisUtility.getInputString("Status (amateur or professional):");
        } while (!(status.equalsIgnoreCase("amateur") || status.equalsIgnoreCase("professional")));

        //20230523 BJM note using overloaded getInputInt to get valid values from the user.
        int numberOfForehandDrives = CisUtility.getInputInt("Forehand drives: ", 0, 50);
        int numberOfBackhandDrives = CisUtility.getInputInt("Backhand drives: ", 0, 50);
        int numberOfForehandVolleySum = CisUtility.getInputInt("Forehand volley sum: ", 0, 50);
        int numberOfForehandVolleyMax = CisUtility.getInputInt("Forehand volley max: ", 0, 50);
        int numberOfBackhandVolleySum = CisUtility.getInputInt("Backhand volley sum: ", 0, 50);
        int numberOfBackhandVolleyMax = CisUtility.getInputInt("Backhand volley max: ", 0, 50);
        int numberOfFigure8VolleySum = CisUtility.getInputInt("Figure 8 volley sum: ", 0, 50);
        int numberOfFigure8VolleyMax = CisUtility.getInputInt("Figure 8 volley max: ", 0, 50);

        //Use the setters to apply validation
        setNumberOfForehandDrives(numberOfForehandDrives);
        setNumberOfBackhandDrives(numberOfBackhandDrives);
        setNumberOfForehandVolleySum(numberOfForehandVolleySum);
        setNumberOfForehandVolleyMax(numberOfForehandVolleyMax);
        setNumberOfBackhandVolleySum(numberOfBackhandVolleySum);
        setNumberOfBackhandVolleyMax(numberOfBackhandVolleyMax);
        setNumberOfFigure8VolleySum(numberOfFigure8VolleySum);
        setNumberOfFigure8VolleyMax(numberOfFigure8VolleyMax);

        calculateScore();

    }

    /**
     * Calculate the score based on their results
     *
     * @since 20230518
     * @author BJM
     */
    public int calculateScore() {

        //Calculate the total score
        score = numberOfForehandDrives * FACTOR_FOREHAND_DRIVE
                + numberOfBackhandDrives * FACTOR_BACKHAND_DRIVE
                + numberOfForehandVolleySum * FACTOR_FOREHAND_VOLLEY_SUM
                + numberOfForehandVolleyMax * FACTOR_FOREHAND_VOLLEY_MAX
                + numberOfBackhandVolleySum * FACTOR_BACKHAND_VOLLEY_SUM
                + numberOfBackhandVolleyMax * FACTOR_BACKHAND_VOLLEY_MAX
                + numberOfFigure8VolleySum * FACTOR_FIGURE_8_VOLLEY_SUM
                + numberOfFigure8VolleyMax * FACTOR_FIGURE_8_VOLLEY_MAX;
        return score;

    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getAssessorName() {
        return assessorName;
    }

    public void setAssessorName(String assessorName) {
        this.assessorName = assessorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfForehandDrives() {
        return numberOfForehandDrives;
    }

    public void setNumberOfForehandDrives(int numberOfForehandDrives) {
        if (numberOfForehandDrives > MAX_DRIVES) {
            this.numberOfForehandDrives = 0;
        } else {
            this.numberOfForehandDrives = numberOfForehandDrives;
        }
    }

    public int getNumberOfBackhandDrives() {
        return numberOfBackhandDrives;
    }

    public void setNumberOfBackhandDrives(int numberOfBackhandDrives) {
        if (numberOfBackhandDrives > MAX_DRIVES) {
            this.numberOfBackhandDrives = 0;
        } else {
            this.numberOfBackhandDrives = numberOfBackhandDrives;
        }
    }

    public int getNumberOfForehandVolleySum() {
        return numberOfForehandVolleySum;
    }

    public void setNumberOfForehandVolleySum(int numberOfForehandVolleySum) {
        if (numberOfForehandVolleySum > MAX_VOLLEYS) {
            this.numberOfForehandVolleySum = 0;
        } else {
            this.numberOfForehandVolleySum = numberOfForehandVolleySum;
        }
    }

    public int getNumberOfForehandVolleyMax() {
        return numberOfForehandVolleyMax;
    }

    public void setNumberOfForehandVolleyMax(int numberOfForehandVolleyMax) {
        if (numberOfForehandVolleyMax > MAX_VOLLEYS) {
            this.numberOfForehandVolleyMax = 0;
        } else {
            this.numberOfForehandVolleyMax = numberOfForehandVolleyMax;
        }
    }

    public int getNumberOfBackhandVolleySum() {
        return numberOfBackhandVolleySum;
    }

    public void setNumberOfBackhandVolleySum(int numberOfBackhandVolleySum) {
        if (numberOfBackhandVolleySum > MAX_VOLLEYS) {
            this.numberOfBackhandVolleySum = 0;
        } else {
            this.numberOfBackhandVolleySum = numberOfBackhandVolleySum;
        }
    }

    public int getNumberOfBackhandVolleyMax() {
        return numberOfBackhandVolleyMax;
    }

    public void setNumberOfBackhandVolleyMax(int numberOfBackhandVolleyMax) {
        if (numberOfBackhandVolleyMax > MAX_VOLLEYS) {
            this.numberOfBackhandVolleyMax = 0;
        } else {
            this.numberOfBackhandVolleyMax = numberOfBackhandVolleyMax;
        }
    }

    public int getNumberOfFigure8VolleySum() {
        return numberOfFigure8VolleySum;
    }

    public void setNumberOfFigure8VolleySum(int numberOfFigure8VolleySum) {
        if (numberOfFigure8VolleySum > MAX_VOLLEYS) {
            this.numberOfFigure8VolleySum = 0;
        } else {
            this.numberOfFigure8VolleySum = numberOfFigure8VolleySum;
        }
    }

    public int getNumberOfFigure8VolleyMax() {
        return numberOfFigure8VolleyMax;
    }

    public void setNumberOfFigure8VolleyMax(int numberOfFigure8VolleyMax) {
        if (numberOfFigure8VolleyMax > MAX_VOLLEYS) {
            this.numberOfFigure8VolleyMax = 0;
        } else {
            this.numberOfFigure8VolleyMax = numberOfFigure8VolleyMax;
        }
    }

    public int getScore() {
        return score;
    }
     /**
     * Gets an assessment code for the athlete
     *
     * @return String
     * @since 20231129
     * @author VP
     */
    public String setAssessmentCode(){
        String output="";
        int indexOfSpace = athleteName.indexOf(" ");
        String firstName = athleteName.substring(0, indexOfSpace);
        String lastName = athleteName.substring(indexOfSpace + 1);
        String firstTwoCharactersOfFirstName = firstName.substring(0,2);
        String firstTwoCharactersOfLastName = lastName.substring(0,2);
        String firstLowerCase = firstTwoCharactersOfFirstName.toLowerCase();
        String lastLowerCase = firstTwoCharactersOfLastName.toLowerCase();
        output = firstLowerCase + lastLowerCase;
        if (status.equals("amateur")){
            output += "1";
        }
        else if (status.equals("professional")){
            output += "2";
        }
        
        String text = String.format("%03d", sequenceNumber);
        output+=text; 
        return output;
    }

    /**
     * Gets a description based on the status and score
     *
     * @since 20230519
     * @author BJM
     */
    public String getScoreDescription() {
        String description = "";

        int level1 = 0, level2 = 0, level3 = 0, level4 = 0;

        //Set the level threshold based on status
        switch (status.toLowerCase()) {
            case "amateur":
                //todo add if statement
                level1 = LEVEL_1_AMATEUR;
                level2 = LEVEL_2_AMATEUR;
                level3 = LEVEL_3_AMATEUR;
                break;
            case "professional":
                level1 = LEVEL_1_PROFESSIONAL;
                level2 = LEVEL_2_PROFESSIONAL;
                level3 = LEVEL_3_PROFESSIONAL;
                break;
        }

        //Set the description based on the levels set from the switch.
        if (score < level1) {
            description = LEVEL_0_DESCRIPTION;
        } else if (score < level2) {
            description = LEVEL_1_DESCRIPTION;
        } else if (score < level3) {
            description = LEVEL_2_DESCRIPTION;
        } else {
            description = LEVEL_0_DESCRIPTION;
        }

        return description;
    }

    public void display() {
        System.out.println(this.toString());
    }

    public String toString() {
        String assessmentCode1 = setAssessmentCode();
        
        //Add code to capitalize the first letter of each first name and last name
        int indexOfSpace = athleteName.indexOf(" ");
        String firstName = athleteName.substring(0, indexOfSpace);
        String upperLetter1 = firstName.substring(0,1).toUpperCase();
        String remaining1 = firstName.substring (1);
 
        String lastName = athleteName.substring(indexOfSpace + 1);
        String upperLetter2 = lastName.substring(0,1).toUpperCase();
        String remaining2 = lastName.substring(1);
        
        int indexOfSpace1 = assessorName.indexOf(" ");
        String firstName1 = assessorName.substring(0, indexOfSpace1);
        String upperLetter3 = firstName1.substring(0,1).toUpperCase();
        String remaining3 = firstName1.substring(1);
        
        String lastName1 = assessorName.substring(indexOfSpace1 + 1);
        String upperLetter4 = lastName1.substring(0, 1).toUpperCase();
        String remaining4 = lastName1.substring(1);
        
        
        String output = System.lineSeparator() + "----- Assessment details -----" + "("+ assessmentCode1+ ")"+ System.lineSeparator()
                + "Assessment Date: " + assessmentDate + System.lineSeparator()
                + "Athlete Name: " +  upperLetter1 + remaining1 + " "+ upperLetter2 + remaining2 + System.lineSeparator()
                + "Assessor Name: " + upperLetter3 + remaining3 + " "+ upperLetter4 + remaining4 + System.lineSeparator()
                + "Status: " + status + System.lineSeparator()
                + System.lineSeparator()
                + "Details:" + System.lineSeparator()
                + "Number of forehand drives: " + numberOfForehandDrives + System.lineSeparator()
                + "Number of backhand drives: " + numberOfBackhandDrives + System.lineSeparator()
                + "Forehand volley sum: " + numberOfForehandVolleySum + System.lineSeparator()
                + "Forehand volley max: " + numberOfForehandVolleyMax + System.lineSeparator()
                + "Backhand volley sum: " + numberOfBackhandVolleySum + System.lineSeparator()
                + "Backhand volley max: " + numberOfBackhandVolleyMax + System.lineSeparator()
                + "Figure 8 volley sum: " + numberOfFigure8VolleySum + System.lineSeparator()
                + "Figure 8 volley max: " + numberOfFigure8VolleyMax + System.lineSeparator()
                + System.lineSeparator()
                + "Score: " + score + "(" + getScoreDescription() + ")" + System.lineSeparator();

        return output;
    }

}
