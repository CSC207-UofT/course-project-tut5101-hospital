package Schedule;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Event {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Event(LocalDateTime start_time, LocalDateTime end_time) {
        this.startTime = start_time;
        this.endTime = end_time;
    }

    public Event() {

    }

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
