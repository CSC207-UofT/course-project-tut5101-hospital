/** This file contains the class Staff and is used to get the staff information
 *
 */

import java.util.*;

public class Staff {
    private String name;
    private String gender;
    private String role;
    private Integer ID;
    private HashMap<Integer,ArrayList<String>> AllStaff;

    /**
     * Construct a Staff, giving them a name, gender, role and ID.
     *
     */
    public Staff(String name, String gender, String role) {
        if (this.AllStaff == null) {
            this.AllStaff = new HashMap<Integer,ArrayList<String>>();
        }
        this.name = name;
        this.gender = gender;
        this.role = role;
        this.ID = AllStaff.size();
    }

    public void addtoAllStaff() {
        if (this.AllStaff == null) {
            this.AllStaff = new HashMap<Integer,ArrayList<String>>();
        }
        ArrayList<String> staffinfo = new ArrayList<>();
        staffinfo.add(this.name);
        staffinfo.add(this.gender);
        staffinfo.add(this.role);
        AllStaff.put(this.ID, staffinfo)
    }

}
