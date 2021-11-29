package Controllers.Admin;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class FindHospitalProfit {
    /**
     * Controller that find the hospital profit
     */
    StaffManaging manager;

    /**
     * Constructor for this controller
     */
    public FindHospitalProfit() {
        StaffManaging manager = new StaffManager();
    }

    /**
     * Find total profit of this hospital
     *
     * @return
     */
    public int totalProfit() {
        return manager.getHospitalProfit();
    }

}
