package Coding.java;
import java.util.*;
/*
Govind is playing with strings.
He is given two strings S1 and S2, He has to find if each character in S1 can match a word in S2 uniquely or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and distinct non-empty word in S2, 
where each non-empty word in S2 also has a corresponding letter in S1.

Return true, if S1 can match S2 completely.
Otherwise false.

Note: You may assume S1 and S2 contains only lowercase letters, S2 contains whitespace also.

Input Format:
-------------
Line-1 -> A string S1, single word
Line-2 -> A string S2, group of space separated words.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
baba
cat rat cat rat

Sample Output-1:
----------------
true

Sample Input-2:
---------------
baba
cat rat rat cat

Sample Output-2:
----------------
false
*/
public class Day24P5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.nextLine();
        String[] l = sc.nextLine().split("\\s+");
        sc.close();
        if(s.length()!=l.length){
            System.out.println(false);
            return;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String curr = l[i];
            if(map1.containsKey(c)){
                if(!map1.get(c).equals(curr) || map2.get(curr)!=c){
                    System.out.println(false);
                    return;
                }
            }
            map1.put(c, curr);
            map2.put(curr, c);
        }
        System.out.println(true);
    }
}