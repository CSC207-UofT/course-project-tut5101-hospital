package UI;

import Controllers.LoginSignUp.LoginSignup;
import Exceptions.InvalidInputException;
import UI.StaffMenu.StaffLogInSignUpMenu;

import java.util.Scanner;

public class MenuForStaff {
    Scanner scanner = new Scanner(System.in);
    public long id;
    LoginSignup loginSignup = new LoginSignup();
    Menu state = new StaffLogInSignUpMenu(this);

    public MenuForStaff() throws InvalidInputException {
        doThings();
    }
    //state design pattern
    public void setState(Menu state) {
        this.state = state;
    }public void doThings() throws InvalidInputException {
        state.activity();
    }




}
