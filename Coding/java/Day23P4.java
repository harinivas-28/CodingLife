package Coding.java;
import java.util.*;
/*
You can call two strings X and Y are friendly strings, 
if you can swap two letters in X, so the result is equal to Y.

The condition to swap the letters is as follows:
	Swapping letters is defined as taking two indices i and j (0-indexed) 
	such that i != j and swapping the characters at A[i] and A[j] . 
	For example, swapping at indices 0 and 2 in "abcd" results in "cbad" .

You are given two strings X and Y of lowercase letters, 
return true if X and Y are friendly strings, otherwise return false.

Input Format:
-------------
Two space separated Strings X and Y

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
abcde bacde

Sample Output-1:
----------------
true

Sample Input-2:
---------------
abcde abcde

Sample Output-2:
----------------
false

*/
public class Day23P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();
        if(a.length()!=b.length()){
            System.out.println(false);
            return;
        }
        Set<Character> set = new HashSet<>();
        if(a.equals(b)){
            for(char c: a.toCharArray()){
                if(set.contains(c)){
                    System.out.println(true);
                    return;
                }
                set.add(c);
            }
            System.out.println(false);
            return;
        }
        int cnt = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                set.add(a.charAt(i));
                set.add(b.charAt(i));
                cnt++;
            }
        }
        System.out.println(cnt==2 && set.size()==2);
    }
}