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
        this.pm  =PatientManager.getInstance();
        this.stm = StaffManager.getInstance();
        this.sm = pm.getPatientScheduleManager(hcnOrId);
    }

    /**
     * Constructor for appointment maker
     *
     * @param id Staff id
     */
    public AppointmentMaker(Long id) {
        this.stm = StaffManager.getInstance();
        this.stms = new ScheduleManager(stm.getStaff(id));
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
     * @param event String name of event
     * @param start Start time and date
     * @param end   End time and date
     */
    public void makeAppointment(String event, String start, String end) throws InvalidInputException {
        sm.addOrModifyEvent(event, start, end);
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
}
