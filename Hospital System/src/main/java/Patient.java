/** This file contains the class Patient and is used to get the patient information
 *
 */

public class Patient {
    private String name;
    private String gender;
    private int contactNum;
    private int healthCardNum;
//    add a variable for collection of previous appointments

//    Constructs a patient class instant.
    public Patient(String name, String gender, int contactNum, int healthCardNum) {
        this.name = name;
        this.gender = gender;
        this.contactNum = contactNum;
        this.healthCardNum = healthCardNum;
    }

    public String getPatientInfo() {
        return "Patient Name: " + this.name + "\n" +
                "Gender: " + this.gender + "\n" +
                "Contact Number: " + this.contactNum + "\n" +
                "Health Card Number: " + this.healthCardNum;
    }

}
