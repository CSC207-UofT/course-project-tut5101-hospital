package UI.StaffMenu;


import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecordList;
import Entity.PatientRecords.PatientRecords;
import Exceptions.InvalidInputException;
import Presenters.MenuPresenter.DoctorMenuPresenter;
import Presenters.PatientRecords.PatientMedicalRecordViewer;
import Presenters.PatientRecords.PatientRecordViewer;
import UI.MenuForStaff;
import UseCases.Patient.PatientManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DoctorMenu extends StaffMenu {
    public DoctorMenu(MenuForStaff context) {
        super(context);
    }

    @Override
    public void doStuff() throws InvalidInputException {
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

            } else if (choice == 3) {
                editPatientRecord();
            } else if (choice == 4) {
                makePatientRecord();
            } else {
                throw new InvalidInputException("");
            }
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

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
            PatientMedicalRecordViewer patientMedicalRecordViewer = new PatientMedicalRecordViewer();
            patientMedicalRecordViewer.print(healthCardNumber);
        } else if (choice == 2) {
            PatientRecordViewer patientRecordViewer = new PatientRecordViewer();
            patientRecordViewer.print(healthCardNumber);
        }
    }



//    public void addPatientMH() throws InvalidInputException, FileNotFoundException {
//        List<String> currentMedications = new ArrayList<>();
//        List<InputStream> medicalImages = new ArrayList<>();
//        String done = "";
//
//        System.out.println("Input your name (Input String)");
//        String name = scanner.nextLine();
//        System.out.println("Input patient blood pressure (Input String systolic/diastolic)");
//        String bp = scanner.nextLine();
//        System.out.println("Input patient pulse (Input String)");
//        String pulse = scanner.nextLine();
//        System.out.println("Input patient temperature (Input String)");
//        String temperature = scanner.nextLine();
//        System.out.println("Input current medications in use for patient (Use String and type done when input completed)");
//        while (done.equals("")) {
//            String currentMeds = scanner.nextLine();
//            if (currentMeds.equals("done")) {
//                done = "done";
//            } else {
//                currentMedications.add(currentMeds);
//            }
//        }
//        System.out.println("Input diagnosis (Use String)");
//        String diagnosis = scanner.nextLine();
//        System.out.println("Input treatment methods (Use String)");
//        String treatment = scanner.nextLine();
//        System.out.println("Upload medical images taken (Input image file path and type complete when input completed)");
//        while (done.equals("done")) {
//            String imagePath = scanner.nextLine();
//            if (imagePath.equals("complete")) {
//                done = "complete";
//            } else {
//                InputStream imageFile = new FileInputStream(imagePath);
//                medicalImages.add(imageFile);
//            }
//        }
//        PatientMedicalHistory patientMedicalHistory = new PatientMedicalHistory(name, bp, pulse, temperature, currentMedications, diagnosis, treatment, medicalImages);
//        System.out.println("Patient Medical History successfully created");
//
//        System.out.println("Input date of physician diagnosis for patient in the format: yyyy-MM-dd HH:mm");
//        String date = scanner.nextLine();
//
//        long healthCardNumber = 0;
//        System.out.println("Please input the health card number of the patient to add to her/his record.");
//        try {
//            healthCardNumber = scanner.nextInt();
//        } catch (Exception e) {
//            throw new InvalidInputException("");
//        }
//
//        PatientManager patientManager = PatientManager.getInstance();
//        patientManager.getPatient(healthCardNumber).getPRL().addHistory(patientMedicalHistory, date);
//    }

    public void editPatientRecord() throws InvalidInputException {
        int choice = 6;
        String c = "";
        String change = "";
        String result = "No patient record";
        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to add to her/his record.");
        try {
            healthCardNumber = scanner.nextInt();
        } catch (Exception e) {
            throw new InvalidInputException("");
        }

        PatientManager patientManager = PatientManager.getInstance();
        PatientRecordList PRL = patientManager.getPatient(healthCardNumber).getPRL();
        for (Map.Entry<String, Object> entry : PRL.getPatientRecords().entrySet()) {
            if (entry.getValue() instanceof PatientRecords) {
                System.out.println("Patient has an existing patient record, what would you like to update?" +
                        "Type: 1: height; 2: weight; 3: allergies; 4: vaccinations");
                result = "patient record exists";
                c = scanner.nextLine();
                if (c.equals("1")) {
                    System.out.println("Input the patient's new height (Use String)");
                    change = scanner.nextLine();
                    ((PatientRecords) entry.getValue()).changeHeight(change);
                }
                if (c.equals("2")) {
                    System.out.println("Input the patient's new weight (Use String)");
                    change = scanner.nextLine();
                    ((PatientRecords) entry.getValue()).changeWeight(change);
                }
                if (c.equals("3")) {
                    System.out.println("Input the patient's new allergy (Use String)");
                    change = scanner.nextLine();
                    ((PatientRecords) entry.getValue()).addAllergy(change);;
                }
                if (c.equals("4")) {
                    System.out.println("Input the vaccine given to patient (Use String)");
                    change = scanner.nextLine();
                    ((PatientRecords) entry.getValue()).addVaccination(change);
                }
            }
        }
        if (result.equals("No patient record")) {
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

    public void makePatientRecord() throws InvalidInputException {
        List<String> allergies = new ArrayList<>();
        List<String> vaccinations = new ArrayList<>();
        String done = "";

        System.out.println("Input patient height (Input String)");
        String height = scanner.nextLine();
        System.out.println("Input patient weight (Input String)");
        String weight = scanner.nextLine();
        System.out.println("Input patient gender at birth (Input String)");
        String sex = scanner.nextLine();
        System.out.println("Input patient allergies (Use String and type done when input completed)");
        while (done.equals("")) {
            String allergy = scanner.nextLine();
            if (allergy.equals("done")) {
                done = "done";
            } else {
                allergies.add(allergy);
            }
        }
        System.out.println("Input patient vaccinations (Use String and type done when input completed)");
        while (done.equals("")) {
            String vaccine = scanner.nextLine();
            if (vaccine.equals("done")) {
                done = "done";
            } else {
                vaccinations.add(vaccine);
            }
        }

        PatientRecords patientRecords = new PatientRecords(height, weight, sex, allergies, vaccinations);
        System.out.println("Patient Record successfully created");

        System.out.println("Input date of patient record creation in the format: yyyy-MM-dd HH:mm");
        String date = scanner.nextLine();

        long healthCardNumber = 0;
        System.out.println("Please input the health card number of the patient to add to her/his record.");
        try {
            healthCardNumber = scanner.nextInt();
        } catch (Exception e) {
            throw new InvalidInputException("");
        }

        PatientManager patientManager = PatientManager.getInstance();
        patientManager.getPatient(healthCardNumber).getPRL().addRecord(patientRecords, date);
    }
}
