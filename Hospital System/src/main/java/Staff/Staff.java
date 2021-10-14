package Staff;
/** This file contains the class Staff and is used to input the staff information
 *
 */

import java.util.*;

public class Staff {
    private String name;
    private String gender;
    private Integer ID;
<<<<<<< HEAD:Hospital System/src/main/java/Staff/Staff.java
    private ArrayList<String> StaffInfo;
    private String pwd;
=======
    private Schedule workingTime;
>>>>>>> e74133a0ea737862c05c03273e1bc9eb0e2e0feb:Hospital System/src/main/java/Staff.java

    /**
     * Construct a Staff, giving them a name, gender and ID.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
<<<<<<< HEAD:Hospital System/src/main/java/Staff/Staff.java
    public Staff(String name, String gender,  String pwd) {

        this.name = name;
        this.gender = gender;
        this.StaffInfo = new ArrayList<>();
        StaffData m = new StaffData();
        this.ID = m.getStaffDatasize();
        this.pwd=pwd;
=======
    public Staff(String name, String gender, Integer id, Schedule workingTime) {

        this.name = name;
        this.gender = gender;
        this.ID = id;
        this.workingTime = workingTime;
>>>>>>> e74133a0ea737862c05c03273e1bc9eb0e2e0feb:Hospital System/src/main/java/Staff.java
    }


    //This method get the information of the Staff in a string
    public String getStaffInfo() {
        return "Staff Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "ID Number: " + this.ID.toString();
    }


    //This method gets the name of the ID of Staff
    public Integer getStaffID() {
        return this.ID;
    }public Boolean checkPwd(String ipt_pwd){
        return this.pwd==ipt_pwd;
    }

}
