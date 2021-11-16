package Entity.Staff;
import Schedule.Schedule;

/** This file contains the class Entity.Staff and is used to input the staff information
 *
 */

import java.io.Serializable;

/**
 * This file contains the class Entity.Staff and is used to get the Entity.Staff information
 */

public class Staff implements Serializable {
    private String name;
    private String gender;
    private Integer ID;
    private String pwd;
    private Schedule workingTime;
    private Schedule scdl = new Schedule();
    private int fixed_salary;

    public void setScdl(Schedule scdl) {
        this.scdl = scdl;
    }

    public Schedule getScdl() {
        return scdl;
    }
//    add a variable for collection of previous appointments

    /**
     * Construct a Entity.Staff, giving them a name, gender, worktime and ID.
     */
    public Staff(String name, String gender, Integer id, Schedule workingTime, String pwd) {

        this.name = name;
        this.gender = gender;
        this.ID = id;
        this.workingTime = workingTime;
        this.pwd = pwd;
    }
    //This method get the information of the Entity.Staff in a string
    public String getStaffInfo() {
        return "Entity.Staff Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "ID Number: " + this.ID.toString();
    }


    //This method gets the name of the ID of Entity.Staff
    public Integer getStaffID() {
        return this.ID;
    }


    //This method checks to ensure the entered password is the same as the set password
    public Boolean checkPwd(String ipt_pwd){
        return this.pwd==ipt_pwd;
    }

    public Schedule getSchedule() {
        return scdl;
    }

    public void setSchedule(Schedule s) {
        this.scdl = s;
    }

}
