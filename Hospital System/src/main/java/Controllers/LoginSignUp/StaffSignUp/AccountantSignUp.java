package Controllers.LoginSignUp.StaffSignUp;

import Entity.Schedule.Schedule;
import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class AccountantSignUp implements StaffSignUp {

    @Override
    public void signUp(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary) {
        StaffManaging sm = new StaffManager();
        sm.addAccountant(name, gender, ID, workingTime, pwd, fixedSalary);
    }

}
