package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public interface GetBestStrategy {
    StaffManaging sm = new StaffManager();

    long findBest();
}
