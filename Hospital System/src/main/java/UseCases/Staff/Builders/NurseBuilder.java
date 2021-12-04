package UseCases.Staff.Builders;

import Entity.Patients.Patient;
import Entity.Staff.Nurse;

import java.util.ArrayList;

//build nurse, uses staffbuilders methods and return a nurse
public class NurseBuilder extends StaffBuilder {

    public NurseBuilder() {
        this.s = new Nurse();
    }

    @Override
    public Nurse getResult() {
        return (Nurse) s;
    }

    public void setPatients(ArrayList<Patient> patients) {

        ((Nurse) s).setPatients(patients);
    }
}
