package info.hccis.squash;

import info.hccis.squash.entity.Assessment;
import info.hccis.util.CisUtility;

/**
 * Assignment #6 start (Squash Skills)
 *
 * @author Vy Phan
 * @since 20231129
 */
public class Controller {
    
    public static void main(String[] args) {
        CisUtility.displayDesign();
        
        System.out.println("Welcome to the CIS Squash Skills app.");
        
        
        Assessment assessment1 = new Assessment("2023-05-18", "John Adams", "John Power", "amateur", "joad1001",1,2,3,4,5,6,7,8);
        assessment1.display();
        
        
        Assessment assessment2 = new Assessment();
        assessment2.getInformation();
        assessment2.display();
        
    }
}
