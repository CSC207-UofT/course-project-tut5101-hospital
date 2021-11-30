package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class GetBestByTime implements GetBestStrategy {
    StaffManaging sm = new StaffManager();

    @Override
    public int findBest() {
        return sm.getBestStaffByTime();
    }
}
