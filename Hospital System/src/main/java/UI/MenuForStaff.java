package UI;

import Controllers.Accountant.FindHospitalProfit;
import Controllers.Admin.GetBestStrategies.GetBestByOperationIncome;
import Controllers.Admin.GetBestStrategies.GetBestByOperations;
import Controllers.Admin.GetBestStrategies.GetBestByTime;
import Controllers.Appointment.AppointmentMaker;
import Controllers.LoginSignUp.LoginSignup;
import Entity.PatientRecords.PatientMedicalHistory;
import Entity.Schedule.Schedule;
import Entity.Staff.Staff;
import Exceptions.InvalidInputException;
import Presenters.Functions.FindBestStaffPresenter;
import Presenters.Functions.FindHospitalProfitPresenter;
import Presenters.PatientRecords.PatientMedicalRecordViewer;
import Presenters.PatientRecords.PatientRecordViewer;
import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuForStaff {
    Scanner scanner = new Scanner(System.in);
    private long id;
    LoginSignup loginSignup = new LoginSignup();

    public MenuForStaff() {

    }

    public void loginSignupForStaff() {
        System.out.println("Sign up or login (Type 1 for sign up; Type 2 for login)");
        String c = scanner.nextLine();

        if (c.equals("2")) {
            loginStaff();
        }
        if (c.equals("1")) {
            signupStaff();
        }
    }

    public void signupStaff() {
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
            loginSignup.signUpForDoctors(name, gender, id, workingTime, pwd, salary);
            System.out.println("Staff account successfully created");
        } catch (InvalidInputException e) {
            System.out.println("Input is invalid");
        }
        System.out.println(loginSignup.checkIfStaffExists(id));
    }

    public void loginStaff() {
        boolean success = false;

        do {
            System.out.println("Input id (Input id you put in when you did sign up for staff)");
            id = scanner.nextLong();
            if (loginSignup.checkIfStaffExists(id)) {
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
    }

    public void activitiesForStaffs() {
        String c;
        System.out.println("confirm patient appointment or view schedule or assigned patient record(Type 1 to confirm patient appointment;" +
                " Type 2 to view schedule; Type 3 to check assigned patient record)");
        c = scanner.nextLine();
        if (c.equals("1")) {
            confirmAppointment();
        }
        if (c.equals("2")) {
            viewStaffSchedule();
        }
        if (c.equals("3")) {
            checkAssignedPatientRecord();
        }
    }

    private void confirmAppointment() {
        Staff staff = loginSignup.initStaff(id);
        System.out.println(loginSignup.checkIfStaffExists(id));
        ScheduleManager sm = new ScheduleManager(staff.getSchedule());
    }

    private void viewStaffSchedule() {
        AppointmentMaker appointmentMaker = new AppointmentMaker(id);
        System.out.println(appointmentMaker.checkStaffSchedule());
    }

    private void checkAssignedPatientRecord(){
        String c;
        System.out.println("confirm patient appointment or view schedule or assigned patient record(Type 1 to confirm patient appointment;" +
                " Type 2 to view schedule; Type 3 to check assigned patient record)");
        c = scanner.nextLine();
        if (c.equals("4")) {
            viewPatientRecord();
        }
        if (c.equals("5")) {
            addPatientMH();
        }
    }

    /**
     * Only Admin can call this function to find the best staff function.
     * @throws InvalidInputException
     */
    public void findBestStaff() throws InvalidInputException {
        int choice = 4;
        long id;
        FindBestStaffPresenter findBestStaffPresenter = new FindBestStaffPresenter();
        StaffManager staffManager = new StaffManager();

        do {
            findBestStaffPresenter.print();
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }

            if (choice == 1) {
                id = new GetBestByTime().findBest();
            } else if (choice == 2) {
                id = new GetBestByOperations().findBest();
            } else if (choice == 3) {
                id = new GetBestByOperationIncome().findBest();
            } else {
                throw new InvalidInputException("");
            }
        } while (choice != 1 && choice != 2 && choice != 3);

        findBestStaffPresenter.print(staffManager.getStaff(id).getName());
    }

    /**
     * Find hospital profit, only account staff can use this.
     */
    public void findHospitalProfit(){
        FindHospitalProfit findHospitalProfit = new FindHospitalProfit();
        new FindHospitalProfitPresenter().print(findHospitalProfit.totalProfit());
    }

    /**
     * View patient record by input a patient health card number
     */
    public void viewPatientRecord() {
        int choice = 4;
        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to see her/his record.");
        try {
            healthCardNumber = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }

        while (choice != 1 && choice != 2) {
            System.out.println("Which kind of record you want to check for this patient?");
            System.out.println("1: Record");
            System.out.println("2: Medical Record");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
        if (choice == 1) {
            PatientMedicalRecordViewer patientMedicalRecordViewer = new PatientMedicalRecordViewer();
            patientMedicalRecordViewer.print(healthCardNumber);
        } else if (choice == 2) {
            PatientRecordViewer patientRecordViewer = new PatientRecordViewer();
            patientRecordViewer.print(healthCardNumber);
        }
    }

    public void addPatientMH() {
        int choice = 5;
        List<String> currentMedications = new ArrayList<>();
        List<InputStream> medicalImages = new ArrayList<>();
        String done = "";

        System.out.println("Input your name (Input String)");
        String name = scanner.nextLine();
        System.out.println("Input patient blood pressure (Input String systolic/diastolic)");
        String bp = scanner.nextLine();
        System.out.println("Input patient pulse (Input String)");
        String pulse = scanner.nextLine();
        System.out.println("Input patient temperature (Input String)");
        String temperature = scanner.nextLine();
        System.out.println("Input current medications in use for patient (Use String and type done when input completed)");
        while (done.equals("")) {
            String currentMeds = scanner.nextLine();
            if (currentMeds.equals("done")) {
                done = "done";
            } else {
                currentMedications.add(currentMeds);
            }
        }
        System.out.println("Input diagnosis (Use String)");
        String diagnosis = scanner.nextLine();
        System.out.println("Input treatment methods (Use String)");
        String treatment = scanner.nextLine();
        System.out.println("Upload medical images taken (Input image file path and type complete when input completed)");
        while (done.equals("done")) {
            String imagePath = scanner.nextLine();
            if (imagePath.equals("complete")) {
                done = "complete";
            } else {
                try {
                    InputStream imageFile = new FileInputStream(imagePath);
                    medicalImages.add(imageFile);
                } catch (FileNotFoundException f) {
                    System.out.println("File Not Found");
                }
            }
        }
        PatientMedicalHistory patientMedicalHistory = new PatientMedicalHistory(name, bp, pulse, temperature, currentMedications, diagnosis, treatment, medicalImages);
        System.out.println("Patient medical record successfully created");

        System.out.println("Input time of diagnosis: yyyy-MM-dd HH:mm");
        String date = scanner.nextLine();

        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to add to her/his record.");
        try {
            healthCardNumber = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }

        PatientManager patientManager = new PatientManager();
        patientManager.getPatient(healthCardNumber).getPRL().addHistory(patientMedicalHistory, date);
    }

}
