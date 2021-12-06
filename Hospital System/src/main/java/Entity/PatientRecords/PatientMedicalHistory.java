package Entity.PatientRecords;

import java.util.List;


public class PatientMedicalHistory implements java.io.Serializable {
    /**
     * This file contains the class PatientMedicalHistory and is used to make a patient medical history with
     * information from the patient's visit to the hospital
     */
    private final String physicianName;
    private final String bloodPressure;
    private final String pulse;
    private final String temperature;
    private final List<String> currentMedications;
    private final String diagnosis;
    private final String treatment;

    //    Constructs a patient medical history class instant.
    public PatientMedicalHistory(String physicianName, String bloodPressure, String pulse, String temperature,
                                 List<String> currentMedications, String diagnosis, String treatment) {
        this.physicianName = physicianName;
        this.bloodPressure = bloodPressure;
        this.pulse = pulse;
        this.temperature = temperature;
        this.currentMedications = currentMedications;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    /**
     * Return a string of patient medical history information
     */
    public String getPatientMH() {
        return "Physician Name: " + this.physicianName + "\n" +
                "Blood pressure: " + this.bloodPressure + "\n" +
                "BPM: " + this.pulse + "\n" +
                "Temperature: " + this.temperature + "\n" +
                "Current Medications: " + getCurrentMedications() + "\n" +
                "Physician Diagnosis: " + this.diagnosis + "\n" +
                "Treatment given: " + this.treatment;
    }

    /**
     * Getters
     */
    public String getCurrentMedications() {
        StringBuilder allMedications = new StringBuilder();
        for (String medication : this.currentMedications) {
            allMedications.append(medication);
            allMedications.append(", ");
        }
        allMedications.delete(allMedications.length() - 2, allMedications.length());
        return allMedications.toString();
    }

}
