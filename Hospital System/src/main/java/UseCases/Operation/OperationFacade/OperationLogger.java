package UseCases.Operation.OperationFacade;


import Entity.Operations.Operation;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;
import UseCases.Operation.OperationManager;


public class OperationLogger {

    /**
     * Operation logger that keep track of operations
     */
    OperationManager pOpm;
    OperationManager dOpm;
    Operation op;

    /**
     * Constructor for operation logger
     * @param p
     * @param d
     * @param op
     */
    public OperationLogger(Patient p, Doctor d, Operation op) {
        this.pOpm = new OperationManager(p);
        this.pOpm = new OperationManager(p);
        this.op = op;
    }

    /**
     * calls operation manager to manage the operation lists
     */
    public void finishOperation() {
        pOpm.finishOp(op);
        dOpm.finishOp(op);
    }

    /**
     * Schedule operation
     */
    public void scheduleOperation() {
        pOpm.scheduleNewOp(op);
        dOpm.scheduleNewOp(op);
    }
}
