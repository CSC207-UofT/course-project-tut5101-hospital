package Entity.Staff;

import Entity.Schedule.Schedule;
import Entity.Patients.Patient;

/** This file contains the class Entity.Staff.Nurse and is used to input the Entity.Staff.Nurse information
 *
 */

import java.util.*;

public class Nurse extends Staff {
    private ArrayList<Patient> patients;

    /**
     * Construct a Entity.Staff.Nurse, giving them a name, gender, ID and work schedule.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
    public Nurse(String name, String gender, Integer id, Schedule workingTime, String pwd, int fixedSalary, ArrayList<Patient> patients) {
        super(name, gender, id, workingTime, pwd, fixedSalary);
        this.patients = patients;
    }

}
