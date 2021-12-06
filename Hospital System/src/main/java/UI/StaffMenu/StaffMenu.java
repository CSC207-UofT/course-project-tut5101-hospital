package UI.StaffMenu;

import Controllers.LoginSignUp.LoginSignup;
import Controllers.SaveEveryThing;
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
    public String type;

    public StaffMenu(MenuForStaff context) {
        this.context = context;
    }

    @Override
    public void activity() throws InvalidInputException {
        doStuff();
        quit();
        //in case a log out feature is implemented, this would be filled out
    }

    @Override
    public void toState(String type) {
        context.setState(this);
    }

    public void doStuff() throws InvalidInputException {

    }

    //asks for input to quit
    public void quit() {
        System.out.println("press q to quit, other letter to continue");
        String c = scanner.nextLine();
        if (c.equals("q")) {
            exit();
        }else{
            toState(this.type);
        }
    }
    //actually quits the program
    public void exit() {
        SaveEveryThing sv = new SaveEveryThing();
        sv.save();
        System.exit(0);
    }

}
