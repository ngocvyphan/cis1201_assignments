package info.hccis.squash;

import info.hccis.squash.entity.Assessment;

/**
 * Assignment #4 start code (Squash Skills)
 *
 * @author bjmaclean
 * @since 20230517
 */
public class Controller {

    public static void main(String[] args) {

        System.out.println("Welcome to the CIS Squash Skills app.");
        
        Assessment assessment1 = new Assessment("2023-05-18", "John Adams", "John Power", "amateur", 1,2,3,4,5,6,7,8);
        assessment1.display();
        
        Assessment assessment2 = new Assessment();
        assessment2.getInformation();        
        assessment2.display();
    }
}
