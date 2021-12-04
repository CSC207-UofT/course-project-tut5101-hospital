package Entity.Staff;

import Entity.Schedule.Schedule;


import java.io.Serializable;
import java.util.Objects;

/**
 * This file contains the class Entity.Staff and is used to get the Entity.Staff information
 */

public class Staff implements Serializable {
    /**
     * Staff entity
     */
    private String name;
    private String gender;
    private Long ID;
    private String pwd;
    private Schedule workingTime;
    private Schedule scdl = new Schedule();
    private double salary;

    public Staff() {

    }

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


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getPwd() {
        return pwd;
    }

    public Schedule getWorkingTime() {
        return workingTime;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setWorkingTime(Schedule workingTime) {
        this.workingTime = workingTime;
    }

    //This method get the information of the Entity.Staff in a string
    public String getStaffInfo() {
        return "Entity.Staff Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "ID Number: " + this.ID.toString();
    }


    //This method gets the name of the ID of Entity.Staff
    public long getStaffID() {
        return this.ID;
    }


    //This method checks to ensure the entered password is the same as the set password
    public Boolean checkPwd(String iptPwd) {
        return Objects.equals(this.pwd, iptPwd);
    }

    public Schedule getSchedule() {
        return scdl;
    }

    public void setSchedule(Schedule s) {
        this.scdl = s;
    }

    public void addBonus(double bonus) {
        salary += bonus;
    }


}
