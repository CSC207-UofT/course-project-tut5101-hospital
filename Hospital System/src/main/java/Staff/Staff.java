package Staff;
import Schedule.Schedule;

/** This file contains the class Staff and is used to input the staff information
 *
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.*;

/**
 * This file contains the class Staff and is used to get the Staff information
 */
@Entity
public class Staff implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID")
    long id;
    @Column(name="name")
    private String name;
    @Column(name="gender")
    private String gender;
    @Column(name="id")
    private Integer ID;
    @Column(name="pwd")
    private String pwd;
    @Column(name="workingTime")
    private Schedule workingTime;
    @Transient
    @OneToOne
    @Column(name= "SCHEDULE")
    private Schedule scdl = new Schedule();

    public void setScdl(Schedule scdl) {
        this.scdl = scdl;
    }

    public Schedule getScdl() {
        return scdl;
    }
//    add a variable for collection of previous appointments

    /**
     * Construct a Staff, giving them a name, gender, worktime and ID.
     */
    public Staff(String name, String gender, Integer id, Schedule workingTime, String pwd) {

        this.name = name;
        this.gender = gender;
        this.ID = id;
        this.workingTime = workingTime;
        this.pwd = pwd;
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
