/*
This class contains the information for other staffs.
eg. Janitor, Management, Security...
 */
public class OtherStaff extends Staff{
    private String name;
    private String gender;
    private Integer ID;
    private Schedule workingTime;

    /**
     * Construct a Staff that is not a doctor or nurse, giving them a name, gender, ID, and working time.
     *
     */
    public OtherStaff(String name, String gender, Schedule workingTime){
        super(name, gender, workingTime);
        StaffData m = new StaffData();
        this.ID = m.getStaffDatasize();
    }

    //This method gets the name of the OtherStaff
    public String getName(){
        return this.name;
    }

    //This method gets the gender of the OtherStaff
    public String getGender(){
        return this.gender;
    }

    //This method gets the role of the OtherStaff
    public Integer getID(){
        return this.ID;
    }

    //This method gets the schedule of the OtherStaff
    public Schedule getWorkingTime(){
        return this.workingTime;
    }
}
