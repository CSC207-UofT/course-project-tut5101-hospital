package UI.StaffMenu;

import Controllers.Appointment.AppointmentMaker;
import Entity.PatientRecords.PatientMedicalHistory;
import Entity.Staff.Staff;
import Exceptions.InvalidInputException;
import Presenters.PatientRecords.PatientMedicalRecordViewer;
import Presenters.PatientRecords.PatientRecordViewer;
import UI.MenuForStaff;
import UseCases.Schedule.ScheduleManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DoctorMenu extends StaffMenu{
    public DoctorMenu(MenuForStaff context) {
        super(context);
    }

    @Override
    public void doStuff() {

    }

}
