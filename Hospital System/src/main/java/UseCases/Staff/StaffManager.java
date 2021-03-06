package UseCases.Staff;

import Entity.Schedule.Schedule;
import Entity.Staff.*;
import Gateways.StaffGateway;
import UseCases.Operation.OperationManager;
import UseCases.Schedule.ScheduleManager;
import UseCases.Staff.MethodsForStaffManager.NewStaffs;

import java.util.ArrayList;
import java.util.List;

// This is based on PatientManager with changes that would modify the class, so that Staff can use it
public class StaffManager implements StaffManaging {
    /**
     * Staff manager use case
     */
    StaffData sessionData = new StaffData();

    //singleton design pattern
    private static StaffManager sm = null;

    private StaffManager() {

    }

    public static StaffManager getInstance() {
        if (sm == null) {
            sm = new StaffManager();
        }
        return sm;
    }


    /**
     * Add staff
     *
     */
    public void addNurse(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary) {
        Staff s = new NewStaffs().newNurse(name, gender, ID, workingTime, pwd, fixedSalary);
        sessionData.addOrModifyStaff(s);
        new StaffGateway().saveSession(sessionData);
    }

    public void addAdmin(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary) {
        Staff s = new NewStaffs().newAdmin(name, gender, ID, workingTime, pwd, fixedSalary);
        sessionData.addOrModifyStaff(s);
        new StaffGateway().saveSession(sessionData);
    }

    public void addAccountant(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary) {
        Staff s = new NewStaffs().newAccountant(name, gender, ID, workingTime, pwd, fixedSalary);
        sessionData.addOrModifyStaff(s);
        new StaffGateway().saveSession(sessionData);
    }

    public void addDoctor(String name, String gender, long ID, Schedule workingTime, String pwd, int fixedSalary) {
        Staff s = new NewStaffs().newDoctor(name, gender, ID, workingTime, pwd, fixedSalary);
        sessionData.addOrModifyStaff(s);
        new StaffGateway().saveSession(sessionData);
    }


    //getter setters
    @Override
    public double getSalary(long id) {
        return getStaff(id).getSalary();
    }

    public Staff getStaff(long ID) {
        return sessionData.searchID(ID);
    }

    public boolean checkIfStaffExist(Long ID) {
        return (sessionData.searchID(ID) != null);
    }

    public boolean checkLoginInfo(long ID, String pwd) {
        if (sessionData.searchID(ID) != null) {
            return sessionData.searchID(ID).checkPwd(pwd);
        }
        return false;

    }

    public ScheduleManager getStaffSm(long id) {
        return new ScheduleManager(sessionData.searchID(id));
    }

    public List<Staff> getAllStaff() {
        return sessionData.getAllStaff();
    }

    public String getStaffInfo(long id) {
        return getStaff(id).getStaffInfo();
    }

    @Override
    public List<Long> getAllStaffID() {
        return sessionData.getAllStaffId();
    }


    /**
     * Return the staff who work the longest
     *
     */
    public long getBestStaffByTime() {

        List<Staff> staffList = getAllStaff();
        int time = staffList.get(0).getSchedule().totalTimeInMinutes();
        long id = staffList.get(0).getStaffID();

        for (Staff people : staffList) {
            if (people.getSchedule().totalTimeInMinutes() >= time) {
                time = people.getSchedule().totalTimeInMinutes();
                id = people.getStaffID();
            }
        }
        return id;
    }

    /**
     * Return the staff who did most operations
     *
     */
    public long getBestStaffByNumberOfOperation() {
        List<Staff> staffList = getAllStaff();
        int numberOperation = 0;
        long id = 0;

        for (Staff people : staffList) {
            if (people instanceof Doctor) {
                if (((Doctor) people).getFnshdOps().getOperations().size() >= numberOperation) {
                    numberOperation = ((Doctor) people).getFnshdOps().getOperations().size();
                    id = people.getStaffID();
                }
            }
        }
        return id;
    }

    /**
     * Return the staff who earn most money for hospital
     *
     */
    @Override
    public long getBestStaffByMostOperationIncome() {

        List<Staff> staffList = getAllStaff();
        int income = 0;
        long id = 0;

        for (Staff people : staffList) {
            if (people instanceof Doctor) {
                OperationManager operationManager = new OperationManager((Doctor) people);
                if (operationManager.totalCostOfFinishedOps() >= income) {
                    income = operationManager.totalCostOfFinishedOps();
                    id = people.getStaffID();
                }
            }
        }
        return id;
    }


    /**
     * Return the total hospital profit, can be negative number
     *
     */
    @Override
    public int getHospitalProfit() {
        double totalCost = 0;
        double totalRevenue = 0;

        List<Staff> staffList = getAllStaff();
        for (Staff people : staffList) {
            totalCost += people.getSalary();
        }
        for (Staff people : staffList) {
            if (people instanceof Doctor) {
                OperationManager operationManager = new OperationManager((Doctor) people);
                totalRevenue += operationManager.totalCostOfFinishedOps();
            }
        }

        return (int) (totalCost - totalRevenue);
    }


    //iterating and get all kinds of ids

    /**
     * Return all doctor id
     *
     */
    public List<Long> getAllDoctorId() {
        List<Staff> staffs = getAllStaff();
        List<Long> doctors = new ArrayList<Long>();
        for (Staff s : staffs) {
            if (s instanceof Doctor) {
                doctors.add(s.getStaffID());
            }
        }
        return doctors;
    }

    /**
     * Return all Nurse id
     *
     */
    @Override
    public List<Long> getAllNurseId() {
        List<Staff> staffs = getAllStaff();
        List<Long> nurses = new ArrayList<Long>();
        for (Staff s : staffs) {
            if (s instanceof Nurse) {
                nurses.add(s.getStaffID());
            }
        }
        return nurses;
    }

    /**
     * Return all other staff id
     *
     */
    public List<Long> getAllOtherId() {
        List<Staff> staffs = getAllStaff();
        List<Long> others = new ArrayList<Long>();
        for (Staff s : staffs) {
            if (s instanceof OtherStaff) {
                others.add(s.getStaffID());
            }
        }
        return others;
    }

    public String getStaffType(long id) {
        Staff s = getStaff(id);
        if (s instanceof Doctor) {
            return "Doctor";
        }
        if (s instanceof Nurse) {
            return "Nurse";
        }
        if (s instanceof Accountant) {
            return "Accountant";
        }
        if (s instanceof Admin) {
            return "Admin";
        } else {
            return "OtherStaff";
        }
    }

    public void saveSession() {
        new StaffGateway().saveSession(sessionData);
    }


}




