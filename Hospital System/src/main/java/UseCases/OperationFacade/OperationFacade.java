package UseCases.OperationFacade;

import Entity.Operations.Operation;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;

public class OperationFacade {
    Patient p;
    Doctor d;
    Operation op;
    OperationFeeCalculator opfc;
    OperationBonusCalculator opbc;
    OperationLogger opl;

    public OperationFacade(Patient p, Doctor d, Operation op) {
        this.p = p;
        this.d = d;
        this.opl = new OperationLogger(p, d, op);
        this.opbc = new OperationBonusCalculator(d, op);
        this.opfc = new OperationFeeCalculator(p, op);

    }

    public void finishOperation() {
        opfc.finish();
        opbc.finish();
        opl.finishOperation();
    }

    public void scheduleOperation() {
        opl.scheduleOperation();
    }
}
