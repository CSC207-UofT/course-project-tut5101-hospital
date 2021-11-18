package Controllers.OperationFacade;

import Entity.Patients.Patient;
import Entity.Staff.Doctor;

public class OperationLogger {
    Patient p;
    Doctor d;
    public OperationLogger(Patient p, Doctor d){
        this.p=p;
        this.d = d;
    }
}
