package Entity.PatientRecords;

import Entity.Operations.Operation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This file contains the class PatientMedicalHistory and is used to make a patient medical history with
 * information from the patient's visit to the hospital
 */

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

    //    Constructs a patient medical history class instant.
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

    /**
     * Return a string of patient medical history information
     *
     */
    public String getPatientMH() {
        return "Physician Name: " + this.physicianName + "\n" +
                "Blood pressure: " + this.bloodPressure + "\n" +
                "BPM: " + this.pulse + "\n" +
                "Temperature: " + this.temperature + "\n" +
                "Current Medications: " + getCurrentMedications() + "\n" +
                "Physician Diagnosis: " + this.diagnosis + "\n" +
                "Treatment given: " + this.treatment + "\n" +
                "Operation: " + this.operation.getName();
    }

    /**
     * Getters
     *
     */
    public List<BufferedImage> getMedicalImage() throws IOException {
        List<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < this.medicalImage.size(); i++) {
            BufferedImage image = ImageIO.read(this.medicalImage.get(i));
            images.add(image);
        }
        return images;
    }

    public String getCurrentMedications() {
        StringBuilder allMedications = new StringBuilder();
        for (String medication: this.currentMedications) {
            allMedications.append(medication);
            allMedications.append(", ");
        }
        return allMedications.toString();
    }

}
