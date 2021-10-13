/** This file contains the class Doctor and is used to input the Doctor information
 *
 */

import java.util.*;

public class Doctor extends Staff {
    private String name;
    private String gender;
    private Integer ID;
    private Schedule workingTime;

    /**
     * Construct a Doctor, giving them a name, gender, ID and work schedule.
     *
     * @param name
     * @param gender
     * @param workingTime
     */
    public Doctor(String name, String gender, Schedule workingTime) {
        super(name, gender, workingTime);
        StaffData m = new StaffData();
        this.ID = m.getStaffDatasize();
    }

}
