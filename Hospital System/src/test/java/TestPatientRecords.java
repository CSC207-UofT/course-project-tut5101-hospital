import Entity.PatientRecords.PatientRecords;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestPatientRecords {
    private PatientRecords patientRecords;

    @Before
    public void setUp() throws Exception {
        List<String> vaccinations = new ArrayList<>();
        vaccinations.add("pfizer");
        List<String> allergies = new ArrayList<>();
        allergies.add("dust");
        allergies.add("pollen");
        allergies.add("animal hair");
        patientRecords = new PatientRecords("5ft4", "120 lbs", "Male", allergies, vaccinations);
    }

    @Test
    public void TestgetRecords() {
        Assert.assertEquals(patientRecords.getPatientRecord(), "Patient height: 5ft4" + "\n" +
                "Patient weight: 120 lbs" + "\n" + "Sex: Male" + "\n" +
                "Allergies: dust, pollen, animal hair" + "\n" + "Vaccinations: pfizer");
    }

    @Test
    public void TestgetAllergies() {
        Assert.assertEquals(patientRecords.getAllergies(), "dust, pollen, animal hair");
    }

    @Test
    public void TestgetVaccinations() {
        Assert.assertEquals(patientRecords.getVaccinations(), "pfizer");
    }

}
