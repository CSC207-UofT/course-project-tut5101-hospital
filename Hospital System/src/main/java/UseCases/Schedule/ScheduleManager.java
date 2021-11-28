package UseCases.Schedule;
// import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Entity.Patients.Patient;
import Entity.Patients.PatientData;
import Entity.Schedule.Event;
import Entity.Staff.Staff;
import Entity.Staff.StaffData;
import Exceptions.InvalidInputException;
import Exceptions.StaffNotFoundException;
import Entity.Schedule.Schedule;

public class ScheduleManager {
    Schedule s;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    PatientData sessionData;
    StaffData staffData;

    //fuzzy overloaded constructor: can accept staff or patient and accept their schedules
    public ScheduleManager(Schedule s) {
        sessionData = new PatientData();
        this.s = s;

    }

    public ScheduleManager(Patient p) {
        sessionData = new PatientData();
        this.s = p.getSchedule();

    }

    public ScheduleManager(Staff st) {
        staffData = new StaffData();
        this.s = st.getScdl();

    }


    public Schedule getSchedule() {
        return this.s;
    }

    public void addOrModifyEvent(String event, String start, String end) throws InvalidInputException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        if (!st.isBefore(e)) {
            throw new InvalidInputException("");
        } else {
            s.addOrModifyEvent(event, new Event(st,e));
            saveSchedule();
        }
    }

    public void removeEvent(String start, String end) throws StaffNotFoundException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        Event ev = new Event(st, e);
        s.removeEvent(ev);
        saveSchedule();
    }

    public String getScheduleString() {
        if (s == null) {
            return "You have no appointments for now.";
        }
        return s.getScheduleString();
    }

    private void saveSchedule() {
        sessionData.saveData();
    }

    private void saveStaffSchedule(){
        staffData.saveData();
    }

    public Schedule staffSchedule(String event) throws InvalidInputException {
        Schedule s = new Schedule();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime st = LocalDateTime.parse("2021-12-01 01:00", formatter);
        LocalDateTime e = LocalDateTime.parse("2021-12-31 11:00", formatter);
        while (st.isBefore(e)){
            if (!st.isBefore(e)) {
                throw new InvalidInputException("");
            } else {
                Event eventStaff = new Event(st, e);
                s.addOrModifyEvent(event, eventStaff);
                st = st.plusHours(1);
            }
        }
        saveStaffSchedule();
        return s;
    }
}