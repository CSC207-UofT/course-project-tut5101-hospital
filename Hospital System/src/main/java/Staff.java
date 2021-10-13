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
        StaffData m = new StaffData();
        this.ID = m.getStaffDatasize();
    }

    public void addtoStaffInfo() {
        StaffInfo.add(this.name);
        StaffInfo.add(this.gender);
        StaffInfo.add(this.role);
    }

    public String getStaffInfo() {
        return "Staff Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Staff role: " + this.role + "\n" +
                "ID Number: " + this.ID.toString();
    }

    public Integer getStaffID() {
        return this.ID;
    }

}
