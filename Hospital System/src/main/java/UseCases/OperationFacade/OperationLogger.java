package UseCases.OperationFacade;

import Entity.Operations.Operation;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;
import UseCases.OperationManager;

//keep track of operations
public class OperationLogger {

    OperationManager pOpm;
    OperationManager dOpm;
    Operation op;

    public OperationLogger(Patient p, Doctor d, Operation op) {
        this.pOpm = new OperationManager(p);
        this.pOpm = new OperationManager(p);
        this.op = op;
    }

    // calls operation manager to manage the operation lists
    public void finishOperation() {
        pOpm.finishOp(op);
        dOpm.finishOp(op);
    }

    public void scheduleOperation() {
        pOpm.scheduleNewOp(op);
        dOpm.scheduleNewOp(op);
    }
}
