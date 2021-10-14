package Staff;
import Schedule.Schedule;

/** This file contains the class Staff.Doctor and is used to input the Staff.Doctor information
 *
 */

import java.util.*;

class Doctor extends Staff {
    /**
     * Construct a Staff.Doctor, giving them a name, gender, ID and work schedule.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
    public Doctor(String name, String gender, Integer id, Schedule workingTime, String pwd) {
        super(name, gender, id, workingTime, pwd);
    }

}
