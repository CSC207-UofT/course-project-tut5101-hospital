package Entity.Staff;

import Schedule.Schedule;


/*
This class contains the information for other staffs.
e.g. Cleaning staff, Management, Security...
 */

public class OtherStaff extends Staff {
    private String role;

    /**
     * Construct a Entity.Staff that is not a doctor or nurse, giving them a name, gender, role, ID, and working time.
     */
    public OtherStaff(String name, String gender, Integer id, Schedule workingTime, String pwd, int fixed_salary, String role) {
        super(name, gender, id, workingTime, pwd, fixed_salary);
        this.role = role;
    }

    //This method gets the role of the OtherStaff
    public String getrole() {
        return this.role;
    }

}
