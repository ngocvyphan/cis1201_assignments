package info.hccis.cis1201_assignment1_maclean_bj;

import info.hccis.squash.entity.Assessment;
import info.hccis.util.CisUtility;
import java.util.Scanner;

/**
 * Assignment #3 start code (Squash Skills)
 *
 * @author Vy Phan
 * @since 20231013
 */
public class Controller {

    public static void main(String[] args) {

      //Create Assessment object using custom constructors
      Assessment assessment1 = new Assessment("Ivan Drake", "BJ MacLean", "2023-10-13", 11, 5, 14, 78, 6, 59, 6, 23);
      assessment1.display();
     
      //Create Assessment object using default constructors
      Assessment assessment2 = new Assessment();
      assessment2.getInformation();
      assessment2.display();
    }
}
