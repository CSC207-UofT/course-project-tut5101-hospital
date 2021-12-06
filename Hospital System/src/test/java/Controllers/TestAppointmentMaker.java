package Controllers;

import Controllers.Appointment.AppointmentMaker;
import Entity.Schedule.Schedule;
import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAppointmentMaker {
    private AppointmentMaker amPatient;
    private AppointmentMaker amP;
    private PatientManager pm = PatientManager.getInstance();
    private ScheduleManager scheduleManagerP;


    @Before
    public void setUp() throws Exception {
        long hcn = 453;
        pm.addPatient("Claire", "Female", 5, hcn, "growl", 0);
        pm.addPatient("Cl", "male", 5, 765, "growl", 0);
        scheduleManagerP = new ScheduleManager(pm.getPatient(hcn));
        amPatient = new AppointmentMaker(hcn, "hcn");
        amP = new AppointmentMaker(765, "hcn");
        scheduleManagerP = new ScheduleManager(pm.getPatient(hcn));
        scheduleManagerP.addOrModifyEvent("ill", "2000-01-01 01:01", "2000-01-01 05:01", hcn);
    }

    @Test
    public void TestgetScheduleEmpty() {
        Assert.assertEquals("You have no appointments", amP.getSchedule());
    }


    @Test
    public void TestgetSchedule() {
        Assert.assertEquals("Start:\t2000-01-01 01:01 Sat\t2000-01-01 05:01 Sat\t\tEvent:ill\t" +
                "This is the patient's health card number: 453\n", amPatient.getSchedule());
    }

}
