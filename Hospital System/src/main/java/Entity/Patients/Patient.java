package Entity.Patients;

import Entity.Operations.OperationList;
import Entity.Schedule.Schedule;

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
    public Patient() {

    }

    public String getPatientInfo() {
        return "Patient Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Contact Number: " + this.contactNum + "\n" +
                "Health Card Number: " + this.healthCardNum;
    }//add get healthcardid since we need to use healthcardnum as keys in patients database.

    //getter setters
    public int getHealthCardNum() {
        return this.healthCardNum;
    }

    public boolean checkPwd(String iptPwd) {
        return pwd.equals(iptPwd);
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

    public void addFee(int newFee) {
        fee += newFee;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setGender(String n) {
        this.gender = n;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    public void setHealthCardNum(int healthCardNum) {
        this.healthCardNum = healthCardNum;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
