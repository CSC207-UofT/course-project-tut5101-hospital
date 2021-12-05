package UI.StaffMenu;

import Controllers.Appointment.AppointmentMaker;
import Entity.PatientRecords.PatientMedicalHistory;
import Entity.Staff.Staff;
import Exceptions.InvalidInputException;
import Presenters.PatientRecords.PatientMedicalRecordViewer;
import Presenters.PatientRecords.PatientRecordViewer;
import UseCases.Schedule.ScheduleManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WorkerMenu extends StaffMenu{


    public void activitiesForStaffs() throws InvalidInputException, FileNotFoundException {
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

    private void checkAssignedPatientRecord() throws InvalidInputException, FileNotFoundException {
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
     * View patient record by input a patient health card number
     */
    public void viewPatientRecord() throws InvalidInputException {
        int choice = 4;
        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to see her/his record.");
        try {
            healthCardNumber = scanner.nextInt();
        } catch (Exception e) {
            throw new InvalidInputException("");
        }

        while (choice != 1 && choice != 2) {
            System.out.println("Which kind of record you want to check for this patient?");
            System.out.println("1: Record");
            System.out.println("2: Medical Record");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                throw new InvalidInputException("");
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

    public void addPatientMH() throws InvalidInputException, FileNotFoundException {
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
                InputStream imageFile = new FileInputStream(imagePath);
                medicalImages.add(imageFile);
            }
        }
        PatientMedicalHistory patientMedicalHistory = new PatientMedicalHistory(name, bp, pulse, temperature, currentMedications, diagnosis, treatment, medicalImages);
        System.out.println("Patient account successfully created");

        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to add to her/his record.");
        try {
            healthCardNumber = scanner.nextInt();
        } catch (Exception e) {
            throw new InvalidInputException("");
        }
    }

}
