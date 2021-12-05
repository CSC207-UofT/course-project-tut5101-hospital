package Presenters.Schedule;

import Presenters.Printable;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;


public class ViewDoctorSchedules implements Printable {
    /**
     * Doctor schedule viewer presenter
     */
    StaffManager sm = new StaffManager();
    ScheduleManager scm;
    String str;

    /**
     * See all Doctor schedule
     *
     * @return
     */
    @Override
    public String print() {
        for (long id : sm.getAllDoctorId()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += (sm.getStaffInfo(id) + "\t" + scm.getScheduleString() + "\n");
        }
        return str;
    }
}
