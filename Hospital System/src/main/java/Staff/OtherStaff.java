package Staff;
import Schedule.Schedule;


/*
This class contains the information for other staffs.
eg. Janitor, Management, Security...
 */
public class OtherStaff extends Staff{
    private String name;
    private String gender;
    private String role;
    private String ID;
    private Schedule workingTime;

    /**
     * Construct a Staff that is not a doctor or nurse, giving them a name, gender, role, ID, and working time.
     *
     */
    public OtherStaff(String name, String gender, String role, String ID, Schedule workingTime, String pwd){
        super(name, gender, role, pwd);
        this.ID = ID;
        this.workingTime = workingTime;
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
    public String getRole(){
        return this.role;
    }

    //This method gets the role of the OtherStaff
    public String getID(){
        return this.ID;
    }

    //This method gets the schedule of the OtherStaff
    public Schedule getWorkingTime(){
        return this.workingTime;
    }
}
