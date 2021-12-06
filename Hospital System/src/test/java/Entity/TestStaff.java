package Entity;

import Entity.Schedule.Event;
import Entity.Schedule.Schedule;
import Entity.Staff.Doctor;
import Exceptions.InvalidInputException;
import UseCases.Staff.Builders.DoctorBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestStaff {

    private Doctor d;

    //Use doctor as an example
    @Before
    public void setUp() throws InvalidInputException {
        DoctorBuilder dm = new DoctorBuilder();
        Schedule workingTime = new Schedule();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime st = LocalDateTime.parse("2021-12-01 01:00", formatter);
        LocalDateTime e = LocalDateTime.parse("2021-12-01 02:00", formatter);
        Event eventStaff = new Event(st, e);
        workingTime.addOrModifyEvent("Ill", eventStaff);
        dm.setName("John");
        dm.setGender("Male");
        dm.setWorkingTime(workingTime);
        dm.setId(1);
        dm.setPwd("1");
        dm.setSalary(1000.0);
        d = dm.getResult();
    }

    @Test
    public void TestGetID(){
        Assert.assertEquals(d.getStaffID(), 1);
    }

    @Test
    public void TestGetPwd(){
        Assert.assertEquals(d.getPwd(), "1");
    }

    @Test
    public void TestGetSalary(){
        Assert.assertEquals(d.getSalary(), 1000.0, 1);
    }

    @Test
    public void TestGetStaffInfo(){
        Assert.assertEquals(d.getStaffInfo(), "Entity.Staff Name: John" + "\n" +
                "Gender: Male" + "\n" +
                "ID Number: 1");
    }
}
