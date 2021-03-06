package Entity.Patients;

import java.util.HashMap;

import Exceptions.StaffNotFoundException;

import java.io.*;

public class PatientData implements java.io.Serializable {
    private HashMap<Long, Patient> patients;

    // init
    public PatientData() {
        patients = new HashMap<>();
        loadData();
    }

    // add, modify, remove Entity.Patients
    public void addOrModifyPatient(Patient patient) {
        // add the patient if it is not already in, modify it if it is already in
        // the database.
        patients.put(patient.getHealthCardNum(), patient);
    }

    public void removePatient(Patient patient) throws StaffNotFoundException {
        if (patients.containsKey(patient.getHealthCardNum())) {
            patients.remove(patient.getHealthCardNum());
        } else {
            throw new StaffNotFoundException("");
        }
    }

    // view and search patients
    public String viewPatient(Patient patient) {
        if (patients.containsKey(patient.getHealthCardNum())) {
            return patients.get(patient.getHealthCardNum()).getPatientInfo();
        } else {
            return "Patient not found";
        }
    }

    public Patient searchHCN(long healthCardNum) {
        return patients.getOrDefault(healthCardNum, null);
    }

    public boolean patientExist(long healthCardNum) {
        return patients.containsKey(healthCardNum);
    }

    // load and save data
    public void saveData() {
        try {
            FileOutputStream fileOut = new FileOutputStream("patients.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        File file = new File("patients.ser");
        if (!file.exists() || file.length() == 0) {
            System.out.println("File not available");
        } else {
            PatientData pd;
            try {
                FileInputStream fileIn = new FileInputStream("patients.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                pd = (PatientData) in.readObject();
                in.close();
                fileIn.close();
                this.patients = pd.patients;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}