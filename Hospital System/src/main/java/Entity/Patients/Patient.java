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
    private int fee;
    private Schedule scdl = new Schedule();
    private OperationList scdldOps = new OperationList();
    private OperationList fnshdOps = new OperationList();

//    add a variable for collection of previous appointments

    //    Constructs a patient class instant.
    public Patient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee) {
        this.name = name;
        this.gender = gender;
        this.contactNum = contactNum;
        this.healthCardNum = healthCardNum;
        this.pwd = pwd;
        this.fee = fee;
    }

    public String getPatientInfo() {
        return "Patient Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Contact Number: " + this.contactNum + "\n" +
                "Health Card Number: " + this.healthCardNum +
                "Money In Account: " + this.fee;
    }//add get healthcardid since we need to use healthcardnum as keys in patients database.

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

    public int getFee() {
        return fee;
    }

    public void addFee(int newFee) {
        fee += newFee;
    }

    public void payFee(int payFee) {
        fee -= payFee;
    }

}
