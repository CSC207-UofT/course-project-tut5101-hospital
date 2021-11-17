package Entity.Staff;
import Entity.Operations.Operations;
import Schedule.Schedule;

import java.util.ArrayList;
import java.util.List;

/** This file contains the class Entity.Staff.Doctor and is used to input the Entity.Staff.Doctor information
 *
 */

public class Doctor extends Staff {
    /**
     * Construct a Entity.Staff.Doctor, giving them a name, gender, ID and work schedule.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
    private List<Operations> scheduledOperations = new ArrayList<Operations>();
    private List<Operations> finishedOperations = new ArrayList<Operations>();

    public Doctor(String name, String gender, Integer id, Schedule workingTime, String pwd) {
        super(name, gender, id, workingTime, pwd, fixed_salary);
    }

    public void setScheduledOperations(List<Operations> scheduledOperations) {
        this.scheduledOperations = scheduledOperations;
    }

    public void setFinishedOperations(List<Operations> finishedOperations) {
        this.finishedOperations = finishedOperations;
    }

    public List<Operations> getFinishedOperations() {
        return finishedOperations;
    }

    public List<Operations> getScheduledOperations() {
        return scheduledOperations;
    }
}
