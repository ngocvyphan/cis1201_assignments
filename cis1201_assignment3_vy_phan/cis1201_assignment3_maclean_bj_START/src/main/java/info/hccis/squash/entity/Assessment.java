/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info.hccis.squash.entity;

import info.hccis.util.CisUtility;
import java.util.Scanner;

/**
 * Assignment 3
 * @author Vy Phan
 * 20231013
 */
public class Assessment {
      
    final int FACTOR_FOREHAND_DRIVE = 15;
    final int FACTOR_BACKHAND_DRIVE = 15;
    final int FACTOR_FOREHAND_VOLLEY_SUM = 10;
    final int FACTOR_FOREHAND_VOLLEY_MAX = 5;
    final int FACTOR_BACKHAND_VOLLEY_SUM = 10;
    final int FACTOR_BACKHAND_VOLLEY_MAX = 5;
    final int FACTOR_FIGURE_8_VOLLEY_SUM = 10;
    final int FACTOR_FIGURE_8_VOLLEY_MAX = 5;
    
    private String atheleteName;
    private String accessorName;
    private String today;
    private int numberOfForehandDrives;
    private int numberOfBackhandDrives;
    private int numberOfForehandVolleySum;
    private int numberOfForehandVolleyMax;
    private int numberOfBackhandVolleySum;
    private int numberOfBackhandVolleyMax;
    private int numberOfFigure8VolleySum;
    private int numberOfFigure8VolleyMax;
    
    
    
  public Assessment(){
      atheleteName = " ";
      accessorName = " ";
      today = " ";
      numberOfForehandDrives = 0;
      numberOfBackhandDrives = 0;
      numberOfForehandVolleySum = 0;
      numberOfForehandVolleyMax = 0;
      numberOfBackhandVolleySum = 0;
      numberOfBackhandVolleyMax = 0;
      numberOfFigure8VolleySum = 0;
      numberOfFigure8VolleyMax = 0;
  }
    
    public Assessment (String atheleteName, String accessorName, String today, int numberOfForehandDrives, int numberOfBackhandDrives, int numberOfForehandVolleySum, int numberOfForehandVolleyMax, int numberOfBackhandVolleySum, int numberOfBackhandVolleyMax, int numberOfFigure8VolleySum, int numberOfFigure8VolleyMax){
        this.atheleteName = atheleteName;
        this.accessorName = accessorName;
        this.today = today;
        this.numberOfForehandDrives = numberOfForehandDrives;
        this.numberOfBackhandDrives = numberOfBackhandDrives;
        this.numberOfForehandVolleySum = numberOfForehandVolleySum;
        this.numberOfForehandVolleyMax = numberOfForehandVolleyMax;
        this.numberOfBackhandVolleySum = numberOfBackhandVolleySum;
        this.numberOfBackhandVolleyMax = numberOfBackhandVolleyMax;
        this.numberOfFigure8VolleySum = numberOfFigure8VolleySum;
        this.numberOfFigure8VolleyMax = numberOfFigure8VolleyMax;
    }
    
    public void getAccessorName(String accessorName){
        this.accessorName = accessorName;
    }
    
    public String getAccessorName(){
        return accessorName;
    }

    public String getAtheleteName() {
        return atheleteName;
    }

    public void setAtheleteName(String atheleteName) {
        this.atheleteName = atheleteName;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
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
        this.numberOfBackhandVolleySum = numberOfBackhandVolleySum;
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
    
    
    
    public int calculateScore(){
        int score = numberOfForehandDrives * FACTOR_FOREHAND_DRIVE
                + numberOfBackhandDrives * FACTOR_BACKHAND_DRIVE
                + numberOfForehandVolleySum * FACTOR_FOREHAND_VOLLEY_SUM
                + numberOfForehandVolleyMax * FACTOR_FOREHAND_VOLLEY_MAX
                + numberOfBackhandVolleySum * FACTOR_BACKHAND_VOLLEY_SUM
                + numberOfBackhandVolleyMax * FACTOR_BACKHAND_VOLLEY_MAX
                + numberOfFigure8VolleySum * FACTOR_FIGURE_8_VOLLEY_SUM
                + numberOfFigure8VolleyMax * FACTOR_FIGURE_8_VOLLEY_MAX;
        return score;
    }
    
    public void getInformation(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the CIS Squash Skills Tracking Application");
        
        today = CisUtility.getTodayString("yyyy-MM-dd");

        System.out.println("Athlete name: ");
        atheleteName = input.nextLine();

        System.out.println("Assessor name: ");
        accessorName = input.nextLine();

        System.out.println("Forehand drives: ");
        numberOfForehandDrives = input.nextInt();
        input.nextLine();

        System.out.println("Backhand drives: ");
        numberOfBackhandDrives = input.nextInt();
        input.nextLine();

        System.out.println("Forehand volley sum: ");
        numberOfForehandVolleySum = input.nextInt();
        input.nextLine();

        System.out.println("Forehand volley max: ");
        numberOfForehandVolleyMax = input.nextInt();
        input.nextLine();

        System.out.println("Backhand volley sum: ");
        numberOfBackhandVolleySum = input.nextInt();
        input.nextLine();

        System.out.println("Backhand volley max: ");
        numberOfBackhandVolleyMax = input.nextInt();
        input.nextLine();

        System.out.println("Figure 8 volley sum: ");
        numberOfFigure8VolleySum = input.nextInt();
        input.nextLine();

        System.out.println("Figure 8 volley max: ");
        numberOfFigure8VolleyMax = input.nextInt();
        input.nextLine();
    }
    
    public void display(){
        System.out.println(this.toString());
    }
    
    @Override
    public String toString(){
        String output;
        int score = calculateScore();
        output = "Assessment Date: " + this.today + System.lineSeparator()
                + "Athelete Name: " + this.atheleteName + System.lineSeparator()
                + "Accessor Name: " + this.accessorName + System.lineSeparator()
                +"\n"+ System.lineSeparator()
                +"Details: " + System.lineSeparator()
                +"Number of forhand drives: " + this.numberOfForehandDrives + System.lineSeparator()
                +"Number of backhand drives: " + this.numberOfBackhandDrives + System.lineSeparator()
                +"Forehand volley sum: " + this.numberOfForehandVolleySum + System.lineSeparator()
                +"Forehand volley max: " + this.numberOfForehandVolleyMax + System.lineSeparator()
                +"Backhand volley sum: " + this.numberOfBackhandVolleySum + System.lineSeparator()
                +"Backhand volley max: " + this.numberOfBackhandVolleyMax + System.lineSeparator()
                +"Figure 8 volley sum: " + this.numberOfFigure8VolleySum + System.lineSeparator()
                +"Figure 8 volley max: " + this.numberOfFigure8VolleyMax + System.lineSeparator()
                + "\n"+ System.lineSeparator()
                +"Score: "+ score;
        return output;
    }
    
}
