package UseCases.Patient;

import Entity.Patients.Patient;
import UseCases.Schedule.ScheduleManager;

public interface PatientManaging {
    public Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee);

    public void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee);

    public Patient getPatient(int healthCardNum);

    public ScheduleManager getPatientScheduleManager(int healthCardNum);

    public boolean checkIfPatientExist(int hcn);

    public boolean checkLoginInfo(int hcn, String pwd);

    public String getPatientMedicalRecord(int healthCardNumber);

    public String getPatientRecord(int healthCardNumber);
}