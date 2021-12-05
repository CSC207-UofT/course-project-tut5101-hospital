package Entity.PatientRecords;

import java.util.List;

/**
 * This file contains the class Patient Record and is used to get the patient record
 */
public class PatientRecords implements java.io.Serializable{
    private String height;
    private String weight;
    private final String sex;
    private final List<String> allergies;
    private final List<String> vaccinations;

    /**
     * Entity class to create patient record
     *
     * @param height Height of that patient
     * @param weight Weight of that patient
     * @param sex Sex (gender at birth) of that patient
     * @param allergies Allergies of that patient
     * @param vaccinations Vaccinations of that patient
     */
    public PatientRecords(String height, String weight, String sex, List<String> allergies, List<String> vaccinations) {
        this.allergies = allergies;
        this.vaccinations = vaccinations;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
    }

    /**
     * Get patient record information.
     *
     * @return A string of patient record information
     */
    public String getPatientRecord() {
        return "Patient height: " + this.height + "\n" +
                "Patient weight: " + this.weight + "\n" +
                "Sex: " + this.sex + "\n" +
                "Allergies: " + getAllergies() + "\n" +
                "Vaccinations: " + getVaccinations();
    }

    /**
     * Get vaccination information.
     *
     * @return A string of all vaccines taken by patient
     */
    public String getVaccinations() {
        StringBuilder allVaccinations = new StringBuilder();
        for (String vaccine: this.vaccinations) {
            allVaccinations.append(vaccine);
            allVaccinations.append(", ");
        }
        allVaccinations.delete(allVaccinations.length() - 3, allVaccinations.length());
        return allVaccinations.toString();
    }

    /**
     * Get patient allergy information.
     *
     * @return A string of all patient allergies
     */
    public String getAllergies() {
        StringBuilder allAllergies = new StringBuilder();
        for (String allergy: this.allergies) {
            allAllergies.append(allergy);
            allAllergies.append(", ");
        }
        allAllergies.delete(allAllergies.length() - 3, allAllergies.length());
        return allAllergies.toString();
    }

    public void addVaccination(String vaccine) {
        this.vaccinations.add(vaccine);
    }

    public void addAllergy(String allergy) {
        this.allergies.add(allergy);
    }

    public void changeWeight(String weight) {
        this.weight = weight;
    }

    public void changeHeight(String height) {
        this.height = height;
    }
}
