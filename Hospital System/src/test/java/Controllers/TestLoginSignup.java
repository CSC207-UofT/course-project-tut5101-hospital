package Controllers;

import Controllers.LoginSignUp.LoginSignup;
import Entity.Patients.Patient;
import Entity.Schedule.Schedule;
import UseCases.Patient.PatientManager;
import UseCases.Staff.StaffManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLoginSignup {
    private LoginSignup ls;
    private PatientManager pm = PatientManager.getInstance();
    private long hcn;
    private StaffManager sm = StaffManager.getInstance();
    private long IDdoctor;
    private Schedule sDoctor = new Schedule();
    private long id = 9;

    @Before
    public void setUp() throws Exception {
        ls = new LoginSignup();
        hcn = 453;
        ls.signUpForPatients("Claire", "Female", 5, 453, "growl", 0);
        IDdoctor = 333;
        ls.signUpForDoctors("Adam", "F", IDdoctor, sDoctor, "666", 35);

    }

    @Test
    public void TestcheckIfPatientExists() {
        Assert.assertTrue(ls.checkIfPatientExists(hcn));
    }

    @Test
    public void TestcheckIfStaffExists() {
        Assert.assertTrue(ls.checkIfStaffExists(IDdoctor));
    }

    @Test
    public void TestcheckIfPatientNotExists() {
        Assert.assertFalse(ls.checkIfPatientExists(525));
    }

    @Test
    public void TestcheckIfStaffNotExists() {
        Assert.assertFalse(ls.checkIfStaffExists(id));
    }

    @Test
    public void TestLoginForPatients() {
        Assert.assertTrue(ls.LoginForPatients(hcn, "growl"));
    }

    @Test
    public void TestLoginForPatientsWrongPW() {
        Assert.assertFalse(ls.LoginForPatients(hcn, "ggs"));
    }

    @Test
    public void TestLoginForStaff() {
        Assert.assertTrue(ls.LoginForStaffs(IDdoctor, "666"));
    }

    @Test
    public void TestLoginForStaffWrongPW() {
        Assert.assertFalse(ls.LoginForPatients(IDdoctor, "rip"));
    }

    @Test
    public void TestinitPatient(){
        Assert.assertEquals(ls.initPatient(hcn).getPatientInfo(),  "Patient Name: Claire"  + "\n" +
                "Gender: Female" + "\n" +
                "Contact Number: 5"  + "\n" +
                "Health Card Number: 453" +
                "Money In Account: 0");
    }

    @Test
    public void TestintiStaff(){
        Assert.assertEquals(ls.initStaff(IDdoctor).getStaffInfo(), "Entity.Staff Name: Adam" + "\n" +
                "Gender: F" + "\n" +
                "ID Number: 333");
    }

}
