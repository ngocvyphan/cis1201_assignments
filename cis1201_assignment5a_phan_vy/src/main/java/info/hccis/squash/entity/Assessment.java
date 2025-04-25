package info.hccis.squash.entity;

import info.hccis.util.CisUtility;

/**
 * Class represents a squash assessment
 *
 * @author Vy Phan
 * @since 20231122
 * * @modified by Vy Phan 2023-11-22. Added validation to the user inputs.
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
    private int numberOfForehandDrives;
    private int numberOfBackhandDrives;
    private int numberOfForehandVolleySum;
    private int numberOfForehandVolleyMax;
    private int numberOfBackhandVolleySum;
    private int numberOfBackhandVolleyMax;
    private int numberOfFigure8VolleySum;
    private int numberOfFigure8VolleyMax;
    private int score;

    public Assessment() {
        this.assessmentDate = "";
        this.athleteName = "";
        this.assessorName = "";
        this.status = "";
    }

    public Assessment(String assessmentDate, String athleteName, String assessorName, String status, int numberOfForehandDrives, int numberOfBackhandDrives, int numberOfForehandVolleySum, int numberOfForehandVolleyMax, int numberOfBackhandVolleySum, int numberOfBackhandVolleyMax, int numberOfFigure8VolleySum, int numberOfFigure8VolleyMax) {
        this.assessmentDate = assessmentDate;
        this.athleteName = athleteName;
        this.assessorName = assessorName;
        this.status = status;
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

    public void getInformation() {
        //Input
        System.out.println(System.lineSeparator() + "----- Enter assessment details -----" + System.lineSeparator());

        assessmentDate = CisUtility.getTodayString("yyyy-MM-dd");

        //name validation handling
        //Vy 2023-11-22 Using do while loop to prompt the user to enter the name again if the name is invalid (whose length is lower than 1 or more than 50)
        do {
            athleteName = CisUtility.getInputString("Athlete name: ");
            if (athleteName.length() < 1 || athleteName.length() > 50) {
                athleteName = "Invalid";
                System.out.println("Athlete name length must be between 1-50 characters\n");
            }
        } while (athleteName.equals("Invalid"));
        
        //Vy 2023-11-22 Using do while loop to prompt the user to enter the name again if the name is invalid (whose length is lower than 1 or more than 50)
        //name validation handling
        do {
            assessorName = CisUtility.getInputString("Accessor name: ");
            if (assessorName.length() < 1 || assessorName.length() > 50) {
                assessorName = "Invalid";
                System.out.println("Assessor name length must be between 1-50 characters\n");
            }
        } while (assessorName.equals("Invalid"));

        //Vy 2023-11-22 Using a do-while to prompt the user to enter the status again if the status is not "amateur" or "professional"
        do {
            status = CisUtility.getInputString("Status (amateur or professional):");
            if (!status.equalsIgnoreCase("professional")) {
                System.out.println("Invalid option, defaulting to amateur\n");
                status = "amateur";
            }
        } while (!status.equals("amateur") && !status.equals("professional"));

        //Use the setters to apply validation
        //Vy 2023-11-22 Adding code to represent if the number of forehand drives greater than MAX_DRIVES then set the number of forehand drives to be 0
        numberOfForehandDrives = CisUtility.getInputInt("Forehand drives: ");
        while (numberOfForehandDrives > MAX_DRIVES){
            setNumberOfForehandDrives(0);
        }
        
        //Vy 2023-11-22 Adding code to represent if the number of backhand drives greater than MAX_DRIVES then set the number of backhand drives to be 0
        numberOfBackhandDrives = CisUtility.getInputInt("Backhand drives: ");
        while (numberOfBackhandDrives > MAX_DRIVES){
            setNumberOfBackhandDrives(0);
        }
        
        
        //Vy 2023-11-22 Adding code to represent if the number of forehand volley sum greater than MAX_VOLLEYS then set the number of forehand volleysum to be 0
        numberOfForehandVolleySum = CisUtility.getInputInt("Forehand volley sum: ");
        while (numberOfForehandVolleySum > MAX_VOLLEYS){
            setNumberOfForehandVolleySum(0);
        }
        //Vy 2023-11-22 Adding code to represent if the number of forehand volley max greater than MAX_VOLLEYS then set the number of forehand volleymax to be 0
        numberOfForehandVolleyMax = CisUtility.getInputInt("Forehand volley max: ");
        while (numberOfForehandVolleyMax > MAX_VOLLEYS){
            setNumberOfForehandVolleyMax(0);
        }
        
        ////Vy 2023-11-22 Adding code to represent if the number of backhand volley sum greater than MAX_VOLLEYS then set the number of backhand volleysum to be 0
        numberOfBackhandVolleySum = CisUtility.getInputInt("Backhand volley sum: ");
        while (numberOfBackhandVolleySum > MAX_VOLLEYS){
           setNumberOfBackhandVolleySum(0); 
        }
        
        //Vy 2023-11-22 Adding code to represent if the number of backhand volleymax greater than MAX_VOLLEYS then set the number of backhand volleymax to be 0
        numberOfBackhandVolleyMax = CisUtility.getInputInt("Backhand volley max: ");
        while (numberOfBackhandVolleyMax > MAX_VOLLEYS){
            setNumberOfBackhandVolleyMax(0);
        }
        
        //Vy 2023-11-22 Adding code to represent if the number of figure8 volley sum greater than MAX_VOLLEYS then set the number of figure8 volleysum to be 0
        numberOfFigure8VolleySum = CisUtility.getInputInt("Figure 8 volley sum: ");
        while (numberOfFigure8VolleySum > MAX_VOLLEYS){
            setNumberOfFigure8VolleySum(0);
        }
        
        //Vy 2023-11-22 Adding code to represent if the number of figure8 volley max greater than MAX_VOLLEYS then set the number of figure8 volleymax to be 0
        numberOfFigure8VolleyMax = CisUtility.getInputInt("Figure 8 volley max: ");
        while (numberOfFigure8VolleyMax > MAX_VOLLEYS){
            setNumberOfFigure8VolleyMax(0);
        }
        

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
            System.out.println("Invalid entry, setting to 0");
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
            System.out.println("Invalid entry, setting to 0");
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
            System.out.println("Invalid entry, setting to 0");
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
            System.out.println("Invalid entry, setting to 0");
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
            System.out.println("Invalid entry, setting to 0");
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
            System.out.println("Invalid entry, setting to 0");
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
            System.out.println("Invalid entry, setting to 0");
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
            System.out.println("Invalid entry, setting to 0");
            this.numberOfFigure8VolleyMax = 0;
        } else {
            this.numberOfFigure8VolleyMax = numberOfFigure8VolleyMax;
        }
    }

    public int getScore() {
        return score;
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
        String output = System.lineSeparator() + "----- Assessment details -----" + System.lineSeparator()
                + "Assessment Date: " + assessmentDate + System.lineSeparator()
                + "Athlete Name: " + athleteName + System.lineSeparator()
                + "Assessor Name: " + assessorName + System.lineSeparator()
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
