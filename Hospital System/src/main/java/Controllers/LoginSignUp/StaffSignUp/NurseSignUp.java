package Controllers.LoginSignUp.StaffSignUp;
// Avoid Clean Ar

import Entity.Schedule.Schedule;
import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class NurseSignUp implements StaffSignUp {

    /**
     * Controller to sign up doctor
     * @param name name
     * @param gender gender
     * @param ID id
     * @param workingTime working time
     * @param password password
     * @param fixedSalary fixed salary
     */
    @Override
    public void signUp(String name, String gender, long ID, Schedule workingTime, String password, int fixedSalary) {
        StaffManaging sm = new StaffManager();
        sm.addNurse(name, gender, ID, workingTime, password, fixedSalary);
    }
}
