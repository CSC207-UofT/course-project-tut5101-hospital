package Entity.Staff;

import Entity.Operations.OperationList;
import Entity.Schedule.Schedule;

/**
 * This file contains the class Entity.Staff.Doctor and is used to input the Entity.Staff.Doctor information
 */

public class Doctor extends Staff {
    /**
     * Doctor Entity
     */
    private OperationList scdldOps = new OperationList();
    private OperationList fnshdOps = new OperationList();

    public OperationList getFnshdOps() {
        return fnshdOps;
    }

    public OperationList getScdldOps() {
        return scdldOps;
    }
}
