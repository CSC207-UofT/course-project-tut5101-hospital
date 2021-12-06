import Exceptions.InvalidInputException;
import UI.MenuChooseStaffOrPatient;

public class Main {
    public static void main(String[] args) throws InvalidInputException {
        MenuChooseStaffOrPatient menuChooseStaffOrPatient = new MenuChooseStaffOrPatient();
        menuChooseStaffOrPatient.choosePatientOrStaff();
    }

}