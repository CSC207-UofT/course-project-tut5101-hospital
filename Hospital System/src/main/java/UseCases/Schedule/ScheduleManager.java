package UseCases.Schedule;
// import java.time.format.DateTimeFormatter;

import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Entity.Patients.Patient;
import Entity.Patients.PatientData;
import Entity.Schedule.Event;
import Entity.Staff.Staff;
import Exceptions.InvalidInputException;
import Exceptions.StuffNotFoundException;
import Entity.Schedule.Schedule;

public class ScheduleManager {
    /**
     * Schedule manager use case
     */
    Schedule s;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    PatientData sessionData;


    /**
     * Constructor for schedule manager when input is schedule
     * @param s
     */
    public ScheduleManager(Schedule s) {
        sessionData = new PatientData();
        this.s = s;

    }

    /**
     * Constructor for schedule manager when input is patient
     * @param p
     */
    public ScheduleManager(Patient p) {
        sessionData = new PatientData();
        this.s = p.getSchedule();

    }

    /**
     * Constructor for schedule manager when input is staff
     * @param st
     */
    public ScheduleManager(Staff st) {
        sessionData = new PatientData();
        this.s = st.getScdl();

    }


    public Schedule getSchedule() {
        return this.s;
    }

    /**
     * Add or modify event
     * @param event
     * @param start
     * @param end
     * @throws InvalidInputException
     */
    public void addOrModifyEvent(String event, String start, String end) throws InvalidInputException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        if (!st.isBefore(e)) {
            throw new InvalidInputException("");
        } else {
            s.add_or_modify_Event(event, new Event(st, e));
            saveSchedule();
        }
    }

    /**
     * Remove event
     * @param start
     * @param end
     * @throws StuffNotFoundException
     */
    public void removeEvent(String start, String end) throws StuffNotFoundException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        Event ev = new Event(st, e);
        s.removeEvent(ev);
        saveSchedule();
    }

    /**
     * Get schedule string
     * @return
     */
    public String getScheduleString() {
        if (s == null) {
            return "You have no appointments for now.";
        }
        return s.getScheduleString();
    }

    /**
     * Save schedule
     */
    private void saveSchedule() {
        sessionData.saveData();
    }
}