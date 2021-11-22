package UseCases.OperationFacade;

import Entity.Operations.Operation;
import Entity.Patients.Patient;

//calculates fee for patients
public class OperationFeeCalculator {
    Patient p;
    Operation op;

    public OperationFeeCalculator(Patient p, Operation op) {
        this.p = p;
        this.op = op;
    }

    public double finish() {
        p.addFee(op.getCost());
        return op.getCost();
    }
}
