/** This file contains the class Doctor and is used to input the Nurse information
 *
 */

import java.util.*;

public class Nurse extends Staff {
    private String name;
    private String gender;
    private Integer ID;
    private Schedule workingTime;
    private ArrayList<Patient> patients;

    /**
     * Construct a Nurse, giving them a name, gender, ID and work schedule.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
    public Nurse(String name, String gender, Integer id, Schedule workingTime, ArrayList<Patient> patients) {
        super(name, gender, id, workingTime);
        this.patients = patients;
    }

}
