/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info.hccis.vehicle.entity;

import info.hccis.util.CisUtility;

/**
 *
 * Used car application
 *
 * @author Vy Phan since 20231204
 */
public class Vehicle {

    private double cost;
    private double mileage;
    private String transmission;
    private boolean hasSunroof;

    public Vehicle() {
    }

    public Vehicle(double cost, double mileage, String transmission, boolean hasSunroof) {
        this.cost = cost;
        this.mileage = mileage;
        this.transmission = transmission;
        this.hasSunroof = hasSunroof;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public void getInformation() {
        cost = CisUtility.getInputDouble("The original cost of the car: ");
        mileage = CisUtility.getInputDouble("The mileage of the car is: ");
        transmission = CisUtility.getInputString("M- manual or A- automatic: ");
        hasSunroof = CisUtility.getInputBoolean("Has sunroof or not: ");
    }
    
    /**
     * Processing for calculate the final cost of the car
     * @since 20231207
     * @author Vy Phan
     */

    public double determineFinalCost() {
        double newCost1 = cost;
        double newCost2 = cost;
        double newCost3 = cost;

        if (mileage >= 0 && mileage <= 59999) {
            newCost1 = newCost1 - newCost1 * 0.3;
        } else if (mileage >= 60000 && mileage <= 99999) {
            newCost1 = newCost1 - newCost1 * 0.35;
        } else if (mileage >= 100000 && mileage <= 199999) {
            newCost1 = newCost1 - newCost1 * 0.4;
        } else if (mileage >= 200000) {
            newCost1 = newCost1 - newCost1 * 0.5;
        }

        switch (transmission.toUpperCase()) {
            case "AUTOMATIC":
                newCost2 = newCost1 + newCost2 * 0.05;
                break;
            case "MANUAL":
                newCost2 = newCost1 - newCost2 * 0.05;
                break;
        }
        
        if (hasSunroof){
            newCost3 = newCost2 + newCost3*0.1;
        }else{
            newCost3 = newCost2;
        }
        
        

        return newCost3;
    }
    
    public void display(){
        System.out.println(toString());
    }
    
    @Override
    public String toString(){
        return "Used car" + ""
                + "\nOriginally priced at " + cost
                + "\nMileage: " + mileage
                + "\nTransmission: " + transmission
                + "\nSunroof: " + hasSunroof
                + "\nNew cost: " + determineFinalCost();
    }

}
