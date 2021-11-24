package Entity.Staff;

//build/initialize staff

import Entity.Schedule.Schedule;

public class StaffBuilder {
    Staff s;

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
