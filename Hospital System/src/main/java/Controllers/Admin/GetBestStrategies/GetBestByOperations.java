package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class GetBestByOperations implements GetBestStrategy {
    StaffManaging sm = new StaffManager();

    @Override
    public int findBest() {
        return sm.getBestStaffByNumberOfOperation();
    }
}
