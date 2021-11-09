package Schedule;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Event {
    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public Event(LocalDateTime start_time, LocalDateTime end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Event() {

    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }
}
