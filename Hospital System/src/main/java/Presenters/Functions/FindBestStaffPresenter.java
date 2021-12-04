package Presenters.Functions;

import Presenters.Printable;

public class FindBestStaffPresenter implements Printable{

    @Override
    public String print() {
        return "Please select how would you want to find the best staff \n" +
                "1: Find best staff by work time.\n" +
                "2: Find best staff by number of operations he/she did.\n" +
                "3: Find best staff by total income from operations he/she did.";
    }

    public String print(String string){
        return "The best staff is: ";
    }
}
