package info.hccis.squash.entity;

import info.hccis.util.CisUtility;

/**
 * Class represents a squash assessment
 *
 * @author bjmaclean
 * @since 20230518
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

        athleteName = CisUtility.getInputString("Athlete name:");

        assessorName = CisUtility.getInputString("Assessor name:");

        status = CisUtility.getInputString("Status:(amateur or professional)");

        numberOfForehandDrives = CisUtility.getInputInt("Forehand drives: ");
        numberOfBackhandDrives = CisUtility.getInputInt("Backhand drives: ");
        numberOfForehandVolleySum = CisUtility.getInputInt("Forehand volley sum: ");
        numberOfForehandVolleyMax = CisUtility.getInputInt("Forehand volley max: ");
        numberOfBackhandVolleySum = CisUtility.getInputInt("Backhand volley sum: ");
        numberOfBackhandVolleyMax = CisUtility.getInputInt("Backhand volley max: ");
        numberOfFigure8VolleySum = CisUtility.getInputInt("Figure 8 volley sum: ");
        numberOfFigure8VolleyMax = CisUtility.getInputInt("Figure 8 volley max: ");

        //Use the setters to apply validation
        if (athleteName.length() == 0 || athleteName.length() > 50) {
            this.athleteName = "Invalid";
        } else {
            setAthleteName(athleteName);
        }
        if (assessorName.length() == 0 || assessorName.length() > 50) {
            this.assessorName = "Invalid";
        } else {
            setAssessorName(assessorName);
        }

        if (status.equals("amateur") || status.equals("professional")) {
            setStatus(status);
        } else {
            this.status = "amateur";
        }

        if (numberOfForehandDrives > MAX_DRIVES) {
            setNumberOfForehandDrives(0);
        } else {
            setNumberOfForehandDrives(numberOfForehandDrives);
        }

        if (numberOfBackhandDrives > MAX_DRIVES) {
            setNumberOfBackhandDrives(0);
        } else {
            setNumberOfBackhandDrives(numberOfBackhandDrives);
        }

        if (numberOfForehandVolleySum > MAX_VOLLEYS) {
            setNumberOfForehandVolleySum(0);
        } else {
            setNumberOfForehandVolleySum(numberOfForehandVolleySum);
        }

        if (numberOfForehandVolleyMax > MAX_VOLLEYS) {
            setNumberOfForehandVolleyMax(0);
        } else {
            setNumberOfForehandVolleyMax(numberOfForehandVolleyMax);
        }

        if (numberOfBackhandVolleySum > MAX_VOLLEYS) {
            setNumberOfBackhandVolleySum(0);
        } else {
            setNumberOfBackhandVolleySum(numberOfBackhandVolleySum);
        }

        if (numberOfBackhandVolleyMax > MAX_VOLLEYS) {
            setNumberOfBackhandVolleyMax(0);
        } else {
            setNumberOfBackhandVolleyMax(numberOfBackhandVolleyMax);
        }

        if (numberOfFigure8VolleySum > MAX_VOLLEYS) {
            setNumberOfFigure8VolleySum(0);
        } else {
            setNumberOfFigure8VolleySum(numberOfFigure8VolleySum);
        }

        if (numberOfFigure8VolleyMax > MAX_VOLLEYS) {
            setNumberOfFigure8VolleyMax(0);
        } else {
            setNumberOfFigure8VolleyMax(numberOfFigure8VolleyMax);
        }

        calculateScore();

    }

    /**
     * Calculate the score based on their results
     *
     * @return
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
        this.numberOfForehandDrives = numberOfForehandDrives;
    }

    public int getNumberOfBackhandDrives() {
        return numberOfBackhandDrives;
    }

    public void setNumberOfBackhandDrives(int numberOfBackhandDrives) {
        this.numberOfBackhandDrives = numberOfBackhandDrives;
    }

    public int getNumberOfForehandVolleySum() {
        return numberOfForehandVolleySum;
    }

    public void setNumberOfForehandVolleySum(int numberOfForehandVolleySum) {
        this.numberOfForehandVolleySum = numberOfForehandVolleySum;
    }

    public int getNumberOfForehandVolleyMax() {
        return numberOfForehandVolleyMax;
    }

    public void setNumberOfForehandVolleyMax(int numberOfForehandVolleyMax) {
        this.numberOfForehandVolleyMax = numberOfForehandVolleyMax;
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
        this.numberOfBackhandVolleyMax = numberOfBackhandVolleyMax;
    }

    public int getNumberOfFigure8VolleySum() {
        return numberOfFigure8VolleySum;
    }

    public void setNumberOfFigure8VolleySum(int numberOfFigure8VolleySum) {
        this.numberOfFigure8VolleySum = numberOfFigure8VolleySum;
    }

    public int getNumberOfFigure8VolleyMax() {
        return numberOfFigure8VolleyMax;
    }

    public void setNumberOfFigure8VolleyMax(int numberOfFigure8VolleyMax) {
        this.numberOfFigure8VolleyMax = numberOfFigure8VolleyMax;
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
        int level = 0;
        int level1 = 0, level2 = 0, level3 = 0, level4 = 0;
        if (status.equals("amateur")) {
            if (score < LEVEL_1_AMATEUR) {
                description = "poor";
            } else if (score >= LEVEL_1_AMATEUR && score < LEVEL_2_AMATEUR) {
                description = "good";
            } else if (score >= LEVEL_2_AMATEUR && score < LEVEL_3_AMATEUR) {
                description = "great";
            } else if (score >= LEVEL_3_AMATEUR) {
                description = "super";
            }
        }

        if (status.equals("professional")) {
            if (score < LEVEL_1_PROFESSIONAL) {
                level = 1;
            } else if (score >= LEVEL_1_PROFESSIONAL && score < LEVEL_2_PROFESSIONAL) {
                level = 2;
            } else if (score >= LEVEL_2_PROFESSIONAL && score < LEVEL_3_PROFESSIONAL) {
                level = 3;
            } else if (score >= LEVEL_3_PROFESSIONAL) {
                level = 4;
            }
            switch (level) {
                case 1:
                    description = "poor";
                    break;
                case 2:
                    description = "good";
                    break;
                case 3:
                    description = "great";
                    break;
                case 4:
                    description = "super";
                    break;
            }

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
