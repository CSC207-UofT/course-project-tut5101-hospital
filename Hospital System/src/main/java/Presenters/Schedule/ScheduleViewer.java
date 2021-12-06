package Presenters.Schedule;

import Presenters.Printable;
import UseCases.Patient.PatientManager;
import UseCases.Schedule.ScheduleManager;

public class ScheduleViewer implements Printable {
    long hcn;
    public ScheduleViewer(long hcn){
        this.hcn=hcn;
    }
    @Override
    public String print() {
        ScheduleManager sm = new ScheduleManager(PatientManager.getInstance().getPatient(hcn));
        String s = sm.getScheduleString();
        return s;
    }
}
