package Controllers.Admin;


import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class FindBestStaff {
    /**
     * Controller that find the best staff
     */
    StaffManaging manager;

    /**
     * Constructor for this controller
     */
    public FindBestStaff() {
        StaffManaging manager = new StaffManager();
    }

    /**
     * Find the staff who worked longest in hospital
     * @return
     */
    public int findBestStaffByTime(){
        return manager.getBestStaffByTime();
    }

    /**
     * Find the staff who did most operations
     * @return
     */
    public int findBestStaffByOperations(){
        return manager.getBestStaffByNumberOfOperation();
    }


    /**
     * Find the staff who earn most operations income
     * @return
     */
    public int findBestStaffByOperationsIncome(){
        return manager.getBestStaffByMostOperationIncome();
    }
}
