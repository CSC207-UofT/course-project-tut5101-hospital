package UseCases.Staff.Builders;

//build/initialize staff

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;

public abstract class StaffBuilder implements StaffBuilding {
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

    public void setId(Long id) {
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
