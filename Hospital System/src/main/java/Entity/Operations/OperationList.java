package Entity.Operations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OperationList implements Serializable {
    /**
     * List of operations
     */
    List<Operation> Operations = new ArrayList<>();

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
