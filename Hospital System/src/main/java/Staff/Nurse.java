package Staff;
import Schedule.Schedule;
import Patients.Patient;

/** This file contains the class Staff.Nurse and is used to input the Staff.Nurse information
 *
 */

import java.util.*;

public class Nurse extends Staff {
    private ArrayList<Patient> patients;

    /**
     * Construct a Staff.Nurse, giving them a name, gender, ID and work schedule.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
    public Nurse(String name, String gender, Integer id, Schedule workingTime, String pwd, ArrayList<Patient> patients) {
        super(name, gender, id, workingTime, pwd);
        this.patients = patients;
    }

}
