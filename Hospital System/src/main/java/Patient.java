/** This file contains the class Patient and is used to get the patient information
 *
 */

public class Patient {
    private String name;
    private String gender;
    private int contactNum;
    private int healthCardNum;
    private int pwd;
//    add a variable for collection of previous appointments

//    Constructs a patient class instant.
    public Patient(String name, String gender, int contactNum, int healthCardNum, int pwd) {
        this.name = name;
        this.gender = gender;
        this.contactNum = contactNum;
        this.healthCardNum = healthCardNum;
        this.pwd=pwd;
    }

    public String getPatientInfo() {
        return "Patient Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Contact Number: " + this.contactNum + "\n" +
                "Health Card Number: " + this.healthCardNum;
    }//add get healthcardid since we need to use healthcardnum as keys in patients database.
    public int getHealthCardNum() {
        return this.healthCardNum;
    }public boolean checkPwd(int ipt_pwd) {
        return this.pwd==ipt_pwd;
    }
}
