package UseCases.Staff.Builders;

import Entity.Staff.Doctor;

//build doctor, uses staffbuilders methods and return a doctor
public class DoctorBuilder extends StaffBuilder {


    public DoctorBuilder() {
        this.s = new Doctor();
    }

    @Override
    public Doctor getResult() {
        return (Doctor) s;
    }
}
