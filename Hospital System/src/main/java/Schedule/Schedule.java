package Schedule;
import java.util.List;
import java.util.Map.Entry;

import Exceptions.StuffNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Schedule implements java.io.Serializable{
    private String room;
    private HashMap<List<LocalDateTime>, String> schedule = new HashMap<List<LocalDateTime>, String>() ;
    //private transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E");

    public void add_or_modify_Event(String event, List<LocalDateTime> dates){
        if (!schedule.containsKey(dates)){
            this.schedule.put(dates, event);}
    }public void removeEvent(List<LocalDateTime> dates) throws StuffNotFoundException{
        if (!schedule.containsKey(dates)){
            this.schedule.remove(dates);
        }else{
            throw new StuffNotFoundException("");
        }
    }public HashMap<List<LocalDateTime>, String> getSchedule(){
        return schedule;
    }public String getScheduleString(){
        if(schedule==null||schedule.isEmpty()){
            return "You have no appointments";
        }
        String s ="";
        for (Entry<List<LocalDateTime>, String> entry : schedule.entrySet()){
            s+="Start-End:\t";
            for (LocalDateTime t : entry.getKey()){
                s+=t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E"));
                s+="\t";
            }s+="\tEvent:";
            s+=entry.getValue();
        }return s;
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

