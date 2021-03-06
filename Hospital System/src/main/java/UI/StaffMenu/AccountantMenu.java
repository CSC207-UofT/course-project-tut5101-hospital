package UI.StaffMenu;

import Controllers.Accountant.FindHospitalProfit;
import Exceptions.InvalidInputException;
import Presenters.Functions.FindHospitalProfitPresenter;
import Presenters.MenuPresenter.AccountantMenuPresenter;
import UI.MenuForStaff;

public class AccountantMenu extends StaffMenu {
    // Menu for accountant staff
    public AccountantMenu(MenuForStaff context) {
        super(context);
        type = "Accountant";
    }

    //The stuff account can do in stuff menu
    @Override
    public void doStuff() throws InvalidInputException {
        AccountantMenuPresenter accountantMenuPresenter = new AccountantMenuPresenter();

        int choice = 4;
        do {
            System.out.println(accountantMenuPresenter.print());
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }

            if (choice == 1) {
                findHospitalProfit();
            } else {
                throw new InvalidInputException("");
            }
        } while (choice != 1);
    }


    /**
     * Find hospital profit, only account staff can use this.
     */
    public void findHospitalProfit() {
        FindHospitalProfit findHospitalProfit = new FindHospitalProfit();
        System.out.println(new FindHospitalProfitPresenter().print(findHospitalProfit.totalProfit()));
    }
}
