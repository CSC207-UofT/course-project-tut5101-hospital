package Presenters.Functions;

import Presenters.Printable;

public class FindBestStaffPresenter implements Printable {
    /**
     * Presenter for find best staff
     *
     * @return String
     */
    @Override
    public String print() {
        return "Please select how would you want to find the best staff \n" +
                "1: Find best staff by work time.\n" +
                "2: Find best staff by number of operations he/she did.\n" +
                "3: Find best staff by total income from operations he/she did.\n";
    }

    public String print(int id) {
        return "Congratulate! The best staff's id is: " + id;
    }
}
