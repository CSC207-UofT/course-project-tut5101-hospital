package Presenters.MenuPresenter;

import Presenters.Printable;

public class AdminMenuPresenter implements Printable {

    /**
     * Presenter for admin menu
     */
    @Override
    public String print() {
        return "Admin Menu: \n" +
                "1: Find best staff\n" +
                "2: View doctor schedule\n";
    }
}
