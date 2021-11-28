package UseCases.Operation;

import Entity.Operations.Operation;
import Entity.Operations.OperationList;
import Entity.Patients.Patient;
import Entity.Staff.Doctor;
import Entity.Staff.Staff;

import java.util.List;

public class OperationManager {
    /**
     * Operation Manager use case
     */
    OperationList scdlOps;
    OperationList fnshOps;


    /**
     * Constructor for operation Manager, reads in a patient or a doctor and manage scheduled and finished operations
     * @param p 
     */
    public OperationManager(Patient p) {
        this.scdlOps = p.getScdldOps();
        this.fnshOps = p.getFnshdOps();
    }

    /**
     * Constructor for operation Manager, reads in a patient or a doctor and manage scheduled and finished operations
     * @param d
     */
    public OperationManager(Doctor d) {
        this.scdlOps = d.getScdldOps();
        this.fnshOps = d.getFnshdOps();
    }

    /**
     * Schedule new operation
     * @param op
     */
    public void scheduleNewOp(Operation op) {
        scdlOps.addOperation(op);
    }

    /**
     * Finish operation
     * @param op
     */
    public void finishOp(Operation op) {
        scdlOps.removeOperation(op);
        fnshOps.addOperation(op);
    }

    /**
     * Return the total cost of finished operations.
     * @return
     */
    public int totalCostOfFinishedOps(){
        List<Operation> Operations = fnshOps.getOperations();
        int totalCost = 0;
        for (Operation operation: Operations){
            totalCost = totalCost + operation.getCost();

        }
        return totalCost;
    }

    //Getters
    public OperationList getScdldOps() {
        return scdlOps;
    }

    public OperationList getfnshdOps() {
        return fnshOps;
    }


}
