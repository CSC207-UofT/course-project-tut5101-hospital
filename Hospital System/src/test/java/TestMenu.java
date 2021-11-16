import Entity.Patients.PatientData;
import Entity.Patients.Patient;
import UseCases.PatientManager;
import Schedule.Schedule;
import UseCases.ScheduleManager;
import Controllers.LoginSignup;
import Controllers.AppointmentMaker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMenu {

    private LoginSignup loginSignup;
    private PatientData patientData;
    private Patient patient;
    private PatientManager patientManager;
    private AppointmentMaker appointmentMaker;
    private Schedule schedule;
    private ScheduleManager scheduleManager;


    @Before
    public void setUp() throws Exception {
        loginSignup = new LoginSignup();
        loginSignup.signUp("Harry", "Male", 1, 2, "3");
        patientData = new PatientData();
        patient = new Patient("Harry", "Male", 1, 2, "3");
        patientManager = new PatientManager();
        appointmentMaker = new AppointmentMaker(2);
        appointmentMaker.makeAppointment("x-ray","2020-10-01 10:00", "2020-10-01 11:00");
        scheduleManager = new ScheduleManager(patient);

    }

    @Test
    public void TestLoginSignUpHCNexist() {
        Assert.assertTrue("Health card should be added into the system as part of the signup", loginSignup.check_if_patient_exists(2));
    }

    @Test
    public void TestPatientDatacontainsPatient() {
        Assert.assertEquals("Patient information should be stored in Patient Data",
                "Patient Name: Harry" + "\n" + "Gender: Male" + "\n" + "Contact Number: 1" + "\n" + "Health Card Number: 2",
                patientData.viewPatient(patient));
    }

    @Test
    public void TestSchedule() {
        Assert.assertEquals("Patient appointment is in the schedule",
                "Start-End:\t2020-10-01 10:00 Tue\t2020-10-01 11:00 Tue\t\tEvent:x-ray",
                scheduleManager.getScheduleString());
    }



}
