package Practise.java;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeBasics {
    public static void main(String[] args){
        LocalDate today = LocalDate.now();
        System.out.println("TODAY: "+today);
        LocalTime cTime = LocalTime.now();
        System.out.println("Current Time: "+cTime);
        LocalDateTime cDateTime = LocalDateTime.now();
        System.out.println("Current Date Time: "+cDateTime);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dtf.format(cDateTime);
        System.out.println("FORMATTED DATE: "+formattedDate);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd MMMM, yyyy - E");
        System.out.println(dtf2.format(today));
    }
}
