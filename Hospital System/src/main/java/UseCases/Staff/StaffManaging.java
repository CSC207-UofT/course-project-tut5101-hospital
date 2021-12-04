package UseCases.Staff;

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;

import java.util.List;

public interface StaffManaging {
    /**
     * Staff managing interface
     */


    Staff newStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, Double fixedSalary);

    void addStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, int fixedSalary);

    Staff getStaff(Integer ID);

    boolean checkIfStaffExist(Integer ID);

    boolean checkLoginInfo(Integer ID, String pwd);

    List<Staff> getAllStaff();

    String getStaffInfo(int id);

    int getBestStaffByTime();

    int getBestStaffByNumberOfOperation();

    int getHospitalProfit();

    int getBestStaffByMostOperationIncome();

    List<Integer> getAllStaffID();

    List<Integer> getAllNurseId();

    List<Integer> getAllOtherId();

    double getSalary(int id);

    String getStaffType(int id);
}
