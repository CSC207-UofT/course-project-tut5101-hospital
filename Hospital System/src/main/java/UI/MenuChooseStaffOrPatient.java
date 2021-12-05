package UI;

import Exceptions.InvalidInputException;

import java.util.Scanner;

public class MenuChooseStaffOrPatient {
    Scanner scanner = new Scanner(System.in);

    public MenuChooseStaffOrPatient(){}

    //For greeter
    public void greeter() {
        System.out.println("Welcome to RealFakeHospital");
    }

    // Choose if you are a patient or a staff
    public void choosePatientOrStaff () throws InvalidInputException {
        greeter();
        System.out.println("Choose 1 if you are patient, choose 2 if you are a staff");
        String c = scanner.nextLine();
        if (c.equals("1")){
            MenuForPatient menuForPatient = new MenuForPatient();
            menuForPatient.loginSignupForPatient();
            menuForPatient.activitiesForPatients();
        }
        else if (c.equals("2")){
            MenuForStaff menuForStaff = new MenuForStaff();
            menuForStaff.doThings();
        }
    }
}
