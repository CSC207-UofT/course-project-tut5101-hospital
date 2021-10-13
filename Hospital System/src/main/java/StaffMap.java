/** This file contains a hashmap containing all the Staff and is used to get the staff information
 *
 */

import java.util.*;

public class StaffMap {
    HashMap<Integer,ArrayList<String>> AllStaff;

    public StaffMap() {
        AllStaff = new HashMap<>();
    }

    public boolean addStaff(Integer ID, ArrayList<String> StaffInfo) {
        if (AllStaff.get(ID) == null) {
            AllStaff.put(ID, StaffInfo);
            return true;
        }
        return false;
    }

    public int getAllStaffsize() {
        return AllStaff.size();
    }
    
}
