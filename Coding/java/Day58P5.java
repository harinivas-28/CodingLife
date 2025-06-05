package Coding.java;
/*
Write a java program that reads two timestamps (yyyy-MM-dd HH:mm:ss format) and
display the time elapsed between them in minutes and seconds.

Input:
------
2025-06-04 10:30:00
2025-06-04 11:15:40

Output:
-------
Elapsed: 45 minutes 40 seconds
*/
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Day58P5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime t1 = LocalDateTime.parse(s1, dtf);
        LocalDateTime t2 = LocalDateTime.parse(s2, dtf);
        Duration d = Duration.between(t1, t2);
        long tSec = Math.abs(d.getSeconds());
        long min = tSec/60;
        long sec = tSec %60;
        System.out.println("Elapsed: " + min + " minutes " + sec + " seconds");
    }
}