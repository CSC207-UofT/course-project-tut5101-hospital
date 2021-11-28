package Entity.Operations;

import java.util.ArrayList;
import java.util.List;

public class OperationList {
    /**
     * List of operations
     */
    List<Operation> Operations = new ArrayList<Operation>();

    /**
     * Remove an operation
     *
     * @param op an operation
     */
    public void removeOperation(Operation op) {
        Operations.remove(op);
    }

    /**
     * Add an operation
     *
     * @param op an operation
     */
    public void addOperation(Operation op) {
        Operations.add(op);
    }


    public List<Operation> getOperations() {
        return Operations;
    }

    public void setOperations(List<Operation> operations) {
        Operations = operations;
    }
}
