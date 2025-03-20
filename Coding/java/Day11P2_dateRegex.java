package Coding.java;

import java.util.*;
import java.util.regex.*;

public class Day11P2_dateRegex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();
        Set<String> set = new HashSet<>();
        for(int i=0;i<=l.length()-10;i++){
            String sub = l.substring(i, i+10);
            if(sub.matches("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-[0-9]{4}")){
                set.add(sub.substring(sub.length()-4));
            }
        }
        System.out.println(set.size());
        Set<String> res = extractYears(l);
        System.out.println(res);
        sc.close();
    }

    public static Set<String> extractYears(String input) {
        Set<String> years = new HashSet<>();
        Pattern pattern = Pattern.compile("\\d{2}-\\d{2}-(\\d{4})"); // Simplified regex
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            years.add(matcher.group(1)); // Extract the year (group 1)
        }
        return years;
    }
}
