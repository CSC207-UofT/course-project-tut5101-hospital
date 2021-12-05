package UI.StaffMenu;

import Controllers.Admin.FindBestStaff;
import Controllers.Admin.GetBestStrategies.GetBestByOperationIncome;
import Controllers.Admin.GetBestStrategies.GetBestByOperations;
import Controllers.Admin.GetBestStrategies.GetBestByTime;
import Exceptions.InvalidInputException;
import Presenters.Functions.FindBestStaffPresenter;
import UI.MenuForStaff;
import UseCases.Staff.StaffManager;

public class AdminMenu extends StaffMenu{
    public AdminMenu(MenuForStaff context) {
        super(context);
    }

    @Override
    public void doStuff() throws InvalidInputException {
        findBestStaff();
    }


    /**
     * Only Admin can call this function to find the best staff function.
     * @throws InvalidInputException
     */
    public void findBestStaff() throws InvalidInputException {
        int choice = 4;
        long id;
        FindBestStaffPresenter findBestStaffPresenter = new FindBestStaffPresenter();
        FindBestStaff findBestStaff = new FindBestStaff();
        do {
            System.out.print(findBestStaffPresenter.print());
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }

            if (choice == 1) {
                findBestStaff.setStrategy(new GetBestByTime());
            } else if (choice == 2) {
                findBestStaff.setStrategy(new GetBestByOperations());
            } else if (choice == 3) {
                findBestStaff.setStrategy(new GetBestByOperationIncome());
            } else {
                throw new InvalidInputException("");
            }
            id = findBestStaff.execute();
        } while (choice != 1 && choice != 2 && choice != 3);

        System.out.println(findBestStaffPresenter.print(((int) id)));
    }

}
