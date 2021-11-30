package Controllers.Admin;


import Controllers.Admin.GetBestStrategies.GetBestStrategy;
import UseCases.Staff.StaffManager;
import UseCases.Staff.StaffManaging;

public class FindBestStaff {
    private GetBestStrategy st;

    public void setStrategy(GetBestStrategy st) {
        this.st = st;
    }

    public int execute() {
        return st.findBest();
    }
}
