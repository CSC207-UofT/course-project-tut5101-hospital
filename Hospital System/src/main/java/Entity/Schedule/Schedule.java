package Entity.Schedule;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import Exceptions.InvalidInputException;
import Exceptions.StuffNotFoundException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Entity
public class Schedule implements java.io.Serializable {
    /**
     * Schedule entity
     */
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room")
    private String room;


    @ElementCollection
    @JoinColumn(name = "event")

    private HashMap<Event, String> schedule = new HashMap<Event, String>();


    /**
     * Add or modify event
     * @param event
     * @param dates
     * @throws InvalidInputException
     */
    public void add_or_modify_Event(String event, Event dates) throws InvalidInputException {
        if (!schedule.containsKey(dates)) {
            this.schedule.put(dates, event);
        } else {
            throw new InvalidInputException("");
        }
    }

    /**
     * Remove event
     * @param dates
     * @throws StuffNotFoundException
     */
    public void removeEvent(Event dates) throws StuffNotFoundException {
        boolean ex = true;
        for (Event key : schedule.keySet()) {
            if ((key.getEndTime() == dates.getEndTime()) && (key.getStartTime() == dates.getStartTime())) {
                this.schedule.remove(dates);
                ex = false;
            }
        }
        if (ex) {
            throw new StuffNotFoundException("");
        }
    }

    public HashMap<Event, String> getSchedule() {
        return schedule;
    }

    /**
     * Get string represent of schedule
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

