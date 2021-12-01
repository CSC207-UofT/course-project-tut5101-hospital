package UseCases.Patient;

import Entity.Patients.Patient;
import UseCases.Schedule.ScheduleManager;

public interface PatientManaging {
    Patient newPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee);

    void addPatient(String name, String gender, int contactNum, int healthCardNum, String pwd, int fee);

    Patient getPatient(int healthCardNum);

    ScheduleManager getPatientScheduleManager(int healthCardNum);

    boolean checkIfPatientExist(int hcn);

    boolean checkLoginInfo(int hcn, String pwd);

    String getPatientMedicalRecord(int healthCardNumber);

    String getPatientRecord(int healthCardNumber);
}
