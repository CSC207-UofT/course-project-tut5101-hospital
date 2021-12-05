import Controllers.LoginSignUp.LoginSignup;
import Entity.Staff.Doctor;
import Exceptions.InvalidInputException;
import UI.Menu;
import UI.MenuChooseStaffOrPatient;
import UI.MenuForPatient;
import UseCases.Staff.StaffManager;

public class Main {
    Menu state;

    public static void main(String[] args) throws InvalidInputException {
        MenuChooseStaffOrPatient menuChooseStaffOrPatient = new MenuChooseStaffOrPatient();
        menuChooseStaffOrPatient.choosePatientOrStaff();
    }

}