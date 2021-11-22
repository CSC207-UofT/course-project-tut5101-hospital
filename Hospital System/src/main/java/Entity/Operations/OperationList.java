package Entity.Operations;

import java.util.ArrayList;
import java.util.List;

public class OperationList {
    List<Operation> Operations = new ArrayList<Operation>();
    public void removeOperation(Operation op){
        Operations.remove(op);
    }public void addOperation(Operation op){
        Operations.add(op);
    }
}
