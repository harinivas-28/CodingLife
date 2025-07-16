package Problems.java;


/*
Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection),
i.e. a function which relates each letter in string S1 to a separate and
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise, false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
 */
import java.util.*;

public class Day74P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        Map<Character, String> map = new HashMap<>();
        System.out.println(solve(0, 0, s1, s2, map));
    }
    private static boolean solve(int i, int j, String s1, String s2, Map<Character, String> map){
        if(i==s1.length() && j==s2.length()) return true;
        if(i>=s1.length() || j>=s2.length()) return false;
        char c = s1.charAt(i);
        if(map.containsKey(c)){
            String k = map.get(c);
            if(s2.startsWith(k, j)){
                return solve(i+1, j+k.length(), s1, s2, map);
            }
            return false;
        }
        for(int x=j+1;x<=s2.length();x++){
            map.put(c, s2.substring(j, x));
            if(solve(i+1, x, s1, s2, map)){
                return true;
            }
        }
        map.remove(c);
        return false;
    }
}
