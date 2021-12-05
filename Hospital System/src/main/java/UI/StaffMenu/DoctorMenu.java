package UI.StaffMenu;


import Entity.PatientRecords.PatientMedicalHistory;
import Exceptions.InvalidInputException;
import Presenters.MenuPresenter.DoctorMenuPresenter;
import Presenters.PatientRecords.PatientMedicalRecordViewer;
import Presenters.PatientRecords.PatientRecordViewer;
import UI.MenuForStaff;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class DoctorMenu extends StaffMenu {
    public DoctorMenu(MenuForStaff context) {
        super(context);
    }

    @Override
    public void doStuff() throws InvalidInputException, FileNotFoundException {
        DoctorMenuPresenter doctorMenuPresenter = new DoctorMenuPresenter();
        int choice = 4;
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
            } else {
                throw new InvalidInputException("");
            }
        } while (choice != 1 && choice != 2);

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
