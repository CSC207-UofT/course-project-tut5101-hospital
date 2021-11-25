package Controllers.LoginSignUp;

import UseCases.Patient.PatientManager;
import UseCases.Patient.PatientManaging;
import UseCases.Staff.StaffManager;

//since this will not be used in upper level classes, we do not have to implement Finish. This class acts like a library of methods for SignUp classes to use.
public class CheckIfExists {
    public boolean checkPatExists(int hcn){
        PatientManaging pm = new  PatientManager();
        return pm.checkIfPateintExist(hcn);
    }public boolean checkStaffExists(int id){
        return new StaffManager().checkIfStaffExist(id);
    }
}
