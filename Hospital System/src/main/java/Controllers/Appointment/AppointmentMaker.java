package Controllers.Appointment;

// Avoid Clean Ar

import Entity.Staff.Staff;

import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;

import Exceptions.StaffNotFoundException;
import Exceptions.InvalidInputException;
import UseCases.Staff.StaffManager;


public class AppointmentMaker {
    /**
     * This file contains the main system for the hospital and is used to make appointments for patients
     */
    PatientManager pm;
    StaffManager stm;
    ScheduleManager sm, stms;

    /**
     * Constructor for appointment maker
     *
     * @param hcnOrId Patient health card number or Staff id
     */
    public AppointmentMaker(long hcnOrId) {
        this.pm = PatientManager.getInstance();
        this.stm = StaffManager.getInstance();
        this.sm = pm.getPatientScheduleManager(hcnOrId);
        this.stms = stm.getStaffSm(hcnOrId);
    }


    /**
     * Get patient schedule
     *
     * @return A string of appointment event names and time and date of events
     */
    public String getSchedule() {
        return sm.getScheduleString();
    }

    /**
     * Get staff schedule
     *
     * @return A string of appointment event names and time and date of events
     */
    public String checkStaffSchedule() {
        return stms.getScheduleString();
    }

    /**
     * Makes an appointment for event at start time and day until end time and day
     *
     * @param c User input choice
     * @param event String name of event
     * @param id   id of staff
     */
    public void makeAppointment(String c, String event, Long id, long hcn) throws InvalidInputException {
        sm.makeAppointment(c, event, id, hcn);
        ScheduleManager smStaff = new ScheduleManager(stm.getStaff(id));
        smStaff.makeAppointment(c, event, id, hcn);
    }

    public void viewChoices(){
        sm.viewScheduleChoices();
    }

    /**
     * Deletes an appointment for start time and day until end time and day
     *
     * @param start Start time and date
     * @param end   End time and date
     */
    public void deleteEvent(String start, String end) throws StaffNotFoundException {
        sm.removeEvent(start, end);
    }

    /**
     * Deletes all appointments

     */
    public void deleteAllEvent() throws StaffNotFoundException {
        sm.removeEvent("2021-12-01 08:00", "2021-12-01 09:00");
        sm.removeEvent("2021-12-01 09:00", "2021-12-01 10:00");
        sm.removeEvent("2021-12-01 10:00", "2021-12-01 11:00");
        sm.removeEvent("2021-12-01 11:00", "2021-12-01 12:00");
        sm.removeEvent("2021-12-01 12:00", "2021-12-01 13:00");
        sm.removeEvent("2021-12-01 13:00", "2021-12-01 14:00");
        sm.removeEvent("2021-12-01 14:00", "2021-12-01 15:00");
        sm.removeEvent("2021-12-01 15:00", "2021-12-01 16:00");
    }
}
