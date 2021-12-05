package Controllers.Admin.GetBestStrategies;

import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public interface GetBestStrategy {
    /**
     * Interface for GetBestStrategy
     */
    StaffManaging sm = StaffManager.getInstance();

    /**
     * Find best staff id
     *
     * @return staff id
     */
    long findBest();
}
