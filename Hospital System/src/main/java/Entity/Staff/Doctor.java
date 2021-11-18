package Entity.Staff;
import Entity.Operations.OperationList;
import Schedule.Schedule;

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
    private OperationList scdldOps = new OperationList();
    private OperationList fnshdOps = new OperationList();

    public Doctor(String name, String gender, Integer id, Schedule workingTime, String pwd, int fixed_salary) {
        super(name, gender, id, workingTime, pwd, fixed_salary);
    }


    public OperationList getFnshdOps() {
        return fnshdOps;
    }

    public OperationList getScdldOps() {
        return scdldOps;
    }
}
