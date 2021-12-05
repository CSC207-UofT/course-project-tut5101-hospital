package Presenters.MenuPresenter;

import Presenters.Printable;

public class DoctorMenuPresenter implements Printable {

    /**
     * Presenter for doctor menu
     */
    @Override
    public String print() {
        return "Doctor Menu: \n" +
                "1: View patient record\n" +
                "2: Add Patient Medical History\n";
    }
}
