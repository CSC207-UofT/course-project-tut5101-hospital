package UseCases.Operation.OperationFacade;


import Entity.Operations.Operation;
import Entity.Patients.Patient;


public class OperationFeeCalculator {
    /**
     * calculates fee for patients
     */
    Patient p;
    Operation op;

    /**
     * Constructor for operation fee calculator
     *
     * @param p
     * @param op
     */
    public OperationFeeCalculator(Patient p, Operation op) {
        this.p = p;
        this.op = op;
    }

    /**
     * Finish
     *
     * @return
     */
    public double finish() {
        p.addFee(op.getCost());
        return op.getCost();
    }
}
