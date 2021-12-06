package Presenters.Schedule;

import Presenters.Printable;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.StaffManager;


public class ViewDoctorSchedules implements Printable {
    /**
     * Doctor schedule viewer presenter
     */
    StaffManager sm = StaffManager.getInstance();
    ScheduleManager scm;
    String str;

    /**
     * See all Doctor schedule
     *
     * @return String
     */
    @Override
    public String print() {
        for (long id : sm.getAllDoctorId()) {
            scm = new ScheduleManager(sm.getStaff(id));
            str += ("\n" + sm.getStaffInfo(id) + "\n" + scm.getScheduleString() + "\n");
        }
        return str;
    }
}
