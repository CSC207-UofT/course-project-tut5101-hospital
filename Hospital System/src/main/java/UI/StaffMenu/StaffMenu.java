package UI.StaffMenu;

import Controllers.LoginSignUp.LoginSignup;
import Exceptions.InvalidInputException;
import UI.Menu;
import UI.MenuForStaff;

import java.io.FileNotFoundException;
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
    public void activity() throws InvalidInputException, FileNotFoundException {
        doStuff();
        quit();
        //in case a log out feature is implemented, this would be filled out
//        toState("not implemented");
//        context.doThings();
    }

    @Override
    public void toState(String type) {
        context.setState(this);
    }

    public void doStuff() throws InvalidInputException, FileNotFoundException {

    }

    public void quit() {
        System.out.println("press q to quit, other to continue");
        String c = scanner.nextLine();
        if (c.equals("q")) {
            context.setState(new StaffLogInSignUpMenu(context));
        }
    }

}
