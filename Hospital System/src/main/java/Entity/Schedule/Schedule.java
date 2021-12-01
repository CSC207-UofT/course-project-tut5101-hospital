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

    private String room;


    private final HashMap<Event, String> schedule = new HashMap<Event, String>();


    /**
     * Return schedule total Time In Minutes
     *
     * @return
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
    //private transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E");


    /**
     * Add or modify event
     *
     * @param event
     * @param dates
     * @throws InvalidInputException
     */
    public void addOrModifyEvent(String event, Event dates) throws InvalidInputException {
        if (!schedule.containsKey(dates)) {
            this.schedule.put(dates, event);
        } else {
            throw new InvalidInputException("");
        }
    }

    /**
     * Remove event
     *
     * @param dates
     * @throws StaffNotFoundException
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
     * @return
     */
    public String getScheduleString() {
        if (schedule == null || schedule.isEmpty()) {
            return "You have no appointments";
        }
        StringBuilder s = new StringBuilder();
        for (Entry<Event, String> entry : schedule.entrySet()) {
            s.append("Start-End:\t");

            s.append(entry.getKey().getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E")));
            s.append("\t");

            s.append("\tEvent:");
            s.append(entry.getValue());
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
