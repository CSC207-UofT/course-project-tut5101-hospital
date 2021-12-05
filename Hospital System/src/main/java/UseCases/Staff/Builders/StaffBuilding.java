package UseCases.Staff.Builders;

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;

public interface StaffBuilding {


    void setName(String name);

    void setId(Long id);

    void setGender(String g);

    void setSalary(double sl);

    void setPwd(String pwd);

    void setWorkingTime(Schedule scd);

    Staff getResult();
}
