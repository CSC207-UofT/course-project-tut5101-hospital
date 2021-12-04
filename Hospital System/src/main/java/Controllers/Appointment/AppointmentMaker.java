package Controllers.Appointment;

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;
import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;

import Exceptions.StaffNotFoundException;
import Exceptions.InvalidInputException;
import UseCases.Staff.StaffManager;

/**
 * This file contains the main system for the hospital and is used to make appointments for patients
 */

public class AppointmentMaker {
    PatientManager pm;
    StaffManager stm;
    ScheduleManager sm, stms;

    public AppointmentMaker(int hcnOrId) {
        this.pm = new PatientManager();
        this.stm = new StaffManager();
        this.sm = pm.getPatientScheduleManager(hcnOrId);
    }

    public AppointmentMaker(Integer id){
        this.stm = new StaffManager();
        Staff staff = stm.getStaff(id);
        this.stms = new ScheduleManager(staff);
    }

    public String getSchedule() {
        return sm.getScheduleString();
    }


    public String checkStaffSchedule(){
        return stms.getScheduleString();
    }

    public void makeAppointment(String event, String start, String end) throws InvalidInputException {
        sm.addOrModifyEvent(event, start, end);
    }

    public void deleteEvent(String start, String end) throws StaffNotFoundException {
        sm.removeEvent(start, end);
    }
}
