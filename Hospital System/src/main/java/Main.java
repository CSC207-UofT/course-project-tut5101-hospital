import Controllers.Appointment.AppointmentMaker;
import Exceptions.InvalidInputException;
import Exceptions.StaffNotFoundException;
import UI.MenuChooseStaffOrPatient;

public class Main {
    public static void main(String[] args) throws InvalidInputException, StaffNotFoundException {
        MenuChooseStaffOrPatient menuChooseStaffOrPatient = new MenuChooseStaffOrPatient();
        menuChooseStaffOrPatient.choosePatientOrStaff();
//        AppointmentMaker appointmentMaker = new AppointmentMaker(1, "id");
//        System.out.println(appointmentMaker.getStaffSchedule());
//        long id = 1;
//        appointmentMaker.deleteEvent("2021-12-01 08:00", "2021-12-01 09:00", id, 1);
//        System.out.println(appointmentMaker.getStaffSchedule());
    }

}