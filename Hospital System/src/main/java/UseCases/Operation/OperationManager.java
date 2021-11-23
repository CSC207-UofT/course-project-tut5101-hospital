package UseCases.Operation;

import Entity.Operations.Operation;
import Entity.Operations.OperationList;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;

public class OperationManager {
    OperationList scdlOps;
    OperationList fnshOps;

    //reads in a patient or a doctor and manage scheduled and finished operations
    public OperationManager(Patient p) {
        this.scdlOps = p.getScdldOps();
        this.fnshOps = p.getFnshdOps();
    }

    public OperationManager(Doctor d) {
        this.scdlOps = d.getScdldOps();
        this.fnshOps = d.getFnshdOps();
    }

    public OperationList getScdldOps() {
        return scdlOps;
    }

    public OperationList getfnshdOps() {
        return fnshOps;
    }

    public void scheduleNewOp(Operation op) {
        scdlOps.addOperation(op);
    }

    public void finishOp(Operation op) {
        scdlOps.removeOperation(op);
        fnshOps.addOperation(op);
    }
}
