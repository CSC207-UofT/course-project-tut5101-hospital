package Controllers.Admin;


import Controllers.Admin.GetBestStrategies.GetBestStrategy;

public class FindBestStaff {
    private GetBestStrategy st;

    public void setStrategy(GetBestStrategy st) {
        this.st = st;
    }

    public long execute() {
        return st.findBest();
    }
}
