package Presenters.Schedule;

import Presenters.Printable;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;

public class StaffScheduleViewer implements Printable {
    /**
     * Staff schedule viewer presenter
     */
    StaffManager sm = new StaffManager();
    ScheduleManager scm;
    String str;

    /**
     * See all staff schedule
     *
     * @return String
     */
    @Override
    public String print() {
        for (long id : sm.getAllStaffID()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += (sm.getStaffInfo(id) + "\t" + scm.getScheduleString() + "\n");
        }
        return str;
    }
}
