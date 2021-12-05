package UI.StaffMenu;

import Controllers.LoginSignUp.LoginSignup;
import Exceptions.InvalidInputException;
import UI.Menu;

import java.util.Scanner;

public abstract class StaffMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    long id;
    LoginSignup loginSignup = new LoginSignup();
    @Override
    public void activity() throws InvalidInputException {

    }
    //in case a log out feature is implemented, this would be filled out
    @Override
    public void toState(String type){

    }

}
