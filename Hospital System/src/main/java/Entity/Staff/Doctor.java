package Entity.Staff;

import Entity.Operations.OperationList;

/**
 * This file contains the class Entity.Staff.Doctor and is used to input the Entity.Staff.Doctor information
 */

public class Doctor extends Staff implements java.io.Serializable {
    /**
     * Doctor Entity
     */
    private OperationList scdldOps = new OperationList();
    private final OperationList fnshdOps = new OperationList();

    public void setOp(OperationList scdldOps){
        this.scdldOps = scdldOps;
    }

    public OperationList getFnshdOps() {
        return fnshdOps;
    }

    public OperationList getScdldOps() {
        return scdldOps;
    }


}
