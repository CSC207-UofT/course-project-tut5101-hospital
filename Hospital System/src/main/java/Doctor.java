/** This file contains the class Doctor and is used to input the Doctor information
 *
 */

import java.util.*;

class Doctor extends Staff {

    /**
     * Construct a Doctor, giving them a name, gender, ID and work schedule.
     *
     * @param name
     * @param gender
     * @param id
     * @param workingTime
     */
    public Doctor(String name, String gender, Integer id, Schedule workingTime) {
        super(name, gender, id, workingTime);
    }

}
