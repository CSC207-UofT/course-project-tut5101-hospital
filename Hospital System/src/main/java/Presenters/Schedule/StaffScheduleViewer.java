package Presenters.Schedule;

import Presenters.Printable;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;

//View schedules of all staffs
public class StaffScheduleViewer implements Printable {
    StaffManager sm = new StaffManager();
    ScheduleManager scm;
    String str;

    @Override
    public String print() {
        for (int id : sm.getAllStaffID()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += (sm.getStaffInfo(id) + "\t" + scm.getScheduleString());
        }
        return str;
    }
}
