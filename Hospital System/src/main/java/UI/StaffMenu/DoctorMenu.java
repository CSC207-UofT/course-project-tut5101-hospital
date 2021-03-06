package UI.StaffMenu;


import Controllers.Appointment.AppointmentMaker;
import Controllers.PatientRecord.AddPatientMH;
import Controllers.PatientRecord.AddPatientRecord;
import Controllers.PatientRecord.EditPatientRecord;
import Exceptions.InvalidInputException;
import Exceptions.StaffNotFoundException;
import Presenters.MenuPresenter.DoctorMenuPresenter;
import Presenters.PatientRecords.PatientMedicalRecordViewer;
import Presenters.PatientRecords.PatientRecordViewer;
import UI.MenuForStaff;

import java.util.ArrayList;
import java.util.List;


public class DoctorMenu extends StaffMenu {
    private long id;

    public DoctorMenu(MenuForStaff context) {
        super(context);
        type = "Doctor";
    }

    @Override
    public void doStuff() throws InvalidInputException {
        DoctorMenuPresenter doctorMenuPresenter = new DoctorMenuPresenter();
        int choice = 7;
        do {
            System.out.println(doctorMenuPresenter.print());
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }

            if (choice == 1) {
                viewPatientRecord();
            } else if (choice == 2) {
                addPatientMH();
            } else if (choice == 3) {
                editPatientRecord();
            } else if (choice == 4) {
                makePatientRecord();
            } else if (choice == 5) {
                confirmAppointment();
            } else if (choice == 6) {
                viewStaffSchedule();
            } else {
                throw new InvalidInputException("");
            }
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice !=5 && choice != 6);

    }

    /**
     * View patient record by input a patient health card number
     */
    public void viewPatientRecord() throws InvalidInputException {
        int choice = 4;
        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to see her/his record.");
        try {
            healthCardNumber = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            throw new InvalidInputException("");
        }

        while (choice != 1 && choice != 2) {
            System.out.println("Which kind of record you want to check for this patient?");
            System.out.println("1: Record");
            System.out.println("2: Medical Record");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }
        }
        if (choice == 1) {
            PatientRecordViewer patientRecordViewer = new PatientRecordViewer();
            System.out.println(patientRecordViewer.print(healthCardNumber));
        } else if (choice == 2) {
            PatientMedicalRecordViewer patientMedicalRecordViewer = new PatientMedicalRecordViewer();
            System.out.println(patientMedicalRecordViewer.print(healthCardNumber));
        }
    }

    public void addPatientMH() throws InvalidInputException {
        List<String> currentMedications = new ArrayList<>();
        String done = "";

        System.out.println("Input your name (Input String)");
        String physicianName = scanner.nextLine();
        System.out.println("Input patient blood pressure (Input String systolic/diastolic)");
        String bp = scanner.nextLine();
        System.out.println("Input patient pulse (Input String)");
        String pulse = scanner.nextLine();
        System.out.println("Input patient temperature (Input String)");
        String temperature = scanner.nextLine();
        System.out.println("Input current medications in use for patient (Use String and type done when input completed;" +
                " if patient has no current medications, type none)");
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

        System.out.println("Input date of physician diagnosis for patient in the format: yyyy-MM-dd HH:mm");
        String date = scanner.nextLine();

        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to add to her/his record.");
        try {
            healthCardNumber = scanner.nextLong();
            scanner.nextLine();
        } catch (Exception e) {
            throw new InvalidInputException("Invalid input");
        }

        AddPatientMH apMH = new AddPatientMH(healthCardNumber);
        apMH.newPatientMH(physicianName, bp, pulse, temperature, currentMedications, diagnosis, treatment, date);
        System.out.println("Patient history successfully created and added to patient record list");
    }

    private void confirmAppointment() {
        System.out.println("Enter your id");
        id = scanner.nextLong();
        scanner.nextLine();
        AppointmentMaker appointmentMaker = new AppointmentMaker(id, "id");
        System.out.println(appointmentMaker.getStaffSchedule());
        if (appointmentMaker.getStaffSchedule() != null){
            System.out.println("Are you going to confirm your appointment? Choose 1 to confirm. 2 to cancel.");
            String c = scanner.nextLine();
            if (c.equals("1")){
                System.out.println("Schedule confirmed");
            }
            else if (c.equals("2")){
                try {
                    System.out.println("Write down the patient's health card number whom you cant to cancel");
                    long hcn = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Choose Your Time (start time) to cancel in this kind of format: yyyy-MM-dd HH:mm");
                    String st = scanner.nextLine();
                    System.out.println("Choose Your Time (end time) to cancel in this kind of format: yyyy-MM-dd HH:mm");
                    String e = scanner.nextLine();
                    appointmentMaker.deleteEvent(st, e, id, hcn);
                    System.out.println("This Schedule canceled");
                } catch (StaffNotFoundException e) {
                    System.out.println("Staff Not Found");
                }
            }
        }
    }

    private void viewStaffSchedule() {
        System.out.println("Enter your id");
        id = scanner.nextLong();
        scanner.nextLine();
        AppointmentMaker appointmentMaker = new AppointmentMaker(id, "id");
        System.out.println(appointmentMaker.getStaffSchedule());
    }

    public void editPatientRecord() throws InvalidInputException {
        int choice = 6;
        String c = "";
        String change = "";

        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to add to her/his record.");
        try {
            healthCardNumber = scanner.nextLong();
            scanner.nextLine();
        } catch (Exception e) {
            throw new InvalidInputException("Invalid input");
        }
        PatientRecordViewer prv = new PatientRecordViewer();
        System.out.println(prv.print(healthCardNumber));
        EditPatientRecord epv = new EditPatientRecord(healthCardNumber);
        if (epv.checkPatientRecordexists()) {
            System.out.println("Patient has an existing patient record, what would you like to update?" +
                    "Type: 1: height; 2: weight; 3: allergies; 4: vaccinations");
            c = scanner.nextLine();
            if (c.equals("1")) {
                System.out.println("Input the patient's new height (Use String)");
                change = scanner.nextLine();
                epv.editHeight(change);
                System.out.println("Patient's height has been successfully changed");
            }
            if (c.equals("2")) {
                System.out.println("Input the patient's new weight (Use String)");
                change = scanner.nextLine();
                epv.editWeight(change);
                System.out.println("Patient's weight has been successfully changed");
            }
            if (c.equals("3")) {
                System.out.println("Input the patient's new allergy (Use String)");
                change = scanner.nextLine();
                epv.editAllergy(change);
                System.out.println("Patient's allergy has been successfully added");
            }
            if (c.equals("4")) {
                System.out.println("Input the vaccine given to patient (Use String)");
                change = scanner.nextLine();
                epv.editVaccination(change);
                System.out.println("Patient's vaccine has been successfully added");
            }
        } else {
            System.out.println("Patient does not have an existing patient record, please type 7 create a new patient record?");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }
        }
        if (choice == 7) {
            makePatientRecord();
        }
    }

    public void makePatientRecord () throws InvalidInputException {
        List<String> allergies = new ArrayList<>();
        List<String> vaccinations = new ArrayList<>();
        String done = "";

        System.out.println("Input patient height (Input String)");
        String height = scanner.nextLine();
        System.out.println("Input patient weight (Input String)");
        String weight = scanner.nextLine();
        System.out.println("Input patient gender at birth (Input Male or Female)");
        String sex = scanner.nextLine();
        System.out.println("Input patient allergies (Use String and type done when input completed; if patient has no allergies, type none)");
        while (done.equals("")) {
            String allergy = scanner.nextLine();
            if (allergy.equals("done")) {
                done = "done";
            } else {
                allergies.add(allergy);
            }
        }
        System.out.println("Input patient vaccinations (Use String and type finish when input completed; " +
                "if patient has no vaccinations, type none)");
        while (done.equals("done")) {
            String vaccine = scanner.nextLine();
            if (vaccine.equals("finish")) {
                done = "finish";
            } else {
                vaccinations.add(vaccine);
            }
        }

        System.out.println("Input date of patient record creation in the format: yyyy-MM-dd HH:mm");
        String date = scanner.nextLine();

        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to add to her/his record.");
        try {
            healthCardNumber = scanner.nextLong();
            scanner.nextLine();
        } catch (Exception e) {
            throw new InvalidInputException("Invalid input");
        }
        AddPatientRecord apr = new AddPatientRecord(healthCardNumber);
        apr.newPatientRecord(height, weight, sex, allergies, vaccinations, date);
        System.out.println("Patient record successfully created and added to patient record list");
    }
}