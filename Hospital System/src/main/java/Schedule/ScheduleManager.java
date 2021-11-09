package Schedule;
// import java.time.format.DateTimeFormatter;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Patients.Patient;
import Patients.PatientData;
import Exceptions.InvalidInputException;
import Exceptions.StuffNotFoundException;

public class ScheduleManager {
    Schedule s;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    PatientData sessionData = new PatientData();
    Patient p;

    //since staff class is not implemented we will ignore the staff side schedule
    public ScheduleManager(Patient p) {
        sessionData = new PatientData();
        this.p = p;
        this.s = p.getSchedule();

    }

    public Schedule getSchedule() {
        return this.s;
    }

    public void add_or_modify_Event(String event, String start, String end) throws InvalidInputException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        if (!st.isBefore(e)) {
            throw new InvalidInputException("");
        } else {
            s.add_or_modify_Event(event, new Event(st, e));
            saveSchedule();
        }
    }

    public void remove_Event(String start, String end) throws StuffNotFoundException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        s.removeEvent(new Event(st, e));
        saveSchedule();
    }

    public String getScheduleString() {
        if (s == null) {
            return "You have no appointments for now.";
        }
        return s.getScheduleString();
    }

    private void saveSchedule() {
        sessionData.searchHCN(p.getHealthCardNum()).setSchedule(s);
        sessionData.saveData();
    }
}