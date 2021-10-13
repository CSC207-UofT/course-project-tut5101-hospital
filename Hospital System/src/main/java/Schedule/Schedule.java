package Schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Schedule {
    private String room;
    private HashMap<String, List<GregorianCalendar>> schedule;

    public void addEvent(String event, List<GregorianCalendar> dates){
        this.schedule.put(event, dates);
    }public void removeEvent(String event, List<GregorianCalendar> dates){
        this.schedule.remove(event,dates);
    }public HashMap<String, List<GregorianCalendar>> getSchedule(){
        return 
    }
}

/*      //Room for the doctor
    private String room;
    //The two D array of schedule.
    private Boolean[][] timetable = new Boolean[24][7];


    //The default schedule is people work from 9AM to 9PM
    public Schedule(String room) {
        this.room = room;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 7; j++) {
                timetable[i][j] = true;
            }
        }

        for (int i = 12; i < 24; i++) {
            for (int j = 0; j < 7; j++) {
                timetable[i][j] = false;
            }
        }
    }


    //Print the schedule
    public void printTimeTable(){
        List<String> list = List.of("9AM ","10AM","11AM","12AM","1PM ","2PM ","3PM ","4PM ","5PM ","6PM ","7PM ","8PM "
                ,"9PM ","10PM","11PM","12PM","1AM ","2AM ","3AM ","4AM ","5AM ","6AM ","7AM ","8AM ","9AM ");
        System.out.println("            Mon \tTues\tWedn\tThur\t"+"Fri "+"\t"+"Sat "+"\tSun ");
        for (int i = 0; i < 24; i++) {
            System.out.print(list.get(i)+"--"+list.get(i+1)+"\t");
            for (int j = 0; j < 7; j++) {
                System.out.print(timetable[i][j] + "\t");
            }
            System.out.println();
        }
    } */

