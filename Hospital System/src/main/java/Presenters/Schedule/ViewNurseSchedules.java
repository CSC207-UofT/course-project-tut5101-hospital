package Presenters.Schedule;

import Presenters.Printable;

import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;

public class ViewNurseSchedules implements Printable {
    /**
     * Nurse schedule viewer presenter
     */
    StaffManager sm = new StaffManager();
    ScheduleManager scm;
    String str;

    /**
     * See all Nurse schedule
     *
     * @return
     */
    @Override
    public String print() {
        for (long id : sm.getAllNurseId()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += (sm.getStaffInfo(id) + "\t" + scm.getScheduleString() + "\n");
        }
        return str;
    }
}
