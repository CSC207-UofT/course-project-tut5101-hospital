package Staff;
/** This file contains the class Staff and is used to input the staff information
 *
 */

import java.util.*;

public class Staff {
    private String name;
    private String gender;
    private Integer ID;
    private ArrayList<String> StaffInfo;
    private String pwd;

    /**
     * Construct a Staff, giving them a name, gender, role and ID.
     *
     */
    public Staff(String name, String gender,  String pwd) {

        this.name = name;
        this.gender = gender;
        this.StaffInfo = new ArrayList<>();
        StaffData m = new StaffData();
        this.ID = m.getStaffDatasize();
        this.pwd=pwd;
    }

    public void addtoStaffInfo() {
        StaffInfo.add(this.name);
        StaffInfo.add(this.gender);
    }

    public String getStaffInfo() {
        return "Staff Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "ID Number: " + this.ID.toString();
    }

    public Integer getStaffID() {
        return this.ID;
    }public Boolean checkPwd(String ipt_pwd){
        return this.pwd==ipt_pwd;
    }

}
