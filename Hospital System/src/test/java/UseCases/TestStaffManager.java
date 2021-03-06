package UseCases;

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;
import UseCases.Staff.StaffManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestStaffManager {
    private StaffManager sm = StaffManager.getInstance();
    private long IDnurse;
    private long IDadmin;
    private long IDaccountant;
    private long IDdoctor;
    private Schedule sNurse = new Schedule();
    private Schedule sDoctor = new Schedule();
    private Schedule sAdmin = new Schedule();
    private Schedule sAccountant = new Schedule();

    @Before
    public void setUp() throws Exception {
        IDnurse = 111;
        IDaccountant = 222;
        IDdoctor = 333;
        IDadmin = 444;
        sm.addAccountant("Jam", "M", IDaccountant, sAccountant, "999", 25);
        sm.addAdmin("Jim", "M", IDadmin, sAdmin, "888", 20);
        sm.addNurse("Angela", "F", IDnurse, sNurse, "777", 25);
        sm.addDoctor("Adam", "F", IDdoctor, sDoctor, "666", 35);
    }

    @Test
    public void TestaddNurse() {
        Assert.assertTrue(sm.checkIfStaffExist(IDnurse));
    }

    @Test
    public void TestaddDoctor() {
        Assert.assertTrue(sm.checkIfStaffExist(IDdoctor));
    }

    @Test
    public void TestaddAdmin() {
        Assert.assertTrue(sm.checkIfStaffExist(IDadmin));
    }

    @Test
    public void TestaddAccountant() {
        Assert.assertTrue(sm.checkIfStaffExist(IDaccountant));
    }

    @Test
    public void TestgetSalary() {
        Assert.assertEquals(35, sm.getSalary(IDdoctor), 0);
    }

    @Test
    public void TestgetStaffInfo() {
        Assert.assertEquals("Entity.Staff Name: Jim" + "\n" + "Gender: M" + "\n" +
                "ID Number: 444", sm.getStaffInfo(IDadmin));
    }

    @Test
    public void TestgetStaffTypeAdmin() {
        Assert.assertEquals("Admin", sm.getStaffType(IDadmin));
    }

    @Test
    public void TestgetStaffTypeDoctor() {
        Assert.assertEquals("Doctor", sm.getStaffType(IDdoctor));
    }

    @Test
    public void TestgetStaffTypeNurse() {
        Assert.assertEquals("Nurse", sm.getStaffType(IDnurse));
    }
}
