package UseCases.Patient;

import Entity.Patients.Patient;
import UseCases.Schedule.ScheduleManager;

public interface PatientManaging {
    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd);

    public void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd);

    public Patient getPatient(int healthCardNum);

    public ScheduleManager getPatientSm(int healthCardNum);

    public boolean checkIfPateintExist(int hcn);

    public boolean checkLoginInfo(int hcn, String pwd);
}
