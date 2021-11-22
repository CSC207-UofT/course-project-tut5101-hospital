package UseCases.OperationFacade;

import Entity.Operations.Operation;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;
import UseCases.OperationManager;

//keep track of operations
public class OperationLogger {

    OperationManager p_opm;
    OperationManager d_opm;
    Operation op;

    public OperationLogger(Patient p, Doctor d, Operation op) {
        this.p_opm = new OperationManager(p);
        this.p_opm = new OperationManager(p);
        this.op = op;
    }

    // calls operation manager to manage the operation lists
    public void finishOperation() {
        p_opm.finishOp(op);
        d_opm.finishOp(op);
    }

    public void scheduleOperation() {
        p_opm.scheduleNewOp(op);
        d_opm.scheduleNewOp(op);
    }
}
