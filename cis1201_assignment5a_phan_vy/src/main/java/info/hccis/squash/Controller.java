package info.hccis.squash;

import info.hccis.squash.entity.Assessment;

/**
 * Assignment #5 start code (Squash Skills)
 *
 * @author Vy Phan
 * @since 20231122
 */
public class Controller {

    public static void main(String[] args) {
        /**
     * Represent the design using a for loop
     *
     * @since 20231122
     * @author Vy Phan
     */
        int counter;
        String space =" ";
        System.out.println("*");
        System.out.println("**");
        for (counter=1; counter<=9; counter++){
            System.out.println("*" + space + "*");
            space = space + " ";
        }

        System.out.println("Welcome to the CIS Squash Skills app.");
        
        Assessment assessment1 = new Assessment("2023-05-18", "John Adams", "John Power", "amateur", 1,2,3,4,5,6,7,8);
        assessment1.display();
        
        Assessment assessment2 = new Assessment();
        assessment2.getInformation();        
        assessment2.display();
    }
}
