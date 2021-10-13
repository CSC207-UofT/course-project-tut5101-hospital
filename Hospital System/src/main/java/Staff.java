/** This file contains the class Staff and is used to input the staff information
 *
 */

import java.util.*;

public class Staff {
    private String name;
    private String gender;
    private Integer ID;
    private Schedule workingTime;

    /**
     * Construct a Staff, giving them a name, gender and ID.
     *
     * @param name
     * @param gender
     * @param workingTime
     */
    public Staff(String name, String gender, Schedule workingTime) {

        this.name = name;
        this.gender = gender;
        StaffData m = new StaffData();  // used to generate an ID
        this.ID = m.getStaffDatasize();
        this.workingTime = workingTime;
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

}
