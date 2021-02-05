import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

    @Test
    public void task1test(){
        Map<ChronoUnit,Long> actualResult = Main.task1();
        Map<ChronoUnit,Long> expectedResult = new HashMap<>();
        expectedResult.put(ChronoUnit.DAYS,3L);
        expectedResult.put(ChronoUnit.HOURS,74L);
        expectedResult.put(ChronoUnit.MINUTES,4440L);
        expectedResult.put(ChronoUnit.SECONDS,266400L);
        Assertions.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void task2test(){
        Duration actualDuration = Main.task2();
        int expectedSeconds = 8747;
        int expectedMinutes = 145;
        if(actualDuration.toMinutes() != expectedMinutes || actualDuration.toSeconds() != expectedSeconds){
            Assertions.fail();
        }
    }

    @Test
    public void task3test(){
        LocalDateTime actualTime = Main.task3();
        LocalDateTime expectedTime = LocalDateTime.of(1999,7,18, 19,34,56);
        Assertions.assertEquals(actualTime,expectedTime);
    }

    @Test
    public void task4test(){
        String actualTime = Main.task4();
        Pattern pattern = Pattern.compile("\\d\\d:\\d\\d \\d{4}/\\d\\d/\\d\\d");
        Matcher matcher = pattern.matcher(actualTime);
        if(!matcher.matches()){
            Assertions.fail();
        }

    }
}
