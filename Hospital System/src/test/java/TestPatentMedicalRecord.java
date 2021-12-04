import Entity.Operations.Operation;
import Entity.PatientRecords.PatientMedicalHistory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestPatentMedicalRecord {
    private PatientMedicalHistory patientMedicalHistory;
    private List<InputStream> medicalImages;

    @Before
    public void setUp() throws Exception {
        List<String> currentMedications = new ArrayList<>();
        currentMedications.add("Reactin");
        patientMedicalHistory = new PatientMedicalHistory("John", "120/80", "80",
                "40 degrees celcius", currentMedications, "Slight fever",
                "Given  1 does of tylenol", medicalImages);
    }

    @Test
    public void TestgetMedicalHistory() {
        Assert.assertEquals(patientMedicalHistory.getPatientMH(), "Physician Name: John" + "\n" +
                "Blood pressure: 120/80" + "\n" + "BPM: 80" + "\n" + "Temperature: 40 degrees celcius" + "\n" +
                "Current Medications: Reactin" + "\n" + "Physician Diagnosis: Slight fever" + "\n" +
                "Treatment given: Given  1 does of tylenol");
    }

    @Test
    public void TestgetCurrentMeds() {
        Assert.assertEquals(patientMedicalHistory.getCurrentMedications(), "Reactin");
    }

}
