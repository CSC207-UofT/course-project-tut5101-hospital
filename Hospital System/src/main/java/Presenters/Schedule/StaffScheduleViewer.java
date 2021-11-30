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
     * @return
     */
    @Override
    public String print() {
        for (int id : sm.getAllStaffID()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += (sm.getStaffInfo(id) + "\t" + scm.getScheduleString());
        }
        return str;
    }
}
