package Problems.java;
/*
Write a java program, for given a birthdate in yyyy-MM-dd format, calculate the person’s current age in years, months, and days.

Input:
------
1990-05-25

Output:
-------
Age: 34 years, 0 months, 10 days
*/
import java.util.*;
import java.time.*;
public class Day58P6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        LocalDate bd = LocalDate.parse(s);
        LocalDate cd = LocalDate.now();
        Period age = Period.between(bd, cd);
        System.out.println("Age: " + age.getYears() + " years, " +
                age.getMonths() + " months, " +
                age.getDays() + " days");
    }
}