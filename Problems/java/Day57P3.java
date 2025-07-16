package Problems.java;
/*

Write a Java code to return the length of longest sub-string without repeating 
characters

Sample Input: 
-------------
abcabcbb

Sample Output: 
--------------
3


*/
import java.util.*;

public class Day57P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Set<Character> set = new HashSet<>();
        int l = 0, res = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            while(set.contains(c)){
                l++;
                set.remove(c);
            }
            set.add(c);
            res = Math.max(res, r-l+1);
        }
        System.out.println(res);
    }
}