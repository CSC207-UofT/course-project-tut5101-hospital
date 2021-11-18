package Controllers;

import UseCases.PatientScheduleManager;

import Exceptions.StuffNotFoundException;
import Exceptions.InvalidInputException;
import UseCases.PatientManager;

/** This file contains the main system for the hospital and is used to make appointments for patients
 *
 */

public class AppointmentMaker {
    PatientManager pm;
    PatientScheduleManager sm;
    public AppointmentMaker(int hcn){
        this.pm = new PatientManager();
        this.sm = pm.getPatientSm(hcn);
    }public String getSchedule(){
        return sm.getScheduleString();
    }public void makeAppointment(String event, String start, String end) throws InvalidInputException{
        sm.add_or_modify_Event(event, start, end);
    }public void deleteEvent(String start, String end) throws StuffNotFoundException{
        sm.remove_Event(start, end);
    }
}
