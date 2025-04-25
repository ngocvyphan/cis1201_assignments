/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment1;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Assignment 1
 * @author Vy Phan
 * 20230914
 */
public class Controller {
        public static final int FOREHAND_DRIVES_POINTS = 15;
        public static final int BACKHAND_DRIVES_POINTS = 15;
        public static final int FOREHAND_VOLLEY_MAX_POINTS = 8;
        public static final int FOREHAND_VOLLEY_SUM_POINTS = 5;
        public static final int BACKHAND_VOLLEY_MAX_POINTS = 8;
        public static final int BACKHAND_VOLLEY_SUM_POINTS = 5;
        public static final int FIGURE8_VOLLEY_MAX_POINTS = 8;
        public static final int FIGURE8_VOLLEY_SUM_POINTS = 5; 
    public static void main(String[] args) {
        System.out.println("Welcome to the CIS Squash Skills Tracking Application");
        Scanner input = new Scanner(System.in);
        //Input athelete name
        System.out.println("Athelete name: ");
        String nameOfAthelete = input.nextLine();
        //Input accessor name
        System.out.println("Assessor name: ");
        String nameOfAccessor = input. nextLine();
        //Input the number of forehand drives
        System.out.println("Forehand drives: ");
        int forehandDrives = input.nextInt();
        input.nextLine();
        //Input the number of backhand drives
        System.out.println("Backhand drives: ");
        int backhandDrives = input.nextInt();
        input.nextLine();
        //Input the Forehand Volley (max)
        System.out.println("Forehand Volley Max: ");
        int forehandVolleyMax = input.nextInt();
        input.nextLine();
        //Input the Forehand Volley (sum)
        System.out.println("Forehand Volley Sum: ");
        int forehandVolleySum = input.nextInt();
        input.nextLine();
        //Input the Backhand Volley (max)
        System.out.println("Backhand Volley Max: ");
        int backhandVolleyMax = input.nextInt();
        input.nextLine();
        //Input the Backhand Volley (sum)
        System.out.println("Backhand Volley Sum: ");
        int backhandVolleySum =input.nextInt();
        input.nextLine();
        //Input Figure 8 Volley (max)
        System.out.println("Figure 8 Volley Max: ");
        int figure8volleymax = input.nextInt();
        input.nextLine();
        //Input Figure 8 Volley (sum)
        System.out.println("Figure 8 Volley Sum: ");
        int figure8volleysum = input.nextInt();
        input.nextLine();
        //Display the current date 
        LocalDate myObj = LocalDate.now();
        //Processing
        int technicalScore = forehandDrives * FOREHAND_DRIVES_POINTS + backhandDrives * BACKHAND_DRIVES_POINTS + forehandVolleyMax * FOREHAND_VOLLEY_MAX_POINTS + forehandVolleySum * FOREHAND_VOLLEY_SUM_POINTS + backhandVolleyMax * BACKHAND_VOLLEY_MAX_POINTS + backhandVolleySum * BACKHAND_VOLLEY_SUM_POINTS + figure8volleymax * FIGURE8_VOLLEY_MAX_POINTS + figure8volleysum * FIGURE8_VOLLEY_SUM_POINTS;  
        System.out.println("The technical score for "+ nameOfAthelete + " on " + myObj + " is: " + technicalScore);
        
        
    }
}
