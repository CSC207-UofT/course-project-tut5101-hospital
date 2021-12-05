package UI.StaffMenu;

import Controllers.Accountant.FindHospitalProfit;
import Presenters.Functions.FindHospitalProfitPresenter;

public class AccountantMenu extends StaffMenu{
    @Override
    public void activity() {
        findHospitalProfit();
    }/**
     * Find hospital profit, only account staff can use this.
     */
    public void findHospitalProfit(){
        FindHospitalProfit findHospitalProfit = new FindHospitalProfit();
        new FindHospitalProfitPresenter().print(findHospitalProfit.totalProfit());
    }
}
