package UseCases;

import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecordList;
import Entity.PatientRecords.PatientRecords;
import Entity.Patients.Patient;
import UseCases.Patient.PatientManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class TestPatientManager {
    private PatientManager pm = PatientManager.getInstance();
    private Patient patient;
    private PatientRecords patientRecords;
    private PatientMedicalHistory patientMedicalHistory;
    private PatientMedicalHistory patientMH;

    @Before
    public void setUp() throws Exception {
        pm.addPatient("Claire", "Female", 5, 453, "growl", 0);
        patient = pm.newPatient("Claire", "Female", 5, 453, "growl", 0);
        List<String> vaccinations = new ArrayList<>();
        vaccinations.add("pfizer");
        List<String> allergies = new ArrayList<>();
        allergies.add("dust");
        allergies.add("pollen");
        allergies.add("animal hair");
        patientRecords = new PatientRecords("5ft4", "120 lbs", "Male", allergies, vaccinations);
        patient.getPRL().addRecord(patientRecords, "2000-03-25 11:36");
        List<String> currentMedications = new ArrayList<>();
        currentMedications.add("Reactin");
        patientMedicalHistory = new PatientMedicalHistory("John", "120/80", "80",
                "40 degrees celcius", currentMedications, "Slight fever",
                "Given  1 does of tylenol");
        patient.getPRL().addHistory(patientMedicalHistory, "2000-03-25 12:19");
        List<String> cm = new ArrayList<>();
        cm.add("None");
        patientMH = new PatientMedicalHistory("John", "120/80", "80",
                "35 degrees celcius", cm, "Ill",
                "Given  1 does of tylenol");
        patient.getPRL().addHistory(patientMH, "2003-06-14 16:49");
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

    @Test
    public void TestgetPatientMedicalRecord() {
       Assert.assertEquals(patientMedicalHistory.getPatientMH() + patientMH.getPatientMH(), pm.getPatientMedicalRecord(453));
    }

    @Test
    public void TestgetPatientRecord() {
        Assert.assertEquals(patientRecords.getPatientRecord(), pm.getPatientRecord(435));
    }
}
