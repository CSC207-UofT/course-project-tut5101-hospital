package Entity.Staff;

import java.util.ArrayList;
import java.util.HashMap;

import Exceptions.StaffNotFoundException;

import java.io.*;
import java.util.List;

public class StaffData implements java.io.Serializable {
    private HashMap<Long, Staff> allstaff;

    //init
    public StaffData() {
        allstaff = new HashMap<>();
        loadData();
    }


    //get the amount of staff in the database
    public int getStaffDatasize() {
        return allstaff.size();
    }


    //add, modify, remove Entity.Staff
    public void addOrModifyStaff(Staff staff) {
        // add the patient if it is not already in, modify it if it is already in
        //the database.
        if (!allstaff.containsKey(staff.getStaffID())) {
            allstaff.put(staff.getStaffID(), staff);
        }
    }

    public void removeStaff(Staff staff) throws StaffNotFoundException {
        if (!allstaff.containsKey(staff.getStaffID())) {
            allstaff.remove(staff.getStaffID());
        } else {
            throw new StaffNotFoundException("");
        }
    }


    //view and search Entity.Staff
    public String viewStaff(Staff staff) {
        if (!allstaff.containsKey(staff.getStaffID())) {
            return allstaff.get(staff.getStaffID()).getStaffInfo();
        } else {
            return "Entity.Staff not found";
        }
    }

    public Staff searchID(Long ID) {
        return allstaff.getOrDefault(ID, null);
    }

    //get all Staffs
    public List<Staff> getAllStaff() {
        return new ArrayList<Staff>(allstaff.values());
    }

    public List<Long> getAllStaffId() {
        return new ArrayList<Long>(allstaff.keySet());
    }

    //load and save data
    public void saveData() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("staff.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        StaffData pd;
        File file = new File("staff.ser");
        try {
            if (!file.exists() || file.length() == 0) {
                System.out.println("File not available");
            } else {
                FileInputStream fileIn = new FileInputStream("staff.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                pd = (StaffData) in.readObject();
                in.close();
                fileIn.close();
                this.allstaff = pd.allstaff;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
