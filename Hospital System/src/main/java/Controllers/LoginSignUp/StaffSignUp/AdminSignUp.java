package Controllers.LoginSignUp.StaffSignUp;
// Avoid Clean Ar

import Entity.Schedule.Schedule;
import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;


public class AdminSignUp implements StaffSignUp {
    /**
     * Controller to sign up admin
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
        sm.addAdmin(name, gender, ID, workingTime, password, fixedSalary);
    }
}
