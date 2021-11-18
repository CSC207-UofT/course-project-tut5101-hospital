package UseCases;

import Entity.Operations.Operation;
import Entity.Operations.OperationList;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;

import java.util.List;

public class OperationManager {
OperationList scdl_ops;
OperationList fnsh_ops;
    public OperationManager(Patient p) {
        this.scdl_ops = p.getScdldOps();
        this.fnsh_ops = p.getFnshdOps();
    }
    public OperationManager(Doctor d){
        this.scdl_ops = d.getScdldOps();
        this.fnsh_ops = d.getFnshdOps();
    }

    public OperationList getScdldOps() {
        return scdl_ops;
    }

    public OperationList getfnshdOps() {
        return fnsh_ops;
    }

    public void scheduleNewOp(Operation op) {
        scdl_ops.addOperation(op);
    }

    public void finishOp(Operation op) {
        scdl_ops.removeOperation(op);
        fnsh_ops.addOperation(op);
    }
}
