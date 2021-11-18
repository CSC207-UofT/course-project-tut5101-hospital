package Controllers.OperationFacade;

import Entity.Patients.Patient;
import Entity.Staff.Doctor;

public class OperationFacade {
    Patient p;
    Doctor d;
    public OperationFacade(Patient p, Doctor d){
        this.p=p;
        this.d = d;
    }
}
