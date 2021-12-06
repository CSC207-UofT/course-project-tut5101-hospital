package UI.StaffMenu;

import Controllers.Admin.FindBestStaff;
import Controllers.Admin.GetBestStrategies.GetBestByOperationIncome;
import Controllers.Admin.GetBestStrategies.GetBestByOperations;
import Controllers.Admin.GetBestStrategies.GetBestByTime;
import Exceptions.InvalidInputException;
import Presenters.Functions.FindBestStaffPresenter;
import Presenters.MenuPresenter.AdminMenuPresenter;
import Presenters.Schedule.ViewDoctorSchedules;
import Presenters.Schedule.ViewNurseSchedules;
import Presenters.Schedule.ViewOtherStaffSchedules;
import UI.MenuForStaff;

public class AdminMenu extends StaffMenu {
    public AdminMenu(MenuForStaff context) {
        super(context);
        type = "Admin";
    }

    //Stuff admin can do in admin menu
    @Override
    public void doStuff() throws InvalidInputException {
        AdminMenuPresenter adminMenuPresenter = new AdminMenuPresenter();

        int choice = 4;
        do {
            System.out.println(adminMenuPresenter.print());
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                throw new InvalidInputException("");
            }

            if (choice == 1) {
                findBestStaff();
            } else if (choice == 2) {
                checkSchedule();
            } else {
                throw new InvalidInputException("");
            }
        } while (choice != 1 && choice != 2);


    }


    /**
     * Only Admin can call this function to find the best staff function.
     *
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

    /**
     * Check schedule
     */
    public void checkSchedule() {
        int choice = 4;

        do {
            System.out.println("Which kind of staff you want to check the schedule?");
            System.out.println("1: Doctor");
            System.out.println("2: Nurse");
            System.out.println("3: OtherStaff");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Input is invalid, please try again");
            }

            if (choice == 1) {
                ViewDoctorSchedules viewDoctorSchedules = new ViewDoctorSchedules();
                System.out.println(viewDoctorSchedules.print());
            } else if (choice == 2) {
                ViewNurseSchedules viewNurseSchedules = new ViewNurseSchedules();
                System.out.println(viewNurseSchedules.print());
            } else {
                ViewOtherStaffSchedules viewOtherStaffSchedules = new ViewOtherStaffSchedules();
                System.out.println(viewOtherStaffSchedules.print());
            }
        } while (choice != 1 && choice != 2 && choice != 3);
    }


}
