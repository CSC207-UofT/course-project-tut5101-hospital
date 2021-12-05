package UI.StaffMenu;

import Controllers.Accountant.FindHospitalProfit;
import Presenters.Functions.FindHospitalProfitPresenter;
import UI.MenuForStaff;

public class AccountantMenu extends StaffMenu{
    // Menu for accountant staff
    public AccountantMenu(MenuForStaff context) {
        super(context);
    }

    @Override
    public void doStuff() {

        findHospitalProfit();
    }
    /**
     * Find hospital profit, only account staff can use this.
     */
    public void findHospitalProfit(){
        FindHospitalProfit findHospitalProfit = new FindHospitalProfit();
        new FindHospitalProfitPresenter().print(findHospitalProfit.totalProfit());
    }
}
