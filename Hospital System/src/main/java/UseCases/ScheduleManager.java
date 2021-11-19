package UseCases;
// import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Entity.Patients.Patient;
import Entity.Patients.PatientData;
import Entity.Staff.Staff;
import Exceptions.InvalidInputException;
import Exceptions.StuffNotFoundException;
import Schedule.Schedule;

public class ScheduleManager {
    Schedule s;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    PatientData sessionData;
    //fuzzy overloaded constructor: can accept staff or patient and accept their schedules
    public ScheduleManager(Schedule s){
        sessionData = new PatientData();
        this.s = s;
        
    }
    public ScheduleManager(Patient p){
        sessionData = new PatientData();
        this.s = p.getSchedule();

    }
    public ScheduleManager(Staff st){
        sessionData = new PatientData();
        this.s = st.getScdl();

    }


    public Schedule getSchedule(){
        return this.s;
    }public void add_or_modify_Event(String event, String start, String end) throws InvalidInputException{
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        if(!st.isBefore(e)){
            throw new InvalidInputException("");
        }else{
            s.add_or_modify_Event(event, Arrays.asList(st,e));
            saveSchedule();
        }
    }public void remove_Event(String start, String end) throws StuffNotFoundException{
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        List<LocalDateTime> list = Arrays.asList(st,e);
        s.removeEvent(list);
        saveSchedule();
    }public String getScheduleString(){
        if(s==null){
            return "You have no appointments for now.";
        }
        return s.getScheduleString();
    }private void saveSchedule(){
        sessionData.saveData();
    }
}