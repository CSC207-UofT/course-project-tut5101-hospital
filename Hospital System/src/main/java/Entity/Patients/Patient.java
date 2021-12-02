package Entity.Patients;

import Entity.Operations.OperationList;
import Entity.PatientRecords.PatientRecordList;
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
    private final OperationList scdldOps = new OperationList();
    private final OperationList fnshdOps = new OperationList();
    private int fee;
    private final PatientRecordList PRL = new PatientRecordList();

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

    public Patient() {

    }

    /**
     * Return a string of patient information
     *
     */
    public String getPatientInfo() {
        return "Patient Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Contact Number: " + this.contactNum + "\n" +
                "Health Card Number: " + this.healthCardNum +
                "Money In Account: " + this.fee;
    }

    /**
     * Check password correct or not
     *
     * @param iptPwd
     */
    public boolean checkPwd(String iptPwd) {
        return pwd.equals(iptPwd);
    }

    /**
     * Getters and setters
     *
     */
    public int getHealthCardNum() {
        return this.healthCardNum;
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

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void addFee(int newFee) {
        fee += newFee;
    }

    public void payFee(int payFee) {
        fee -= payFee;
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

    public PatientRecordList getPRL() {
        return PRL;
    }
}
