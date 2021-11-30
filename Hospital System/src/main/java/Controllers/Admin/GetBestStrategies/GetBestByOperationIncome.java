package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class GetBestByOperationIncome implements GetBestStrategy{
    StaffManaging sm = new StaffManager();
    @Override
    public int findBest() {
        return sm.getBestStaffByMostOperationIncome();
    }
}
