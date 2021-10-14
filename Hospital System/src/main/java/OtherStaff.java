/*
This class contains the information for other staffs.
e.g. Cleaning staff, Management, Security...
 */

public class OtherStaff extends Staff{
    private String name;
    private String gender;
    private String role;
    private Integer ID;
    private Schedule workingTime;

    /**
     * Construct a Staff that is not a doctor or nurse, giving them a name, gender, role, ID, and working time.
     *
     */
    public OtherStaff(String name, String gender, String role, Integer id, Schedule workingTime){
        super(name, gender, id, workingTime);
        this.role = role;
    }

    //This method gets the name of the OtherStaff
    public String getName(){
        return this.name;
    }

    //This method gets the gender of the OtherStaff
    public String getGender(){
        return this.gender;
    }

    //This method gets the id of the OtherStaff
    public Integer getID(){
        return this.ID;
    }

    //This method gets the role of the OtherStaff
    public String getrole(){
        return this.role;
    }

    //This method gets the schedule of the OtherStaff
    public Schedule getWorkingTime(){
        return this.workingTime;
    }
}
