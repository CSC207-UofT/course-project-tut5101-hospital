package UseCases.Staff;

import Entity.Staff.*;
import Entity.Schedule.Schedule;
import UseCases.Schedule.ScheduleManager;

import java.util.ArrayList;
import java.util.List;

// This is based on PatientManager with changes that would modify the class, so that Staff can use it
public class StaffManager {

    StaffData sessionData = new StaffData();

    public Staff newStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, int fixedSalary) {
        return new Staff(name, gender, ID, workingTime, pwd, fixedSalary);
    }

    public void addStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, int fixedSalary) {
        Staff s = new Staff(name, gender, ID, workingTime, pwd, fixedSalary);
        sessionData.add_or_modify_Staff(s);
        saveSession();
    }

    private void saveSession() {
        sessionData.saveData();
    }

    public Staff getStaff(Integer ID) {
        return sessionData.searchID(ID);
    }

    public boolean checkIfStaffExist(Integer ID) {
        return (sessionData.searchID(ID) != null);
    }

    public boolean checkLoginInfo(Integer ID, String pwd) {
        if (sessionData.searchID(ID) != null) {
            return sessionData.searchID(ID).checkPwd(pwd);
        }
        return false;

    }

    public ScheduleManager getStaffSm(int id) {
        return new ScheduleManager(sessionData.searchID(id));
    }

    public List<Staff> getAllStaff() {
        return sessionData.getAllStaff();
    }

    public String getStaffInfo(int id) {
        return getStaff(id).getStaffInfo();
    }

    public List<Integer> getAllStaffID() {
        return sessionData.getAllStaffId();
    }

    //return different types of staffs
    public List<Integer> getAllDoctorId() {
        List<Staff> staffs = getAllStaff();
        List<Integer> doctors = new ArrayList<Integer>();
        for (Staff s : staffs) {
            if (s instanceof Doctor) {
                doctors.add(s.getStaffID());
            }
        }
        return doctors;
    }

    public List<Integer> getAllNurseId() {
        List<Staff> staffs = getAllStaff();
        List<Integer> nurses = new ArrayList<Integer>();
        for (Staff s : staffs) {
            if (s instanceof Nurse) {
                nurses.add(s.getStaffID());
            }
        }
        return nurses;
    }

    public List<Integer> getAllOtherId() {
        List<Staff> staffs = getAllStaff();
        List<Integer> others = new ArrayList<Integer>();
        for (Staff s : staffs) {
            if (s instanceof OtherStaff) {
                others.add(s.getStaffID());
            }
        }
        return others;
    }
}




