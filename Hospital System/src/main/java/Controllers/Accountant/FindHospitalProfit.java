package Controllers.Accountant;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class FindHospitalProfit {
    /**
     * Controller that find the hospital profit
     */
    StaffManaging manager = StaffManager.getInstance();

    /**
     * Find total profit of this hospital
     *
     * @return Total profit in int
     */
    public int totalProfit() {
        return manager.getHospitalProfit();
    }

}
