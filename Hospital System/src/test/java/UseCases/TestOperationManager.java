package UseCases;

import Entity.Operations.Operation;
import Entity.Patients.Patient;
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
        Doctor doctor = new Doctor();
        Patient patient = new Patient();
        Operation operation = new Operation(100, "Appendicitis", "Appendix removal", optTime);
        OperationManager opPatient = new OperationManager(patient);
        OperationManager opDoctor = new OperationManager(doctor);
        OperationBonusCalculator opBonus = new OperationBonusCalculator(doctor, operation);
        OperationFeeCalculator opFee = new OperationFeeCalculator(patient, operation);

    }

    @Test
    public void TestOperationFeeCalculator() {
    //    Assert.assertEquals(opFee.finish(), 100);
    }

    @Test
    public void TestOperationBonusCalculator() {
     //   Assert.assertEquals(opBonus.finish(), 20);
    }


}
