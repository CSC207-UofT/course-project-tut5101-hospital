package Controllers;

import Schedule.ScheduleManager;

import Exceptions.StuffNotFoundException;
import Exceptions.InvalidInputException;
import Patients.PatientManager;

/** This file contains the main system for the hospital and is used to make appointments for patients
 *
 */

public class AppointmentMaker {
    PatientManager pm;
    ScheduleManager sm;
    public AppointmentMaker(int hcn){
        this.pm = new PatientManager();
        this.sm = new ScheduleManager(pm.getPatient(hcn));
    }public String getSchedule(){
        return sm.getScheduleString();
    }public void makeAppointment(String event, String start, String end) throws InvalidInputException{
        sm.add_or_modify_Event(event, start, end);
    }public void deleteEvent(String start, String end) throws StuffNotFoundException{
        sm.remove_Event(start, end);
    }
}
