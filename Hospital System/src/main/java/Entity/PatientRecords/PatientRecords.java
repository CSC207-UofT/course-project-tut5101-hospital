package Entity.PatientRecords;

import java.util.List;


public class PatientRecords implements java.io.Serializable{
    private Float height;
    private Float weight;
    private final String sex;
    private final List<String> allergies;
    private final List<String> vaccinations;

    public PatientRecords(Float height, Float weight, String sex, List<String> allergies, List<String> vaccinations) {

        this.allergies = allergies;
        this.vaccinations = vaccinations;
        this.height = height;
        this.weight = weight;
        this.sex = sex;

    }

    public String getPatientRecord() {
        return "Patient height: " + this.height + "\n" +
                "Patient weight: " + this.height + "\n" +
                "Gender: " + this.sex + "\n" +
                "Allergies: " + this.allergies + "\n" +
                "Vaccinations: " + this.vaccinations;
    }

    public void addVaccination(String vaccine) {
        this.vaccinations.add(vaccine);
    }

    public void addAllergy(String allergy) {
        this.allergies.add(allergy);
    }

    public void changeWeight(Float weight) {
        this.weight = weight;
    }

    public void changeHeight(Float height) {
        this.height = height;
    }
}
