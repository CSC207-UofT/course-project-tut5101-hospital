package UI;

import java.util.Scanner;

import Exceptions.InvalidInputException;
import Presenters.Schedule.ViewDoctorSchedules;
import UseCases.Schedule.ScheduleManager;
import Controllers.LoginSignUp.LoginSignup;

public class Menu {
    /**
     * Menu UI
     */
    Scanner scanner = new Scanner(System.in);


    int hcn;
    LoginSignup loginSignup = new LoginSignup();

    public Menu() {

    }

    public void greeter() {
        System.out.println("Welcome to RealFakeHospital");
    }

    public void loginSignup() {
    }


    /**
     * Login sign up for patient
     */
    public void loginSignupForPatient() {
        int healthCardNumber = 0;
        System.out.println("Sign up or login (Type 1 for sign up; Type 2 for login)");
        String c = scanner.nextLine();
        if (c.equals("2")) {
            loginPatient(c);
        }
        if (c.equals("1")) {
            signupPatient();
        }
        this.hcn = healthCardNumber;
    }

    /**
     * Sign up for patient
     */
    public void signupPatient() {
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input gender");
        String gender = scanner.nextLine();
        System.out.println("Input contact number");
        int ctctNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input health card number");
        hcn = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input password");
        String pwd = scanner.nextLine();
        loginSignup.signUpForPatients(name, gender, ctctNum, hcn, pwd);
        System.out.println("Patient account successfully created");
    }

    /**
     * login for patient
     *
     * @param c
     */
    public void loginPatient(String c) {
        boolean success = false;
        do {
            System.out.println("Input HealthCardNumber");
            hcn = scanner.nextInt();
            if (loginSignup.checkIfPatientExists(hcn)) {
                scanner.nextLine();
            } else {
                System.out.println("You do not have an account, enter 1 to switch to sign up instead");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 1) {
                    c = "1";
                    break;
                }
            }
            System.out.println("Input password");
            String ipt_pwd = scanner.nextLine();
            success = loginSignup.LoginForPatients(hcn, ipt_pwd);
            while (!success) {
                System.out.println("Login failed due to incorrect password, please enter 2 to try again. If you forgot your password, enter 3");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 2) {
                    c = "2";
                    break;
                }
                if (k == 3) {
                    System.out.println("Input contact number");
                    int contactNum = scanner.nextInt();
                    System.out.println("You will be contacted by a staff in the next 48 hours to retrieve your password.");
                }
            }
        } while (!success);
    }


    /**
     * login sign up for staff
     */
    public void loginSignupForStaff() {
        int id = 0;
        System.out.println("Sign up or login (Type 1 for sign up; Type 2 for login)");
        String c = scanner.nextLine();

        if (c.equals("2")) {
            loginStaff(c);
        }
        if (c.equals("1")) {
            signupStaff();
        }
        this.id = id;
    }

    /**
     * Signup for staff
     */
    public void signupStaff() {
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input gender");
        String gender = scanner.nextLine();
        System.out.println("Input id");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input password");
        String pwd = scanner.nextLine();
        System.out.println("Input base salary");
        int salary = scanner.nextInt();
            /*This is not done yet
            TODO: Find a way to add in Working time
             */
        //ls.signUpForStaffs(name, gender, id, pwd, salary);
        System.out.println("Staff account successfully created");
    }

    /**
     * Login for staff
     *
     * @param c
     */
    public void loginStaff(String c) {
        boolean success = false;

        do {
            System.out.println("Input id");
            id = scanner.nextInt();
            if (loginSignup.checkIfPatientExists(id)) {
                scanner.nextLine();
            } else {
                System.out.println("You do not have an account, enter 1 to switch to sign up instead");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 1) {
                    c = "1";
                    break;

                }
            }
            while (!success) ;

        } if (c.equals("1")) {
            System.out.println("Input name");
            String name = s.nextLine();
            System.out.println("Input gender");
            String gender = s.nextLine();
            System.out.println("Input contact number");
            int ctctNum = s.nextInt();
            s.nextLine();
            System.out.println("Input health card number");
            hcn = s.nextInt();
            s.nextLine();
            System.out.println("Input password");

            String ipt_pwd = scanner.nextLine();
            success = loginSignup.LoginForStaffs(id, ipt_pwd);
            while (!success) {
                System.out.println("Login failed due to incorrect password, please enter 2 to try again. If you forgot your password, enter 3");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 2) {
                    c = "2";
                    break;
                }
                if (k == 3) {
                    System.out.println("Input id");
                    int idForRetrieve = scanner.nextInt();
                    System.out.println("You will be notified by management in the next 48 hours to retrieve your password.");
                }
            }
        }
        while (!success) ;
    }

    /**
     * Make activities
     */
    public void activities() {
        //System.out.println(ls.checkIfPatientExists(hcn));
        String c = "1";
        System.out.println("Make or view appointments(Type 1 to make an appointment; Type 2 to view existing appointments)");
        c = scanner.nextLine();
        if (c.equals("1")) {
            makeAppointment();

        }
        this.hcn = hcn;

    }

    public void activities() {
        //System.out.println(ls.check_if_patient_exists(hcn));
        String c = "1";
        System.out.println("Make or view appointments(Type 1 to make an appointment; Type 2 to view existing appointments)");
        c = s.nextLine();
        if (c.equals("1")) {
            makeAppointment();
        }
        if (c.equals("2")) {
            viewAppointment();
        }
    }

}

    /**
     * Make appointment
     */

    private void makeAppointment() {
        System.out.println(loginSignup.check_if_patient_exists(hcn));
        ScheduleManager sm = new ScheduleManager(loginSignup.initPatient(hcn).getSchedule());
        System.out.println("Input event");
        String event = s.nextLine();
        System.out.println("Input start time yyyy-MM-dd HH:mm");
        String start = s.nextLine();
        System.out.println("Input end time yyyy-MM-dd HH:mm");
        String end = s.nextLine();
        try {
            sm.add_or_modify_Event(event, start, end);
        } catch (InvalidInputException e) {
            System.out.println("Input is invalid");
        }
        if (sm.getScheduleString() != null) {
            System.out.println("You have successfully booked an appointment");
        }

    }

    /**
     * View appointment
     */
    private void viewAppointment() {
        ScheduleManager sm = new ScheduleManager(loginSignup.initPatient(hcn).getSchedule());
        System.out.println(sm.getScheduleString());
    }


    /**
     * Check staff schedule
     */
    public void checkSchedule() {
        int choice = 4;

        while (choice != 1 || choice != 2 || choice != 3) {
            System.out.println("Which kind of staff you want to check the schedule?");
            System.out.println("1: Doctor");
            System.out.println("2: Nurse");
            System.out.println("3: OtherStaff");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input is invalid, please try again");
            }
        }
        if (choice == 1) {
            ViewDoctorSchedules viewDoctorSchedules = new ViewDoctorSchedules();
            viewDoctorSchedules.print();
        } else if (choice == 2) {
            ViewNurseSchedules viewNurseSchedules = new ViewNurseSchedules();
            viewNurseSchedules.print();
        } else {
            ViewOtherStaffSchedules viewOtherStaffSchedules = new ViewOtherStaffSchedules();
            viewOtherStaffSchedules.print();
        }

    }


}