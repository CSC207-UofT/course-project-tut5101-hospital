package UseCases;

import Entity.Patients.Patient;
import UseCases.Patient.PatientManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPatientManager {
    private PatientManager pm = PatientManager.getInstance();
    private Patient patient;

    @Before
    public void setUp() throws Exception {
        patient = pm.newPatient("Claire", "Female", 5, 453, "growl", 0);
    }

    @Test
    public void TestNewPatient() {
        Assert.assertEquals(patient ,pm.getPatient(453));
    }


}
