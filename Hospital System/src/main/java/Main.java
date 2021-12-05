import Exceptions.InvalidInputException;
import UI.Menu;
import UI.MenuChooseStaffOrPatient;
import UI.MenuForPatient;

public class Main {
    Menu state;
    public static void main(String[] args) throws InvalidInputException {
        MenuChooseStaffOrPatient menuChooseStaffOrPatient = new MenuChooseStaffOrPatient();
        menuChooseStaffOrPatient.choosePatientOrStaff();
    }

}