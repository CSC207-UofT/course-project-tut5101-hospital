package Presenters.Schedule;

import Presenters.Printable;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;


public class ViewOtherStaffSchedules implements Printable {
    StaffManager sm = new StaffManager();
    ScheduleManager scm;
    String str;

    @Override
    public String print() {
        for (int id : sm.getAllOtherId()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += (sm.getStaffInfo(id) + "\t" + scm.getScheduleString());
        }
        return str;
    }
}