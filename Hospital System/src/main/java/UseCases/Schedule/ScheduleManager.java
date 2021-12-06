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

public class ScheduleManager implements ScheduleManaging {
    /**
     * Schedule manager use case
     */
    Schedule s;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    PatientData sessionData;
    StaffData staffData;


    /**
     * Constructor for schedule manager when input is schedule
     *
     * @param s Schedule
     */
    public ScheduleManager(Schedule s) {
        sessionData = new PatientData();
        staffData = new StaffData();
        this.s = s;

    }

    /**
     * Constructor for schedule manager when input is patient
     *
     * @param p patient
     */
    public ScheduleManager(Patient p) {
        sessionData = new PatientData();
        staffData = new StaffData();
        this.s = p.getSchedule();

    }

    /**
     * Constructor for schedule manager when input is staff
     *
     * @param st staff
     */
    public ScheduleManager(Staff st) {
        staffData = new StaffData();
        this.s = st.getScdl();

    }


    @Override
    public Schedule getSchedule() {
        return this.s;
    }

    /**
     * Add or modify event
     *
     * @param event String name of event
     * @param start Start time and date
     * @param end   End time and date
     * @throws InvalidInputException
     */
    @Override
    public void addOrModifyEvent(String event, String start, String end) throws InvalidInputException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        if (!st.isBefore(e)) {
            throw new InvalidInputException("");
        } else {
            s.addOrModifyEvent(event, new Event(st, e));
            saveSchedule();
            saveStaffSchedule();
        }
    }

    /**
     * Remove event
     *
     * @param start Start time and date
     * @param end   End time and date
     * @throws StaffNotFoundException
     */
    @Override
    public void removeEvent(String start, String end) throws StaffNotFoundException {
        LocalDateTime st = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);
        Event ev = new Event(st, e);
        s.removeEvent(ev);
        saveSchedule();
        saveStaffSchedule();
    }

    /**
     * Get schedule string
     *
     * @return String of appointment event names and time and date of events
     */
    @Override
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

    private void saveStaffSchedule() {
        staffData.saveData();
    }

    public void makeAppointment(String c, String event, Long id, long hcn) throws InvalidInputException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String st = "";
        String e = "";
        switch (c) {
            case "1": {
                st ="2021-12-01 08:00";
                e = "2021-12-01 09:00";
                break;
            }
            case "2": {
                st ="2021-12-01 09:00";
                e = "2021-12-01 10:00";
                break;
            }
            case "3": {
                st = "2021-12-01 10:00";
                e = "2021-12-01 11:00";
                break;
            }
            case "4": {
                st = "2021-12-01 11:00";
                e = "2021-12-01 12:00";
                break;
            }
            case "5": {
                st = "2021-12-01 12:00";
                e = "2021-12-01 13:00";
                break;
            }
            case "6": {
                st = "2021-12-01 13:00";
                e = "2021-12-01 14:00";
                break;
            }
            case "7": {
                st = "2021-12-01 14:00";
                e = "2021-12-01 15:00";
                break;
            }
            case "8": {
                st = "2021-12-01 15:00";
                e = "2021-12-01 16:00";
                break;
            }
            default: throw new IllegalStateException("Unexpected value: " + c);
        }
        addOrModifyEvent(event, st, e);
        saveSchedule();
        saveStaffSchedule();
    }

    public void viewScheduleChoices(){
        System.out.println("You can choose from these time choices");
        System.out.println("Choice 1: Start: 2021-12-01 08:00 " +
                "End:2021-12-01 09:00 (Enter 1 to choose this)");
        System.out.println("Choice 2: Start: 2021-12-01 09:00 " +
                "End:2021-12-01 10:00 (Enter 2 to choose this)");
        System.out.println("Choice 3: Start: 2021-12-01 10:00 " +
                "End:2021-12-01 11:00 (Enter 3 to choose this)");
        System.out.println("Choice 4: Start: 2021-12-01 11:00 " +
                "End:2021-12-01 12:00 (Enter 4 to choose this)");
        System.out.println("Choice 5: Start: 2021-12-01 12:00 " +
                "End:2021-12-01 13:00 (Enter 5 to choose this)");
        System.out.println("Choice 6: Start: 2021-12-01 13:00 " +
                "End:2021-12-01 14:00 (Enter 6 to choose this)");
        System.out.println("Choice 7: Start: 2021-12-01 14:00 " +
                "End:2021-12-01 15:00 (Enter 7 to choose this)");
        System.out.println("Choice 8: Start: 2021-12-01 15:00 " +
                "End:2021-12-01 16:00 (Enter 8 to choose this)");
    }

    @Override
    public Schedule staffSchedule(String event) throws InvalidInputException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime st = LocalDateTime.parse("2021-12-01 01:00", formatter);
        LocalDateTime stEnd = LocalDateTime.parse("2021-12-01 02:00", formatter);
        LocalDateTime e = LocalDateTime.parse("2021-12-15 11:00", formatter);
        while (st.isBefore(e)) {
            if (!st.isBefore(e)) {
                throw new InvalidInputException("");
            } else {
                Event eventStaff = new Event(st, stEnd);
                s.addOrModifyEvent(event, eventStaff);
                stEnd = stEnd.plusHours(1);
                st = st.plusHours(1);
            }
        }
        saveStaffSchedule();
        return s;
    }
}