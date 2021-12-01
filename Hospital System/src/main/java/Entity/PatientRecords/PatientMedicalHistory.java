package Entity.PatientRecords;

import Entity.Operations.Operation;

import java.io.InputStream;
import java.util.List;

public class PatientMedicalHistory implements java.io.Serializable{
    private final String physicianName;
    private final Operation operation;
    private final String bloodPressure;
    private final String pulse;
    private final String temperature;
    private final List<String> currentMedications;
    private final String diagnosis;
    private final String treatment;
    private final List<InputStream> medicalImage;

    public PatientMedicalHistory(String physicianName, String bloodPressure, String pulse, String temperature,
                                 List<String> currentMedications, String diagnosis, String treatment,
                                 Operation operation, List<InputStream> medicalImage) {
        this.physicianName = physicianName;
        this.bloodPressure = bloodPressure;
        this.pulse = pulse;
        this.temperature = temperature;
        this.currentMedications = currentMedications;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.operation = operation;
        this.medicalImage = medicalImage;
    }

    public String getPatientMH() {
        return "Physician Name: " + this.physicianName + "\n" +
                "Blood pressure: " + this.bloodPressure + "\n" +
                "BPM: " + this.pulse + "\n" +
                "Temperature: " + this.temperature + "\n" +
                "Current Medications: " + this.currentMedications + "\n" +
                "Physician Diagnosis: " + this.diagnosis + "\n" +
                "Treatment given: " + this.treatment + "\n" +
                "Operation: " + this.operation + "\n" +
                "Medical Images: " + this.medicalImage;
    }

}
