package Entity;

import Entity.Operations.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestOperation {

    private Operation operation;
    private final ArrayList<LocalDateTime> time = new ArrayList<>();

    @Before
    public void setUp(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime st = LocalDateTime.parse("2021-12-05 12:00", formatter);
        LocalDateTime e = LocalDateTime.parse("2021-12-05 13:00", formatter);
        time.add(st);
        time.add(e);
        operation = new Operation(1000, "Heart Surgury", "Replace Heart", time);
    }

    @Test
    public void TestGetCost(){
        Assert.assertEquals(operation.getCost(), 1000);
    }

    @Test
    public void TestGetName(){
        Assert.assertEquals(operation.getName(), "Heart Surgury");
    }

    @Test
    public void TestGetDescription(){
        Assert.assertEquals(operation.getDescription(), "Replace Heart");
    }

    @Test
    public void TestGetTime(){
        Assert.assertEquals(operation.getTime(), time);
    }
}
