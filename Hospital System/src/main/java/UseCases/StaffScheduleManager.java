package UseCases;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Entity.Staff.Staff;
import Entity.Staff.StaffData;
import Exceptions.InvalidInputException;
import Exceptions.StuffNotFoundException;
import Schedule.Schedule;

public class StaffScheduleManager {
    Schedule s;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    StaffData sessionData = new StaffData();
    Staff p;
    public StaffScheduleManager(Schedule s){
        sessionData = new StaffData();
        this.s = s;

    }public Schedule getSchedule(){
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
        sessionData.searchID(p.getStaffID()).setSchedule(s);
        sessionData.saveData();
    }
}