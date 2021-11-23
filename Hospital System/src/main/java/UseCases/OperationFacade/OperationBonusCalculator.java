package UseCases.OperationFacade;

import Entity.Operations.Operation;
import Entity.Staff.Doctor;

//a delegate class for OperationFacade, calculates bonus from completed operations for doctor
public class OperationBonusCalculator {
    Doctor d;
    Operation op;

    public OperationBonusCalculator(Doctor d, Operation op) {
        this.d = d;
        this.op = op;
    }

    public double finish() {
        d.addBonus(.20 * op.getCost());
        return .20 * op.getCost();
    }
}
