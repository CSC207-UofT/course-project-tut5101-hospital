package Entity;

import Entity.Patients.Patient;
import Entity.Patients.PatientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPatient {

    private Patient p;

    @Before
    public void setUp() {
        PatientBuilder pm = new PatientBuilder();
        pm.setContactNumber(10086);
        pm.setGender("Male");
        pm.setHcn(100100);
        pm.setPwd("1001");
        pm.setName("John");
        pm.setFee(100);
        p = pm.getPatient();
    }

    @Test
    public void TestPatientSetUp(){
        Assert.assertEquals(p.getPatientInfo(),  "Patient Name: John"  + "\n" +
                "Gender: Male" + "\n" +
                "Contact Number: 10086"  + "\n" +
                "Health Card Number: 100100" +
                "Money In Account: 100");
    }

    @Test
    public void TestAddMinusFee(){
        p.addFee(50);
        Assert.assertEquals(p.getFee(), 150);
        p.payFee(100);
        Assert.assertEquals(p.getFee(), 50);
    }
}
