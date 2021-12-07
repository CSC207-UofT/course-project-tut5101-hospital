package UseCases.Operation.OperationFacade;


import Entity.Operations.Operation;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;

public class OperationFacade {
    /**
     * Operation Facada
     */
    Patient p;
    Doctor d;
    Operation op;
    OperationFeeCalculator opfc;
    OperationBonusCalculator opbc;
    OperationLogger opl;

    /**
     * Constructor for Operation Facada
     *
     */
    public OperationFacade(Patient p, Doctor d, Operation op) {
        this.p = p;
        this.d = d;
        this.opl = new OperationLogger(p, d, op);
        this.opbc = new OperationBonusCalculator(d, op);
        this.opfc = new OperationFeeCalculator(p, op);

    }

    /**
     * Finish operation
     */
    public void finishOperation() {
        opfc.finish();
        opbc.finish();
        opl.finishOperation();
    }

    /**
     * Schedule operation
     */
    public void scheduleOperation() {
        opl.scheduleOperation();
    }
}
