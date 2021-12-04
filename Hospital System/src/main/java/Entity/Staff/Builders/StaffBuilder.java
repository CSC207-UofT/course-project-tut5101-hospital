package Entity.Staff.Builders;

//build/initialize staff

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;

public class StaffBuilder implements java.io.Serializable {
    /**
     * Staff builder for staff.
     */
    Staff s;

    /**
     * Constructor for staff builder
     */
    public StaffBuilder() {
        this.s = new Staff();
    }

    public void setName(String name) {
        s.setName(name);
    }

    public void setId(int id) {
        s.setID(id);
    }

    public void setGender(String g) {
        s.setGender(g);
    }

    public void setSalary(double sl) {
        s.setSalary(sl);
    }

    public void setPwd(String pwd) {
        s.setPwd(pwd);
    }

    public void setWorkingTime(Schedule scd) {
        s.setWorkingTime(scd);
    }

    public Staff getResult() {
        return s;
    }
}
