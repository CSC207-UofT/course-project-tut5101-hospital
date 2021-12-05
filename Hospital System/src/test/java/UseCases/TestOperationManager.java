package UseCases;

import Controllers.LoginSignUp.LoginSignup;
import Controllers.LoginSignUp.StaffSignUp.DoctorSignUp;
import Entity.Operations.Operation;
import Entity.Patients.Patient;
import Entity.Schedule.Schedule;
import Entity.Staff.Doctor;
import UseCases.Operation.OperationFacade.OperationBonusCalculator;
import UseCases.Operation.OperationFacade.OperationFeeCalculator;
import UseCases.Operation.OperationManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class TestOperationManager {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Before
    public void setUp() throws Exception {
        List<LocalDateTime> optTime = new ArrayList<>();
        LocalDateTime start = LocalDateTime.parse("2021-10-01 10:00", formatter);
        optTime.add(start);
        LocalDateTime end = LocalDateTime.parse("2021-10-01 12:00", formatter);
        optTime.add(end);
        LoginSignup loginSignup = new LoginSignup();
        loginSignup.signUpForPatients("Harry", "Male", 1, 2, "3", 0);
        Schedule scheduleDoc = new Schedule();
        loginSignup.signUpForDoctors("Jill", "Male", 10, scheduleDoc, "cuts", 40);
        Operation operation = new Operation(100, "Appendicitis", "Appendix removal", optTime);
        OperationManager opPatient = new OperationManager(loginSignup.initPatient(2));
        OperationManager opDoctor = new OperationManager((Doctor) loginSignup.initStaff(10));
        OperationBonusCalculator opBonus = new OperationBonusCalculator((Doctor) loginSignup.initStaff(10), operation);
        OperationFeeCalculator opFee = new OperationFeeCalculator(loginSignup.initPatient(2), operation);
    }

    @Test
    public void TestOperationFeeCalculator() {
        Assert.assertEquals(opFee.finish(), 100);
    }

    @Test
    public void TestOperationBonusCalculator() {
        Assert.assertEquals(opBonus.finish(), 20);
    }


}
