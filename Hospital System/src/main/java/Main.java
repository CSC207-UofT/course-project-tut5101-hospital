import Exceptions.InvalidInputException;
import Exceptions.StaffNotFoundException;
import UI.MenuChooseStaffOrPatient;

public class Main {
    public static void main(String[] args) throws InvalidInputException, StaffNotFoundException {
        MenuChooseStaffOrPatient menuChooseStaffOrPatient = new MenuChooseStaffOrPatient();
        menuChooseStaffOrPatient.choosePatientOrStaff();
    }

}