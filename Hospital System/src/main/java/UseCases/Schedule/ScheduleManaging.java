package UseCases.Schedule;

import Entity.Schedule.Schedule;
import Exceptions.InvalidInputException;
import Exceptions.StaffNotFoundException;

public interface ScheduleManaging {
    Schedule getSchedule();

    void addOrModifyEvent(String event, String start, String end) throws InvalidInputException;

    void removeEvent(String start, String end) throws StaffNotFoundException;

    String getScheduleString();

    Schedule staffSchedule(String event) throws InvalidInputException;
}
