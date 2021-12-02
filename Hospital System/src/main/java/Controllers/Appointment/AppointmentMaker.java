package Controllers.Appointment;

import Entity.Schedule.Schedule;
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
    ScheduleManager sm;
    ScheduleManager sms;

    public AppointmentMaker(int hcnOrId) {
        this.pm = new PatientManager();
        this.stm = new StaffManager();
        this.sms = stm.getStaffSm(hcnOrId);
        this.sm = pm.getPatientScheduleManager(hcnOrId);
    }

    public String getSchedule() {
        return sm.getScheduleString();
    }

    public void makeAppointment(String event, String start, String end) throws InvalidInputException {
        sm.addOrModifyEvent(event, start, end);
    }

    public void deleteEvent(String start, String end) throws StaffNotFoundException {
        sm.removeEvent(start, end);
    }
}
