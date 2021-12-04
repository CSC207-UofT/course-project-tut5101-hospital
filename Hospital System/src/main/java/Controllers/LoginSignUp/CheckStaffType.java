package Controllers.LoginSignUp;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class CheckStaffType {
    public String checkType(int id) {
        StaffManaging sm = new StaffManager();
        return sm.getStaffType(id);
    }
}
