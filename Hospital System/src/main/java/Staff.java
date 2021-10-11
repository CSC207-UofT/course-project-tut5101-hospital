/** This file contains the class Staff and is used to input the staff information
 *
 */

import java.util.*;

public class Staff {
    private String name;
    private String gender;
    private String role;
    private Integer ID;
    private ArrayList<String> StaffInfo;

    /**
     * Construct a Staff, giving them a name, gender, role and ID.
     *
     */
    public Staff(String name, String gender, String role) {

        this.name = name;
        this.gender = gender;
        this.role = role;
        this.StaffInfo = new ArrayList<>();
        StaffMap m = new StaffMap();
        this.ID = m.getAllStaffsize();
    }

    public void addtoStaffInfo() {
        StaffInfo.add(this.name);
        StaffInfo.add(this.gender);
        StaffInfo.add(this.role);
    }

}
