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
     * @param op
     */
    public void removeOperation(Operation op) {
        Operations.remove(op);
    }

    /**
     * Add an operation
     *
     * @param op
     */
    public void addOperation(Operation op) {
        Operations.add(op);
    }
}
