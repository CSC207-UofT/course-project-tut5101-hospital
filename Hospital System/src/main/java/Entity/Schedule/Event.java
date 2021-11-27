package Entity.Schedule;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Event {
    /**
     * Event entity class
     */
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    /**
     * Constructor for event
     * @param start_time
     * @param end_time
     */
    public Event(LocalDateTime start_time, LocalDateTime end_time) {
        this.startTime = start_time;
        this.endTime = end_time;
    }

    public Event() {

    }

    /**
     * Getter and setter
     * @return
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
