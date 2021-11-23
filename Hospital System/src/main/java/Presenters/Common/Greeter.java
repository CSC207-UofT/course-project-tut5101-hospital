package Presenters.Common;

import Presenters.Printable;

public class Greeter implements Printable {
    @Override
    public String print() {
        return "Welcome to RealFakeHospital";
    }
}
