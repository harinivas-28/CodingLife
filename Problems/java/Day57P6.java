package Problems.java;
/*

Write Java code to print system date & time in format like 
2021-10-02 10:30:00 AM

Sample Output: 2025-06-04 11:35:27 AM

*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Day57P6 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String res = dtf.format(now);
        System.out.println(res);
    }
}