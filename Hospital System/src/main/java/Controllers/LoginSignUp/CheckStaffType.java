package Controllers.LoginSignUp;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class CheckStaffType {
    /**
     * Check and return the staff type
     * @param id staff id
     * @return string for staff type
     */
    public String checkType(long id) {
        StaffManaging sm = new StaffManager();
        return sm.getStaffType(id);
    }
}
