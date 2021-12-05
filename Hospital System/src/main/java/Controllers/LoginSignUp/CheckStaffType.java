package Controllers.LoginSignUp;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class CheckStaffType {
    public String checkType(long id) {
        StaffManaging sm = new StaffManager();
        return sm.getStaffType(id);
    }
}
