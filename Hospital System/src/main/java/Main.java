import Exceptions.InvalidInputException;
import UI.MenuChooseStaffOrPatient;
import UI.MenuForPatient;

public class Main {
    public static void main(String[] args) throws InvalidInputException {
        MenuChooseStaffOrPatient menuChooseStaffOrPatient = new MenuChooseStaffOrPatient();
        menuChooseStaffOrPatient.choosePatientOrStaff();
    }

}