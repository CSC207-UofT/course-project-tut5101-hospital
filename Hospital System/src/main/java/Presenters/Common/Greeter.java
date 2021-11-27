package Presenters.Common;

import Presenters.Printable;

public class Greeter implements Printable {
    /**
     * Greeter class
     */
    @Override
    public String print() {
        return "Welcome to RealFakeHospital";
    }
}
