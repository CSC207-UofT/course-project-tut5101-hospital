package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class GetBestByTime implements GetBestStrategy {
    /**
     * Get Best By Time
     */
    StaffManaging sm = new StaffManager();

    /**
     * Find Best By Time
     * @return
     * Staff ID
     */
    @Override
    public long findBest() {
        return sm.getBestStaffByTime();
    }
}
