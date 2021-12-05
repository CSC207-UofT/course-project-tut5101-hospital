package UseCases.Staff;

import Entity.Schedule.Schedule;
import Entity.Staff.Staff;

import java.util.List;

public interface StaffManaging {
    /**
     * Staff managing interface
     */


    void addAccountant(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary);
    void addAdmin(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary);
    void addNurse(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary);
    void addDoctor(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary);

    Staff getStaff(long ID);

    boolean checkIfStaffExist(long ID);

    boolean checkLoginInfo(long ID, String pwd);

    List<Staff> getAllStaff();

    String getStaffInfo(long id);

    long getBestStaffByTime();

    long getBestStaffByNumberOfOperation();

    int getHospitalProfit();

    long getBestStaffByMostOperationIncome();

    List<Long> getAllStaffID();

    List<Long> getAllNurseId();

    List<Long> getAllOtherId();

    public String getStaffType(int id);

    double getSalary(long id);
}
