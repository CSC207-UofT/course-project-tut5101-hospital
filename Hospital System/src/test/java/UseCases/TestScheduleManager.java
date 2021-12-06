package UseCases;

import Entity.Schedule.Schedule;
import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestScheduleManager {
    private PatientManager pm = PatientManager.getInstance();
    private ScheduleManager smPatient;
    private ScheduleManager smP;
    private Schedule s = new Schedule();

    @Before
    public void setUp() throws Exception {
        long hcn = 453;
        pm.addPatient("Claire", "Female", 5, hcn, "growl", 0);
        smPatient = new ScheduleManager(pm.getPatient(hcn));
        smPatient.addOrModifyEvent("ill", "2000-01-01 01:01", "2000-01-01 05:01", hcn);
        pm.addPatient("Ash", "Female", 9, 222, "haha", 0);
        smP = new ScheduleManager(pm.getPatient(222));
    }

    @Test
    public void TestgetScheduleString() {
        Assert.assertEquals("Start:\t2000-01-01 01:01 Sat\t2000-01-01 05:01 Sat\t\tEvent:ill\tThis is the patient's health card number: 453\n",
                smPatient.getScheduleString());
    }

    @Test
    public void TestgetScheduleStringEmpty() {
        Assert.assertEquals("You have no appointments", smP.getScheduleString());
    }
}
