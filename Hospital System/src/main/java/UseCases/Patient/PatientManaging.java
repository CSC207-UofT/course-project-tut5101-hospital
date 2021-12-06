package UseCases.Patient;

import Entity.Patients.Patient;
import UseCases.Schedule.ScheduleManager;

public interface PatientManaging {
    Patient newPatient(String name, String gender, long contactNum, long healthCardNum, String pwd, int fee);

    void addPatient(String name, String gender, long contactNum, long healthCardNum, String pwd, int fee);

    Patient getPatient(long healthCardNum);

    ScheduleManager getPatientScheduleManager(long healthCardNum);

    boolean checkIfPatientExist(long hcn);

    boolean checkLoginInfo(long hcn, String pwd);

    String getPatientMedicalRecord(long healthCardNumber);

    String getPatientRecord(long healthCardNumber);

    void saveSession();
}
