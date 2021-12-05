package UI.StaffMenu;

import Controllers.LoginSignUp.LoginSignup;
import Exceptions.InvalidInputException;
import UI.Menu;
import UI.MenuForStaff;

import java.util.Scanner;

public abstract class StaffMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    long id;
    LoginSignup loginSignup = new LoginSignup();
    MenuForStaff context;

    public StaffMenu(MenuForStaff context) {
        this.context = context;
    }

    @Override
    public void activity() throws InvalidInputException {
        doStuff();
        //in case a log out feature is implemented, this would be filled out
        toState("not implemented");
        context.doThings();
    }

    @Override
    public void toState(String type) {
        context.setState(this);
    }

    public void doStuff() throws InvalidInputException {

    }

}
