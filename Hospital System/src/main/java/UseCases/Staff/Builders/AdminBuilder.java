package UseCases.Staff.Builders;

import Entity.Staff.Admin;

public class AdminBuilder extends StaffBuilder {

    public AdminBuilder() {
        this.s = new Admin();
    }

    @Override
    public Admin getResult() {
        return (Admin) s;
    }

}
