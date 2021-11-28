package UseCases.Staff;

import Entity.Staff.*;
import Entity.Schedule.Schedule;
import UseCases.Operation.OperationManager;

import java.util.ArrayList;
import java.util.List;

// This is based on PatientManager with changes that would modify the class, so that Staff can use it
public class StaffManager implements StaffManaging {
    /**
     * Staff manager use case
     */
    StaffData sessionData = new StaffData();

    /**
     * New staff
     * @param name
     * @param gender
     * @param ID
     * @param workingTime
     * @param pwd
     * @param fixedSalary
     * @return
     */
    public Staff newStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, Double fixedSalary) {
        StaffBuilder sm = new StaffBuilder();
        sm.setName(name);
        sm.setGender(gender);
        sm.setWorkingTime(workingTime);
        sm.setId(ID);
        sm.setPwd(pwd);
        sm.setSalary(fixedSalary);
        return sm.getResult();
    }

    /**
     * Add staff
     * @param name
     * @param gender
     * @param ID
     * @param workingTime
     * @param pwd
     * @param fixedSalary
     */
    public void addStaff(String name, String gender, Integer ID, Schedule workingTime, String pwd, int fixedSalary) {
        StaffBuilder sm = new StaffBuilder();
        sm.setName(name);
        sm.setGender(gender);
        sm.setWorkingTime(workingTime);
        sm.setId(ID);
        sm.setPwd(pwd);
        sm.setSalary(fixedSalary);
        Staff s = sm.getResult();
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

    public List<Staff> getAllStaff() {
        return sessionData.getAllStaff();
    }

    public String getStaffInfo(int id) {
        return getStaff(id).getStaffInfo();
    }

    public List<Integer> getAllStaffID() {
        return sessionData.getAllStaffId();
    }


    /**
     * Return the staff who work the longest
     * @return
     */
    public int getBestStaffByTime(){

        List<Staff> staffList = getAllStaff();
        int time = staffList.get(0).getSchedule().totalTimeInMinutes();
        int id = staffList.get(0).getStaffID();

        for (Staff people: staffList){
            if (people.getSchedule().totalTimeInMinutes()>=time){
                time = people.getSchedule().totalTimeInMinutes();
                id  = people.getStaffID();
            }
        }
        return id;
    }

    /**
     * Return the staff who did most operations
     * @return
     */
    public int getBestStaffByNumberOfOperation(){
        List<Staff> staffList = getAllStaff();
        int numberOperation = 0;
        int id = 0;

        for (Staff people: staffList){
            if (people instanceof Doctor){
                if (((Doctor) people).getFnshdOps().getOperations().size()>=numberOperation){
                    numberOperation = ((Doctor) people).getFnshdOps().getOperations().size();
                    id  = people.getStaffID();
                }
            }
        }
        return id;
    }

    /**
     * Return the staff who earn most money for hospital
     * @return
     */
    public int getBestStaffByMostOperationIncome(){

        List<Staff> staffList = getAllStaff();
        int income = 0;
        int id = 0;

        for (Staff people: staffList){
            if (people instanceof Doctor){
                OperationManager operationManager = new OperationManager((Doctor) people);
                if (operationManager.totalCostOfFinishedOps()>=income){
                    income = operationManager.totalCostOfFinishedOps();
                    id = people.getStaffID();
                }
            }
        }
        return id;
    }


    /**
     * Return the total hospital profit, can be negative number
     * @return
     */
    public int getHospitalProfit(){
        double totalCost = 0;
        double totalRevenue = 0;

        List<Staff> staffList = getAllStaff();
        for (Staff people: staffList){
            totalCost += people.getSalary();
            if (people instanceof Doctor){
                ((Doctor) people).getFnshdOps();
            }
        }
        for (Staff people: staffList){
            if (people instanceof Doctor){
                OperationManager operationManager = new OperationManager((Doctor) people);
                totalRevenue+= operationManager.totalCostOfFinishedOps();
            }
        }

        return (int)(totalCost - totalRevenue);
    }


    /**
     * Return all doctor id
     * @return
     */
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

    /**
     * Return all Nurse id
     * @return
     */
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

    /**
     * Return all other staff id
     * @return
     */
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




