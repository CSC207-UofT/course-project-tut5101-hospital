package Controllers;

import UseCases.Patient.PatientManager;
import UseCases.Patient.PatientManaging;
import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;
//save session
public class SaveEveryThing {
    StaffManaging sm = StaffManager.getInstance();
    PatientManaging pm = PatientManager.getInstance();
    public void save(){
        sm.saveSession();
        pm.saveSession();
    }
}
