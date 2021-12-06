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
    private Schedule s = new Schedule();

    @Before
    public void setUp() throws Exception {
        pm.addPatient("Claire", "Female", 5, 453, "growl", 0);
        smPatient = new ScheduleManager(pm.getPatient(453));
    }

    @Test
    public void TestgetSchedule() {
        Assert.assertEquals(s.getScheduleString(), smPatient.getScheduleString());
    }
}
