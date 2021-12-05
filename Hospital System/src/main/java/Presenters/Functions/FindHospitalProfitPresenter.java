package Presenters.Functions;

import Presenters.Printable;

public class FindHospitalProfitPresenter implements Printable {
    /**
     * Presenter for find hospital profit function
     */


    @Override
    public String print() {
        return "1: Find Hospital profit";
    }

    /**
     * Print out profit
     *
     * @param profit Profit of hospital
     * @return A line
     */
    public String print(int profit) {
        return "Total profit for our hospital is: " + profit;
    }
}
