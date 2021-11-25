package Entity.Schedule;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import Exceptions.InvalidInputException;
import Exceptions.StuffNotFoundException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Entity
public class Schedule implements java.io.Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room")
    private String room;


    @ElementCollection
    @JoinColumn(name = "event")

    private HashMap<Event, String> schedule = new HashMap<Event, String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //private transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E");

    public void add_or_modify_Event(String event, Event dates) throws InvalidInputException {
        if (!schedule.containsKey(dates)) {
            this.schedule.put(dates, event);
        } else {
            throw new InvalidInputException("");
        }
    }

    public void removeEvent(Event dates) throws StuffNotFoundException {
        boolean ex = true;
        for (Event key : schedule.keySet()) {
            if ((key.getEndTime() == dates.getEndTime()) && (key.getStartTime() == dates.getStartTime())) {
                this.schedule.remove(dates);
                ex = false;
            }
        }
        if (ex) {
            throw new StuffNotFoundException("");
        }
    }

    public HashMap<Event, String> getSchedule() {
        return schedule;
    }

    public String getScheduleString() {
        if (schedule == null || schedule.isEmpty()) {
            return "You have no appointments";
        }
        StringBuilder s = new StringBuilder();
        for (Entry<Event, String> entry : schedule.entrySet()) {
            s.append("Start-End:\t");

            s.append(entry.getKey().getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E")));
            s.append("\t");

            s.append("\tEvent:");
            s.append(entry.getValue());
        }
        return s.toString();
    }

    @Converter(autoApply = true)
    public static class DateListConverter implements AttributeConverter<Event, String> {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        private static final String SPLIT_CHAR = ";";


        @Override
        public String convertToDatabaseColumn(Event attribute) {
            return attribute.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E")) + SPLIT_CHAR + attribute.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm E"));
        }

        @Override
        public Event convertToEntityAttribute(String string) {
            Event localDateTimes = new Event(null, null);
            if (!string.isEmpty()) {
                List<String> list_s = Arrays.asList(string.split(SPLIT_CHAR));
                localDateTimes.setStartTime(LocalDateTime.parse(list_s.get(0), formatter));
                localDateTimes.setEndTime(LocalDateTime.parse(list_s.get(1), formatter));
            }
            return localDateTimes;
        }
    }
}

/*      //Room for the doctor
    private String room;
    //The two D array of schedule.
    private Boolean[][] timetable = new Boolean[24][7];


    //The default schedule is people work from 9AM to 9PM
    public Entity.Schedule(String room) {
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

