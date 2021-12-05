package Entity.Operations;

import java.time.LocalDateTime;
import java.util.List;

public class Operation implements java.io.Serializable {
    /**
     * Entity for operation
     */
    private int cost;
    private String name;
    private String description;
    private final List<LocalDateTime> time;

    /**
     * Constructor for operation
     *
     * @param cost        cost of operation
     * @param name        name of operation
     * @param description description of operation
     * @param time        time of operation
     */
    public Operation(int cost, String name, String description, List<LocalDateTime> time) {
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.time = time;
    }

    //Getters and Setters
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
