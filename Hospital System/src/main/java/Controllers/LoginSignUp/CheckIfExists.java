package Controllers.LoginSignUp;

import UseCases.Patient.PatientManager;
import UseCases.Patient.PatientManaging;
import UseCases.Staff.StaffManager;

public class CheckIfExists {
    /**
     * Constructor of check if exist controller,since this will not be used in upper level classes,
     * we do not have to implement Finish. This class acts like a library of methods for SignUp classes to use.
     *
     * @param hcn
     * @return
     */
    public boolean checkPatExists(int hcn) {
        PatientManaging patientManaging = new PatientManager();
        return patientManaging.checkIfPatientExist(hcn);
    }

    /**
     * Check if a staff exist giving an id of the staff.
     *
     * @param id
     * @return
     */
    public boolean checkStaffExists(int id) {
        return new StaffManager().checkIfStaffExist(id);
    }
}
