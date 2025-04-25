package info.hccis.vehicle;

import info.hccis.util.CisUtility;
import info.hccis.vehicle.entity.Vehicle;

/**
 * Controls the overall flow of the program.
 *
 * @author Vy Phan
 * @since 20231207
 */
public class Controller {


    public static final int EXIT = 0;

    public static final String MENU = "1) Opton 1: Enter vehicle information: " + System.lineSeparator()
            + EXIT + ") Exit" 
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";

    public static void main(String[] args) {

        int menuOption;

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    processMenuOption1();
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);
    }

    /**
     * Processing for menu option 1
     * @since 20231207
     * @author Vy Phan
     */
    public static void processMenuOption1() {
        System.out.println("Processing option 1");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.getInformation();
        vehicle1.display();
    }

}
