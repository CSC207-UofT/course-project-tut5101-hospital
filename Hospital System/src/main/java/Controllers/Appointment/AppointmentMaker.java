package Controllers.Appointment;

import UseCases.Patient.PatientManager;
import UseCases.Patient.PatientManaging;
import UseCases.Schedule.ScheduleManager;

import Exceptions.StuffNotFoundException;
import Exceptions.InvalidInputException;

/**
 * This file contains the main system for the hospital and is used to make appointments for patients
 */

public class AppointmentMaker {
    PatientManaging pm;
    ScheduleManager sm;

    public AppointmentMaker(int hcn) {
        this.pm = new PatientManager();
        this.sm = pm.getPatientSm(hcn);
    }

    public String getSchedule() {
        return sm.getScheduleString();
    }

    public void makeAppointment(String event, String start, String end) throws InvalidInputException {
        sm.addOrModifyEvent(event, start, end);
    }

    public void deleteEvent(String start, String end) throws StuffNotFoundException {
        sm.removeEvent(start, end);
    }
}
