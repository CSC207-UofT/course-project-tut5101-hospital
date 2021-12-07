package Presenters.Schedule;

import Presenters.Printable;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;


public class ViewOtherStaffSchedules implements Printable {
    /**
     * Other staff schedule viewer presenter
     */
    StaffManager sm = StaffManager.getInstance();
    ScheduleManager scm;
    String str;

    /**
     * See all other staff schedule
     *
     * @return String
     */
    @Override
    public String print() {
        for (long id : sm.getAllOtherId()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += ("\n" + sm.getStaffInfo(id) + "\n" + scm.getScheduleString() + "\n");
        }
        return str;
    }
}
