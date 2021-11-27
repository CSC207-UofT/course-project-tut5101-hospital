package Entity.PatientRecords;
import Entity.Operations.Operation;
import Entity.Operations.OperationList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class PatientRecords {
    private String physicianName;
    private Operation operation;
    private String bloodPressure;
    private String pulse;
    private String temperature;
    private List<String> currentMedications;
    private String diagnosis;
    private String treatment;
    private List<InputStream> medicalImage;

    public PatientRecords(String physicianName, String bloodPressure, String pulse, String temperature,
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
}
