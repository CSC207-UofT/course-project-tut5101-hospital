package UI;

import java.util.Scanner;

import Controllers.Appointment.AppointmentMaker;
import Controllers.Appointment.PayFee;
import Entity.Patients.Patient;
import Entity.Schedule.Schedule;
import Entity.Staff.Staff;
import Exceptions.InvalidInputException;
import Exceptions.StaffNotFoundException;
import Presenters.PatientRecords.PatientMedicalRecordViewer;
import Presenters.PatientRecords.PatientRecordViewer;
import Presenters.Schedule.ViewDoctorSchedules;
import Presenters.Schedule.ViewNurseSchedules;
import Presenters.Schedule.ViewOtherStaffSchedules;
import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;
import Controllers.LoginSignUp.LoginSignup;
import UseCases.Staff.StaffManager;

public class MenuForPatient {
    Scanner scanner = new Scanner(System.in);
    private long hcn;
    private long id;
    LoginSignup loginSignup = new LoginSignup();

    public MenuForPatient() {
    }


    public void loginSignupForPatient() {
        System.out.println("Sign up or login (Type 1 for sign up; Type 2 for login)");
        String c = scanner.nextLine();
        if (c.equals("2")) {
            loginPatient();
        }
        if (c.equals("1")) {
            signupPatient();
        }
    }

    public void signupPatient() {
        System.out.println("Input name (Input String)");
        String name = scanner.nextLine();
        System.out.println("Input gender (Input Male or Female)");
        String gender = scanner.nextLine();
        System.out.println("Input contact number (Use integer)");
        long ctctNum = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Input health card number (Use integer)");
        hcn = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Input password (Use String)");
        String pwd = scanner.nextLine();
        System.out.println("How much money do you want to put into your account (Use integer)");
        int fee = scanner.nextInt();
        scanner.nextLine();
        loginSignup.signUpForPatients(name, gender, ctctNum, hcn, pwd, fee);
        System.out.println("Patient account successfully created");
    }

    public void loginPatient() {
        boolean success = false;
        do {
            System.out.println("Input HealthCardNumber (Use the health card number you signed up with)");
            hcn = scanner.nextLong();
            if (loginSignup.checkIfPatientExists(hcn)) {
                scanner.nextLine();
            } else {
                System.out.println("You do not have an account, enter 1 to switch to sign up instead");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 1) {
                    signupPatient();
                    break;
                }
            }
            System.out.println("Input password (Use integer)");
            String iptPwd = scanner.nextLine();
            success = loginSignup.LoginForPatients(hcn, iptPwd);
            while (!success) {
                System.out.println("Login failed due to incorrect password, please enter 2 to try again. If you forgot your password, enter 3");
                int k = scanner.nextInt();
                scanner.nextLine();
                if (k == 2) {
                    loginPatient();
                    break;
                }
                if (k == 3) {
                    System.out.println("Input contact number (Use integer)");
                    int contactNum = scanner.nextInt();
                    System.out.println("You will be contacted by a staff in the next 48 hours to retrieve your password.");
                }
            }
        } while (!success);
    }


    public void activitiesForPatients() {
        String c;
        System.out.println("Make or view appointments(Type 1 to make an appointment; Type 2 to view existing appointments)");
        c = scanner.nextLine();
        if (c.equals("1")) {
            makeAppointment();
        }
        if (c.equals("2")) {
            viewAppointment();
        }
    }

    private void makeAppointment() {
        Patient patient = loginSignup.initPatient(hcn);
        System.out.println("Patient Signed in " + loginSignup.checkIfPatientExists(hcn));
        ScheduleManager sm = new ScheduleManager(patient);
        System.out.println("Input event (Ill, Fever, Heart, Eye, Bone)");
        String event = scanner.nextLine();
        System.out.println("You need to pay $50");
        int c;
        System.out.println("Press 1 to view your money");
        c = scanner.nextInt();
        scanner.nextLine();
        if (c == 1) {
            System.out.println("Your Account Have $ " + patient.getFee());
        }
        PayFee pf = new PayFee();
        while (loginSignup.initPatient(hcn).getFee() < 50) {
            pf.view(hcn);
            String e = scanner.nextLine();
            pf.payBookingFee(hcn, e);
        }
        loginSignup.initPatient(hcn).payFee(50);
        System.out.println("Fee Paid");
        checkSchedule();
        System.out.println("Which Staff would you like, enter id");
        long id = scanner.nextLong();
        scanner.nextLine();
//        StaffManager sfm = StaffManager.getInstance();
//        if (sfm.checkIfStaffExist(id)) {
//            sfm.getStaffSm(id);
//        }
        System.out.println("Choose a time that is not in the staff's schedule");
        AppointmentMaker am = new AppointmentMaker(hcn);
        try {
            am.viewChoices();
            String d = scanner.nextLine();
            am.makeAppointment(d, event, id, hcn);
        } catch (InvalidInputException e) {
            System.out.println("Input is invalid");
        }
        if (sm.getScheduleString() != null) {
            System.out.println("You have successfully booked an appointment");
        }

    }

    private void viewAppointment() {
        ScheduleManager sm = new ScheduleManager(loginSignup.initPatient(hcn));
        System.out.println(sm.getScheduleString());
    }


    /**
     * Check schedule.
     */
    public void checkSchedule() {
        int choice = 4;

        do {
            System.out.println("Which kind of staff you want to check the schedule?");
            System.out.println("1: Doctor");
            System.out.println("2: Nurse");
            System.out.println("3: OtherStaff");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input is invalid, please try again");
            }

            if (choice == 1) {
                ViewDoctorSchedules viewDoctorSchedules = new ViewDoctorSchedules();
                System.out.println(viewDoctorSchedules.print());
            } else if (choice == 2) {
                ViewNurseSchedules viewNurseSchedules = new ViewNurseSchedules();
                System.out.println(viewNurseSchedules.print());
            } else {
                ViewOtherStaffSchedules viewOtherStaffSchedules = new ViewOtherStaffSchedules();
                System.out.println(viewOtherStaffSchedules.print());
            }
        } while (choice != 1 && choice != 2 && choice != 3);
    }

}
