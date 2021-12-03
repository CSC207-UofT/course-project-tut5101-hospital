import Exceptions.InvalidInputException;
import UI.MenuChooseStaffOrPatient;
import UI.MenuForPatient;

public class Main {
    public static void main(String[] args){
        MenuChooseStaffOrPatient menuChooseStaffOrPatient = new MenuChooseStaffOrPatient();
        menuChooseStaffOrPatient.choosePatientOrStaff();
    }

}