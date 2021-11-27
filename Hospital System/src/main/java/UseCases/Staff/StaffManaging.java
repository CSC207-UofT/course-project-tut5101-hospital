package UseCases.Staff;

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;

import java.util.List;

public interface StaffManaging {
    /**
     * Staff managing interface
     */


    public Staff newStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, Double fixedSalary);

    public void addStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, int fixedSalary);

    public Staff getStaff(Integer ID);

    public boolean checkIfStaffExist(Integer ID);

    public boolean checkLoginInfo(Integer ID, String pwd);

    public List<Staff> getAllStaff();

    public String getStaffInfo(int id);

    public List<Integer> getAllStaffID();

    public List<Integer> getAllNurseId();

    public List<Integer> getAllOtherId();
}
