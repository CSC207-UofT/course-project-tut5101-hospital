package Entity.Staff.Builders;

import Entity.Staff.Builders.StaffBuilder;
import Entity.Staff.OtherStaff;

public class OtherStaffBuilder extends StaffBuilder {
    /**
     * Other Staff builder for other staff.
     */
    OtherStaff os;

    public OtherStaffBuilder() {
        this.s = new OtherStaff();
        this.os = (OtherStaff) s;
    }

    @Override
    public OtherStaff getResult() {
        return os;
    }

    public void setRole(String role) {
        os.setRole(role);
    }
}
