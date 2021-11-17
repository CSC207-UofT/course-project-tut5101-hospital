package Entity.Operations;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Operations {
    private int cost;
    private String name;
    private String description;
    private final List<LocalDateTime> time;

    public Operations( List<LocalDateTime> time) {
        this.time=time;
    }

    public int getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<LocalDateTime> getTime() {
        return time;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
