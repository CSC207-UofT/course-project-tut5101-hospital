package Patients;

import Schedule.Schedule;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.*;

/**
 * This file contains the class Patient and is used to get the patient information
 */
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID")
    long id;
    @Column(name="name")
    private String name;
    @Column(name="gender")
    private String gender;
    @Column(name="ctctn")
    private int contactNum;
    @Column(name="hcn")
    private int healthCardNum;
    @Column(name="pwd")
    private String pwd;
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

    //    Constructs a patient class instant.
    public Patient(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        this.name = name;
        this.gender = gender;
        this.contactNum = contactNum;
        this.healthCardNum = healthCardNum;
        this.pwd = pwd;
    }

    public Patient() {

    }



    @Id
    public int getHealthCardNum() {
        return this.healthCardNum;
    }

    public boolean checkPwd(String ipt_pwd) {
        return pwd.equals(ipt_pwd);
    }

    public Schedule getSchedule() {
        return scdl;
    }

    public void setSchedule(Schedule s) {
        this.scdl = s;
    }

    public void setHealthCardNum(int healthCardNum) {
        this.healthCardNum = healthCardNum;
    }


    public String printPatientInfo() {
        return "Patient Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Contact Number: " + this.contactNum + "\n" +
                "Health Card Number: " + this.healthCardNum;
    }//add get healthcardid since we need to use healthcardnum as keys in patients database.
}
