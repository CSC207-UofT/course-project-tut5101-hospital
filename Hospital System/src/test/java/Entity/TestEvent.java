package Entity;

import Entity.Schedule.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestEvent {

    private final Event event = new Event();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final LocalDateTime st = LocalDateTime.parse("2021-12-01 12:00", formatter);
    private final LocalDateTime e = LocalDateTime.parse("2021-12-01 13:00", formatter);


    @Before
    public void setUp(){
        event.setStartTime(st);
        event.setEndTime(e);
    }

    @Test
    public void TestGetStartTime(){
        Assert.assertEquals(event.getStartTime(), st);
    }

    @Test
    public void TestGetEndTime(){
        Assert.assertEquals(event.getEndTime(), e);
    }
}
