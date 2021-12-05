package Controllers.Admin;


import Controllers.Admin.GetBestStrategies.GetBestStrategy;

public class FindBestStaff {
    /**
     * Find best staff strategy
     */
    private GetBestStrategy strategy;

    /**
     *
     * @param strategy what kind of strategy you want
     */
    public void setStrategy(GetBestStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Find best staff based on strategy
     * @return id
     */
    public long execute() {
        return strategy.findBest();
    }
}
