package Entity.Patients;

import Entity.Operations.Operation;
import Entity.Operations.OperationList;
import Schedule.Schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * This file contains the class Patient and is used to get the patient information
 */

public class Patient implements java.io.Serializable {
    private String name;
    private String gender;
    private int contactNum;
    private int healthCardNum;
    private String pwd;
    private Schedule scdl = new Schedule();
    private OperationList scdldOps = new OperationList();
    private OperationList fnshdOps = new OperationList();
    private int fee;

//    add a variable for collection of previous appointments

    //    Constructs a patient class instant.
    public Patient(String name, String gender, int contactNum, int healthCardNum, String pwd) {
        this.name = name;
        this.gender = gender;
        this.contactNum = contactNum;
        this.healthCardNum = healthCardNum;
        this.pwd = pwd;
    }

    public String getPatientInfo() {
        return "Patient Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Contact Number: " + this.contactNum + "\n" +
                "Health Card Number: " + this.healthCardNum;
    }//add get healthcardid since we need to use healthcardnum as keys in patients database.

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

    public OperationList getFnshdOps() {
        return fnshdOps;
    }

    public OperationList getScdldOps() {
        return scdldOps;
    }

    public void addFee(int new_fee) {
        fee += new_fee;
    }

}
