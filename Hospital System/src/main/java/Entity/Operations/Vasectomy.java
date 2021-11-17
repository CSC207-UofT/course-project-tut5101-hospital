package Entity.Operations;

import java.time.LocalDateTime;
import java.util.List;

public class Vasectomy extends Operations{
    public Vasectomy( List<LocalDateTime> time) {
        super(time);
        super.setName("Vasectomy");
        super.setDescription("Cutting and sealing the tubes.");
        super.setCost(500);
    }
}
