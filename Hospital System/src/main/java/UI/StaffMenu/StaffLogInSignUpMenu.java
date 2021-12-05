package UI.StaffMenu;

import Controllers.LoginSignUp.CheckStaffType;
import Controllers.LoginSignUp.LoginSignup;
import Controllers.LoginSignUp.StaffSignUp.AccountantSignUp;
import Controllers.LoginSignUp.StaffSignUp.AdminSignUp;
import Controllers.LoginSignUp.StaffSignUp.DoctorSignUp;
import Controllers.LoginSignUp.StaffSignUp.NurseSignUp;
import Entity.Schedule.Schedule;
import Exceptions.InvalidInputException;
import UI.Menu;
import UI.MenuForStaff;

import java.util.Scanner;

public class StaffLogInSignUpMenu implements Menu {
    Scanner scanner = new Scanner(System.in);
    public long id;
    LoginSignup loginSignup = new LoginSignup();
    public String type="Doctor";
    MenuForStaff context;

    public StaffLogInSignUpMenu(MenuForStaff context) {
        this.context=context;
    }

    public void loginSignupForStaff() throws InvalidInputException {
        System.out.println("Sign up or login (Type 1 for sign up; Type 2 for login)");
        String c = scanner.nextLine();

        if (c.equals("2")) {
            loginStaff();
        }
        if (c.equals("1")) {
            signupStaff();
        }
    }


    // return a string representing the type of the staff
    public String loginStaff() throws InvalidInputException {
        boolean success = false;

        do {
            System.out.println("Input id (Input id you put in when you did sign up for staff)");
            id = scanner.nextLong();
            if (loginSignup.checkIfStaffExists(id)) {
                this.type=new CheckStaffType().checkType(id);
                scanner.nextLine();
            } else {
                System.out.println("You do not have an account, enter 1 to switch to sign up instead");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 1) {
                    signupStaff();
                    break;
                }
            }
            System.out.println("Input password (Input String)");
            String ipt_pwd = scanner.nextLine();
            success = loginSignup.LoginForStaffs(id, ipt_pwd);
            while (!success) {
                System.out.println("Login failed due to incorrect password, please enter 2 to try again. If you forgot your password, enter 3");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 2) {
                    loginSignupForStaff();
                    break;
                }
                if (k == 3) {
                    System.out.println("Input id (Input integer)");
                    long idForRetrieve = scanner.nextLong();
                    System.out.println("You will be notified by management in the next 48 hours to retrieve your password.");
                }
            }
        } while (!success);
        return type;
    }


    public void signupStaff() throws InvalidInputException {
        System.out.println("SignUp as what type: Doctor/Nurse/Admin/Accountant");
        String type= scanner.nextLine();
        System.out.println("Input name (Input String)");
        String name = scanner.nextLine();
        System.out.println("Input gender (Input Male or Female)");
        String gender = scanner.nextLine();
        System.out.println("Input id (Input Integer)");
        id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Input password (Input String)");
        String pwd = scanner.nextLine();
        System.out.println("Input base salary (Input Integer)");
        int salary = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What event do you do (Choose among Ill, Fever, Heart, Eye, Bone)");
        String event = scanner.nextLine();
        Schedule workingTime;
        try {
            workingTime = loginSignup.makeWorkingTime(event);


            switch (type){
                case "Doctor":
                    new DoctorSignUp().signUp(name, gender, id, workingTime, pwd, salary);
                case "Admin":
                    new AdminSignUp().signUp(name, gender, id, workingTime, pwd, salary);
                case "Accountant":
                    new AccountantSignUp().signUp(name, gender, id, workingTime, pwd, salary);
                case "Nurse":
                    new NurseSignUp().signUp(name, gender, id, workingTime, pwd, salary);
            }


            System.out.println("Staff account successfully created");
        } catch (InvalidInputException e) {
            System.out.println("Input is invalid");
        }
        System.out.println("sign up  "+ loginSignup.checkIfStaffExists(id));
        toState(type);
    }


    @Override
    public void activity() throws InvalidInputException {
        loginSignupForStaff();
    }

    //based on input staff type transfer to that type's menu
    @Override
    public void toState(String type) throws InvalidInputException {
        switch (type){
            case "Doctor":
                context.setState(new DoctorMenu(context));
                break;
            case "Admin":
                context.setState(new AdminMenu(context));
                break;
            case "Accountant":
                context.setState(new AccountantMenu(context));
                break;
            case "Nurse":
                context.setState(new NurseMenu(context));
                break;
        }context.doThings();
    }
}
