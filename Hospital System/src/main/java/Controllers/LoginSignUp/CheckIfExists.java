package Controllers.LoginSignUp;

import UseCases.Patient.PatientManager;
import UseCases.Patient.PatientManaging;
import UseCases.Staff.StaffManager;

public class CheckIfExists {
    /**
     * Constructor of check if exist controller,since this will not be used in upper level classes,
     * we do not have to implement Finish. This class acts like a library of methods for SignUp classes to use.
     *
     */
    public boolean checkPatExists(Long hcn) {
        PatientManaging patientManaging =PatientManager.getInstance();
        return patientManaging.checkIfPatientExist(hcn);
    }

    /**
     * Check if a staff exist giving an id of the staff.
     *
     */
    public boolean checkStaffExists(Long id) {
        return StaffManager.getInstance().checkIfStaffExist(id);
    }
}
