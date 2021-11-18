package Controllers.OperationFacade;

import Entity.Patients.Patient;
import Entity.Staff.Doctor;

public class OperationCalculator {
    Patient p;
    Doctor d;
    public OperationCalculator(Patient p, Doctor d){
        this.p=p;
        this.d = d;
    }
}
