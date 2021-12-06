package Presenters.Schedule;

import Presenters.Printable;

import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;

public class ViewNurseSchedules implements Printable {
    /**
     * Nurse schedule viewer presenter
     */
    StaffManager sm = StaffManager.getInstance();
    ScheduleManager scm;
    String str;

    /**
     * See all Nurse schedule
     *
     * @return String
     */
    @Override
    public String print() {
        for (long id : sm.getAllNurseId()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += ("\n" + sm.getStaffInfo(id) + "\n" + scm.getScheduleString() + "\n");
        }
        return str;
    }
}
