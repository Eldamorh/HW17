import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.time.temporal.ChronoUnit.*;


public class Main {


    public static Map<ChronoUnit, Long> task1(){
        LocalDateTime startOfTheLectionInMonday = LocalDateTime.of(2021, 1, 25, 20, 0);
        LocalDateTime endOfTheLectionInThursday = LocalDateTime.of(2021, 1, 28, 22, 0);
        Map<ChronoUnit,Long> map = new HashMap<>();

        map.put(DAYS,startOfTheLectionInMonday.until(endOfTheLectionInThursday, DAYS));
        map.put(HOURS,startOfTheLectionInMonday.until(endOfTheLectionInThursday, HOURS));
        map.put(MINUTES,startOfTheLectionInMonday.until(endOfTheLectionInThursday, MINUTES));
        map.put(SECONDS,startOfTheLectionInMonday.until(endOfTheLectionInThursday, SECONDS));
        return map;
    }

    public static Duration task2(){
        LocalTime startOfTheLection13 = LocalTime.of(20, 0);
        LocalTime endOfTheLection13 = LocalTime.of(22, 25, 47);
        Duration duration = Duration.between(startOfTheLection13, endOfTheLection13);

        return duration;
    }

    public static LocalDateTime task3(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/LLL/dd hh:mm:ss a",Locale.US);
        LocalDateTime parsed = LocalDateTime.parse("1999/Jul/18 07:34:56 PM",formatter);
        return parsed;
    }

    public static String task4(){

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm yyyy/MM/dd");
        return localDateTime.format(formatter);
    }

    public static Map<String, Long> task5(){
        LocalDateTime startOfSpring = LocalDateTime.of(0, 3, 1, 0, 0);
        LocalDateTime startOfSummer = LocalDateTime.of(0, 6, 1, 0, 0);
        LocalDateTime startOfAutumn = LocalDateTime.of(0, 9, 1, 0, 0);
        LocalDateTime startOfWinter = LocalDateTime.of(0, 12, 1, 0, 0);
        Map<String,Long> map = new HashMap<>();
        map.put("Spring",startOfSpring.until(startOfSummer, MINUTES));
        map.put("Summer",startOfSummer.until(startOfAutumn, MINUTES));
        map.put("Autumn",startOfAutumn.until(startOfWinter, MINUTES));
        map.put("Winter",startOfWinter.until(startOfSpring.plusYears(1), MINUTES));

        return map;
    }

    public static void main(String[] args) {

        //Задание 1
        System.out.println(task1());

        //Задание 2
        System.out.println(task2().toSeconds());
        System.out.println(task2().toMinutes());

        //Задание 3
        System.out.println(task3());

        //Задание 4
        System.out.println(task4());

        //Задание 5
        System.out.println(task5());

    }
}