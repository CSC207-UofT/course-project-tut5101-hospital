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
        pm.addPatient("Claire", "Female", 5, 453, "growl", 0);
        patient = pm.newPatient("Claire", "Female", 5, 453, "growl", 0);
    }

    @Test
    public void TestNewPatient() {
        Assert.assertEquals(patient.getPatientInfo(), pm.getPatient(453).getPatientInfo());
    }

    @Test
    public void TestcheckifPatientexist() {
        Assert.assertTrue(pm.checkIfPatientExist(453));
    }

    @Test
    public void TestcheckLoginInfo() {
        Assert.assertTrue(pm.checkLoginInfo(453, "growl"));
    }


}
