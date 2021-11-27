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
    /**
     * Controller for appointment to make appointment
     */
    PatientManaging patientManaging;
    ScheduleManager scheduleManager;

    /**
     * Constructor for Appointment Maker, accept a health card number
     *
     * @param healthCardNumber
     */
    public AppointmentMaker(int healthCardNumber) {
        this.patientManaging = new PatientManager();
        this.scheduleManager = patientManaging.getPatientSm(healthCardNumber);
    }

    /**
     * Get schedule that represented by string
     *
     * @return
     */
    public String getSchedule() {
        return scheduleManager.getScheduleString();
    }

    /**
     * Make appointment by schedule manager
     *
     * @param event
     * @param start
     * @param end
     * @throws InvalidInputException
     */
    public void makeAppointment(String event, String start, String end) throws InvalidInputException {
        scheduleManager.addOrModifyEvent(event, start, end);
    }

    /**
     * Cancel event by schedule manager
     *
     * @param start
     * @param end
     * @throws StuffNotFoundException
     */
    public void deleteEvent(String start, String end) throws StuffNotFoundException {
        scheduleManager.removeEvent(start, end);
    }
}
