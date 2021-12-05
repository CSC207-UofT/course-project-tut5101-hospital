package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class GetBestByOperations implements GetBestStrategy {
    /**
     * Get Best By Operations
     */
    StaffManaging sm = new StaffManager();

    /**
     * Find Best By Operations
     *
     * @return Staff ID
     */
    @Override
    public long findBest() {
        return sm.getBestStaffByNumberOfOperation();
    }
}
