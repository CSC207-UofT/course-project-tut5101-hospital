package UI.StaffMenu;

import Controllers.Admin.GetBestStrategies.GetBestByOperationIncome;
import Controllers.Admin.GetBestStrategies.GetBestByOperations;
import Controllers.Admin.GetBestStrategies.GetBestByTime;
import Exceptions.InvalidInputException;
import Presenters.Functions.FindBestStaffPresenter;
import UseCases.Staff.StaffManager;

public class AdminMenu extends StaffMenu{
    @Override
    public void activity() throws InvalidInputException {
            findBestStaff();
    }/**
     * Only Admin can call this function to find the best staff function.
     * @throws InvalidInputException
     */
    public void findBestStaff() throws InvalidInputException {
        int choice = 4;
        long id;
        FindBestStaffPresenter findBestStaffPresenter = new FindBestStaffPresenter();
        StaffManager staffManager = new StaffManager();

        do {
            findBestStaffPresenter.print();
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }

            if (choice == 1) {
                id = new GetBestByTime().findBest();
            } else if (choice == 2) {
                id = new GetBestByOperations().findBest();
            } else if (choice == 3) {
                id = new GetBestByOperationIncome().findBest();
            } else {
                throw new InvalidInputException("");
            }
        } while (choice != 1 && choice != 2 && choice != 3);

        findBestStaffPresenter.print(staffManager.getStaff(id).getName());
    }

}
