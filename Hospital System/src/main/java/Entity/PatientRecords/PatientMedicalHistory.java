package Entity.PatientRecords;

import java.util.ArrayList;
import java.util.List;

public class PatientMedicalHistory {
    private Float height;
    private Float weight;
    private String gender;
    private List<String> allergies;
    private List<String> vaccinations;

    public PatientMedicalHistory(Float height, Float weight, String gender, List<String> allergies, List<String> vaccinations) {
        this.allergies = allergies;
        this.vaccinations = vaccinations;
        this.height = height;
        this.weight = weight;
        this.gender = gender;  //remove from patient class later

    }

    public String getPatientMH() {
        return "Patient height: " + this.height + "\n" +
                "Patient weight: " + this.height + "\n" +
                "Gender: " + this.gender + "\n" +
                "Allergies: " + this.allergies + "\n" +
                "Vaccinations: " + this.vaccinations;
    }
}
