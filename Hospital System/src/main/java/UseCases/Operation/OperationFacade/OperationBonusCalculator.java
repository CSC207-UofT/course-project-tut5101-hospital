package UseCases.Operation.OperationFacade;

import Entity.Operations.Operation;
import Entity.Staff.Doctor;

//a delegate class for OperationFacade, calculates bonus from completed operations for doctor
public class OperationBonusCalculator {
    /**
     * Operation bonus calculator
     */
    Doctor d;
    Operation op;

    /**
     * Constructor for Operation bonus calculator
     *
     */
    public OperationBonusCalculator(Doctor d, Operation op) {
        this.d = d;
        this.op = op;
    }

    /**
     * Doctor get bonus
     *
     * @return amount of bonus pay given to doctor
     */
    public double finish() {
        d.addBonus(.20 * op.getCost());
        return .20 * op.getCost();
    }
}
