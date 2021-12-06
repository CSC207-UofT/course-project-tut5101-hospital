package Entity.Schedule;

import java.util.Map.Entry;

import Exceptions.InvalidInputException;
import Exceptions.StaffNotFoundException;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Schedule implements java.io.Serializable {
    /**
     * Schedule entity
     */
    private Long id;

    private final HashMap<Event, String> schedule = new HashMap<>();


    /**
     * Return schedule total Time In Minutes
     *
     * @return sum
     */
    public int totalTimeInMinutes() {
        int startTime;
        int endTime;
        int sum = 0;

        for (HashMap.Entry<Event, String> set : schedule.entrySet()) {
            startTime = set.getKey().getStartTime().getMinute();
            endTime = set.getKey().getEndTime().getMinute();
            sum = sum + (endTime - startTime);
        }
        return sum;
    }

    /**
     * Add or modify event
     *
     * @param event String name of event
     * @param dates Event start and end time and date
     * @throws InvalidInputException It is thrown when input is wrong
     */
    public void addOrModifyEventStaff(String event, Event dates) throws InvalidInputException {
        if (!schedule.containsKey(dates)) {
            this.schedule.put(dates, event);
        } else {
            throw new InvalidInputException("");
        }
    }

    /**
     * Add or modify event
     *
     * @param event String name of event
     * @param dates Event start and end time and date
     * @param hcn   health card number of patient
     * @throws InvalidInputException It is thrown when input is wrong
     */
    public void addOrModifyEvent(String event, Event dates, Long hcn) throws InvalidInputException {
        event = event + "\t" + "This is the patient's health card number: " + hcn.toString();
        if (!schedule.containsKey(dates)) {
            this.schedule.put(dates, event);
        } else {
            throw new InvalidInputException("");
        }
    }

    /**
     * Remove event
     *
     * @param dates Event start and end time and date
     * @throws StaffNotFoundException It is thrown if there is no such staff
     */
    public void removeEvent(Event dates) throws StaffNotFoundException {
        boolean ex = true;
        for (Event key : schedule.keySet()) {
            if ((key.getEndTime() == dates.getEndTime()) && (key.getStartTime() == dates.getStartTime())) {
                this.schedule.remove(dates);
                ex = false;
            }
        }
        if (ex) {
            throw new StaffNotFoundException("");
        }
    }

    public HashMap<Event, String> getSchedule() {
        return schedule;
    }

    /**
     * Get string represent of schedule
     *
     * @return String of appointment event names and time and date of events
     */
    public String getScheduleString() {
        if (schedule.isEmpty()) {
            return "You have no appointments";
        }
        StringBuilder s = new StringBuilder();
        for (Entry<Event, String> entry : schedule.entrySet()) {
            s.append("Start:\t");

            s.append(entry.getKey().getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E")));
            s.append("\t");

            s.append(entry.getKey().getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E")));
            s.append("\t");

            s.append("\tEvent:");
            s.append(entry.getValue());
            s.append("\n");
        }
        return s.toString();
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
