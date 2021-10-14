package Staff;

import Schedule.Schedule;

/** This file contains the class Staff and is used to input the staff information
 *
 */

import java.util.*;

public class Staff implements java.io.Serializable{
    private String name;
    private String gender;
    private Integer ID;
    private String pwd;
    private Schedule workingTime;

    /**
     * Construct a Staff, giving them a name, gender, worktime and ID.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
    public Staff(String name, String gender, Integer id, Schedule workingTime, String pwd) {

        this.name = name;
        this.gender = gender;
        this.ID = id;
        this.workingTime = workingTime;
        this.pwd=pwd;


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
