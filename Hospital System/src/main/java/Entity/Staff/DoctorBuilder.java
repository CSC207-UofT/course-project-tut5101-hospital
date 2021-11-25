package Entity.Staff;

//build doctor, uses staffbuilders methods and return a doctor
public class DoctorBuilder extends StaffBuilder {
    Doctor d;

    public DoctorBuilder() {
        this.s = new Doctor();
        this.d = (Doctor) s;
    }

    @Override
    public Doctor getResult() {
        return d;
    }
}
