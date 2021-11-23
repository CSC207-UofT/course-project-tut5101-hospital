import Controllers.Appointment.AppointmentMaker;
import Controllers.LoginSignUp.LoginSignup;
import Entity.Patients.PatientData;
import Entity.Patients.Patient;
import Entity.Schedule.Schedule;
import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMenu {

    private LoginSignup loginSignup;
    private PatientData patientData;
    private Patient patient;
    private PatientManager patientManager;
    private AppointmentMaker appointmentMaker;
    private ScheduleManager scheduleManager;
    private Schedule schedule;
    private ScheduleManager patientScheduleManager;


    @Before
    public void setUp() throws Exception {
        loginSignup = new LoginSignup();
        loginSignup.signUpForPatients("Harry", "Male", 1, 2, "3");
        patientData = new PatientData();
        patient = new Patient("James", "Male", 9, 7, "bob");
        patientData.addOrModifyPatient(patient);
        patientData.removePatient(loginSignup.initPatient(3));
        patientManager = new PatientManager();
        appointmentMaker = new AppointmentMaker(2);
        appointmentMaker.makeAppointment("x-ray","2020-10-01 10:00", "2020-10-01 11:00");
        scheduleManager = new ScheduleManager(loginSignup.initPatient(2));
        patientScheduleManager = new ScheduleManager(patient);
    }

    @Test
    public void TestLoginSignUpHCNexist() {
        Assert.assertTrue("Health card should be added into the system as part of the signup", loginSignup.checkIfPatientExists(2));
    }

    @Test
    public void TestPatientDatacontainsPatient() {
        Assert.assertEquals("Patient information should be stored in Patient Data",
                "Patient Name: Harry" + "\n" + "Gender: Male" + "\n" + "Contact Number: 1" + "\n" + "Health Card Number: 2",
                patientData.viewPatient(loginSignup.initPatient(2)));
    }

    @Test
    public void TestAppointmentMaker() {
        Assert.assertEquals("Patient appointment is in the schedule",
                "Start-End:\t2020-10-01 10:00 Tue\t2020-10-01 11:00 Tue\tEvent:x-ray",
                scheduleManager.getScheduleString());
    }

    @Test
    public void TestPatient() {
        Assert.assertEquals("Patient class creates a patient", 7,
                patient.getHealthCardNum());
    }

    @Test
    public void TestAddorModifyPatient() {
        Assert.assertTrue("Patient information should be added to Patient Data", patientData.patientExist(7));
    }

}
