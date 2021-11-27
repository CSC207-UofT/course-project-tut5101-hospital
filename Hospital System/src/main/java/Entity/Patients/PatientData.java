package Entity.Patients;

import java.util.HashMap;

import Exceptions.StuffNotFoundException;

import java.io.*;

public class PatientData implements java.io.Serializable {
    /**
     * Patient data entity
     */
    private HashMap<Integer, Patient> patients;

    /**
     * Constructor for patient data, load data from ser file
     */
    public PatientData() {
        patients = new HashMap<>();
        loadData();
    }

    /**
     * Add, modify, remove Entity.Patients. Add the patient if it is not already in, modify it if it is already in
     * the database.
     *
     * @param patient
     */
    public void addOrModifyPatient(Patient patient) {
        patients.put(patient.getHealthCardNum(), patient);
    }

    /**
     * Remove patient
     * @param patient
     * @throws StuffNotFoundException
     */
    public void removePatient(Patient patient) throws StuffNotFoundException {
        if (patients.containsKey(patient.getHealthCardNum())) {
            patients.remove(patient.getHealthCardNum());
        } else {
            throw new StuffNotFoundException("");
        }
    }

    /**
     * view and search patients
     * @param patient
     * @return
     */
    public String viewPatient(Patient patient) {
        if (patients.containsKey(patient.getHealthCardNum())) {
            return patients.get(patient.getHealthCardNum()).getPatientInfo();
        } else {
            return "Patient not found";
        }
    }

    /**
     * Return patient by search health card number
     * @param healthCardNum
     * @return
     */
    public Patient searchHealthCardNumber(int healthCardNum) {
        if (patients.containsKey(healthCardNum)) {
            return patients.get(healthCardNum);
        } else {
            return null;
        }
    }

    /**
     * Check if patient exist or not.
     * @param healthCardNum
     * @return
     */
    public boolean patientExist(int healthCardNum) {
        if (patients.containsKey(healthCardNum)) {
            return true;
        }
        return false;
    }


    /**
     * load data
     */
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

    /**
     * Save data
     */
    private void loadData() {
        File file = new File("patients.ser");
        if (!file.exists() || file.length() == 0) {

        } else {
            PatientData pd = null;
            try {
                FileInputStream fileIn = new FileInputStream("patients.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                pd = (PatientData) in.readObject();
                in.close();
                fileIn.close();
                this.patients = pd.patients;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}