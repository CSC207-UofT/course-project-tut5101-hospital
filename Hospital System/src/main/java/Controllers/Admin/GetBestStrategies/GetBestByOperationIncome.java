package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class GetBestByOperationIncome implements GetBestStrategy {
    /**
     * Get best by operating income
     */
    StaffManaging sm = new StaffManager();

    /**
     * Find best by operating income
     *
     * @return Staff ID
     */
    @Override
    public long findBest() {
        return sm.getBestStaffByMostOperationIncome();
    }
}
