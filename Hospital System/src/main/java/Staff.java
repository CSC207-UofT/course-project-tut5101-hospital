/** This file contains the class Staff and is used to get the staff information
 *
 */

import java.util.*;

public class Staff {
    private String name;
    private String gender;
    private String role;
    private String ID;

    /**
     * Construct a Staff, giving them a name, gender, role and ID.
     *
     */
    public Staff(String name, String gender, String role) {
        this.name = name;
        this.gender = gender;
        this.role = role;

        Random randomizer = new Random();
        Integer id = randomizer.nextInt(1000000)
        this.ID = id.toString() ;
    }

    public void addtosystem() {

    }

}
