package Gateways;

import Entity.Staff.StaffData;

public class StaffGateway {
    public void saveSession(StaffData sessionData) {
        sessionData.saveData();
    }
}
