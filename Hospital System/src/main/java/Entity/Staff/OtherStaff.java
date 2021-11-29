package Entity.Staff;

import Entity.Patients.Patient;
import Entity.Schedule.Schedule;

import java.util.ArrayList;


/*
This class contains the information for other staffs.
e.g. Cleaning staff, Management, Security...
 */

public class OtherStaff extends Staff {
    private String role;

    /**
     * Construct a Entity.Staff that is not a doctor or nurse, giving them a name, gender, role, ID, and working time.
     */
    public OtherStaff(){}

    //This method sets the role of the OtherStaff
    public void setRole(String role) {
        this.role = role;
    }

    //This method gets the role of the OtherStaff
    public String getRole() {
        return this.role;
    }

}
