package info.hccis.util;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

/**
 * Has some useful methods to be used in our programs.
 *
 * @author bjmaclean
 * @since Oct 19, 2021
 */
public class CisUtility {

    private static Scanner input = new Scanner(System.in);

    /**
     * Return the default currency String value of the double passed in as a
     * parameter.
     *
     * @param inputDouble double to be formatted
     * @return String in default currency format
     *
     * @since 20211020
     * @author BJM
     */
    public static String toCurrency(double inputDouble) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(inputDouble);
    }

    /**
     * Return the number formatted with the given number of decimal places
     *
     * @since 20230111
     * @author CIS1232A
     * @param theNumber
     * @param numberOfDecimalPlaces
     * @return The number formatted
     */
    public static String formatDouble(double theNumber, int numberOfDecimalPlaces) {
        //https://stackoverflow.com/questions/5195837/format-float-to-n-decimal-places
        String theNumberFormatted = String.format("%." + numberOfDecimalPlaces + "f", theNumber);
        return theNumberFormatted;
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return String entered by the user
     * @since 20211020
     * @author BJM
     */
    public static String getInputString(String prompt) {

        System.out.println(prompt + " -->");
        String output = input.nextLine();
        return output;
    }

     /**
     * Get input from the user using the console for date and default to today if 
     * user presses enter.
     *
     * @param prompt Prompt for the user
     * @return String entered by the user or today's date
     * @since 20211020
     * @author BJM
     */
    public static String getInputDateWithTodayDefault(String prompt) {

        System.out.println(prompt + " (leave blank for today's date) "+"-->");
        String output = input.nextLine();
        
        if(output == null || (output.isEmpty())){
            output = getTodayString("yyyy-MM-dd");
        }
        return output;
    }

    
    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return The double entered by the user
     * @since 20211020
     * @author BJM
     */
    public static double getInputDouble(String prompt) {

        String inputString = getInputString(prompt);
        double output = Double.parseDouble(inputString);
        return output;
    }

    /**
     * Get input from the user using the console
     *
     * @param prompt Prompt for the user
     * @return The double entered by the user
     * @since 20211020
     * @author BJM
     */
    public static int getInputInt(String prompt) {

        String inputString = getInputString(prompt);
        int output = Integer.parseInt(inputString);
        return output;
    }

    /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @since 20211108
     * @author BJM
     */
    public static boolean getInputBoolean(String prompt) {

        String inputString = getInputString(prompt + " (y/n)");
        if (inputString.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Get input boolean from the user using the console
     *
     * @param prompt Prompt for the user
     * @return boolean as specified by user input
     * @since 20211108
     * @author BJM
     */
    public static boolean getInputBoolean(String prompt, String affirmative, String negative) {

        String inputString = getInputString(prompt + " (" + affirmative + "/" + negative + ")");
        if (inputString.equalsIgnoreCase(affirmative)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Provide today's date in the specified format
     *
     * @param format Date format desired
     * @return Today's date in specified format
     * @since 20211021
     * @author BJM
     */
    public static String getTodayString(String format) {
        //https://www.javatpoint.com/java-get-current-date

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

    /**
     * Get a random number between min and max
     *
     * @since 20211109
     * @author BJM
     */
    public static int getRandom(int min, int max) {
        Random rand = new Random();
        int theRandomNumber = rand.nextInt((max - min) + 1) + min;
        return theRandomNumber;
    }

}
