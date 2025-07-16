package Problems.java;
import java.util.*;

/*
Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

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
public class Day26P1_Bt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();
        Map<Character, String> map = new HashMap<>();
        boolean res = bT(0,0, s1, s2, map);
        System.out.println(res);
    }
    private static boolean bT(int i,int j, String s1, String s2, Map<Character, String> map){
        if(i==s1.length() && j==s2.length()) return true;
        if(i>=s1.length() || j>=s2.length()) return false;
        char c = s1.charAt(i);
        if(map.containsKey(c)){
            String t = map.get(c);
            // if(j+t.length()<=s2.length() && t.equals(s2.substring(j, j+t.length()))){
            if(s2.startsWith(t, j)) {
                return bT(i+1, j+t.length(), s1, s2, map);
            }
            return false;
        }
        for(int k=j+1;k<=s2.length();k++){
            map.put(c, s2.substring(j, k));
            if(bT(i+1, k, s1, s2, map)){
                return true;
            }
        }
        map.remove(c);
        return false;
    }
}
/*
 * public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();
        int m = s1.length();
        int n = s2.length();
        if(n%m!=0){
            System.out.println(false);
            return;
        }
        int sz = n/m;
        List<String> l = new ArrayList<>();
        for(int i=0;i<n;i+=sz) {
            l.add(s2.substring(i, i+sz));
        }
        System.out.println(l);
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        for(int i=0;i<m;i++) {
            char c = s1.charAt(i);
            if(m1.containsKey(c)){
                String temp = m1.get(c);
                if(!temp.equals(l.get(i))){
                    System.out.println(false);
                    return;
                }
            }
            m1.put(c, l.get(i));
            m2.put(l.get(i), c);
        }
        System.out.println(true);
    }
 */