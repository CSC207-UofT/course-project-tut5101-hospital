package UI;

import Exceptions.InvalidInputException;
import UI.StaffMenu.StaffLogInSignUpMenu;


public class MenuForStaff {
    Menu state = new StaffLogInSignUpMenu(this);

    public MenuForStaff() throws InvalidInputException {
        doThings();
    }

    //state design pattern
    public void setState(Menu state) {
        this.state = state;
    }

    public void doThings() throws InvalidInputException {
        state.activity();
        /*
         * TODO: Additional method should be added here from workerMenu
         *
         */
    }
}
