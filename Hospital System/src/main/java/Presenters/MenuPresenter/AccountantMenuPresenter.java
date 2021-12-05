package Presenters.MenuPresenter;

import Presenters.Printable;

public class AccountantMenuPresenter implements Printable {
    /**
     * Presenter for Accountant menu
     */
    @Override
    public String print() {
        return "Accountant Menu: \n" +
                "1: Find total profit\n";
    }
}
