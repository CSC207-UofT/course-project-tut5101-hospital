package UseCases;

import Entity.PatientRecords.PatientMedicalHistory;
import Entity.PatientRecords.PatientRecords;
import Entity.Patients.Patient;
import UseCases.Patient.PatientManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPatientRecordListManager {
    private PatientManager pm = PatientManager.getInstance();
    private Patient patient;
    private PatientRecordListManager pRLm;
    private PatientRecords pr;
    private PatientMedicalHistory pmh;


    @Before
    public void setUp() throws Exception {
        pm.addPatient("Claire", "Female", 5, 453, "growl", 0);
        patient = pm.getPatient(453);
        pRLm = new PatientRecordListManager(patient);
        List<String> currentMedications = new ArrayList<>();
        currentMedications.add("Reactin");
        List<String> vaccinations = new ArrayList<>();
        vaccinations.add("pfizer");
        List<String> allergies = new ArrayList<>();
        allergies.add("dust");
        allergies.add("pollen");
        allergies.add("animal hair");
        pr = new PatientRecords("5", "5","Male", allergies, vaccinations);
        pmh = new PatientMedicalHistory("Jane", "120/20", "78", "35",
                currentMedications, "you are dying", "cannot be saved");
        pRLm.addHistory(pmh, "2000-30-11 02:03");
        pRLm.addRecord(pr,"2000-30-11 01:03");
    }

    @Test
    public void TestaddHistory() {
        Assert.assertEquals(pm.getPatientMedicalRecord(453), "Physician Name: Jane" + "\n" +
                "Blood pressure: 120/20" + "\n" + "BPM: 78" + "\n" + "Temperature: 35" + "\n" +
                "Current Medications: Reactin" + "\n" + "Physician Diagnosis: you are dying" + "\n" +
                "Treatment given: cannot be saved");
    }

    @Test
    public void TestaddRecord() {
        Assert.assertEquals(pm.getPatientRecord(453), "Patient height: 5" + "\n" +
                "Patient weight: 5" + "\n" + "Sex: Male" + "\n" +
                "Allergies: dust, pollen, animal hair" + "\n" + "Vaccinations: pfizer");
    }
}
