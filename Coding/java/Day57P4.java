package Coding.java;
/*

Problem: 
Write Java code to identify if given two strings are Anagrams 
(strings that contain same set of alphabets)

Sample Input: 
-------------
listen silent

Sample Output: 
--------------
true

*/
import java.util.*;
public class Day57P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs= sc.nextLine().split(" ");
        System.out.println(solve(strs[0], strs[1]));
    }
    private static boolean solve(String a, String b){
        int[] f1 = new int[26];
        for(char c: a.toCharArray()){
            f1[c-'a']++;
        }
        int[] f2 = new int[26];
        for(char c: b.toCharArray()){
            f2[c-'a']++;
        }
        return Arrays.equals(f1, f2);
    }
}
