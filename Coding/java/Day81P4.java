package Coding.java;
/*
Akhila is given a string S, Where S conatins only [aeiou] letters.
A special subsequence defined as a sequence of letters derived from S
that contains all five vowels in order. It means a special subsequence
will have one or more a's followed by the one or more e's followed by
one or more i's followed by one or more o's followed by one or more u's.

Your task is to help Akhila to return the length of the longest special
subsequence in S.

Input Format:
-------------
Your code should be read input from the given attached file as a string (no line breaks)

Output Format:
--------------
An integer, the length of longest subsequence.

Sample input-1:
---------------
aeeiooua

Sample Output-1:
----------------
7

Explanation:
------------
Given S = "aeeiooua", then "aeiou" and "aeeioou" are special subsequences
but "aeio" and "aeeioua" are not


Sample input-2:
---------------
aeiaaioooaauuuaeiou

Sample Output-2:
----------------
11

 */
import java.util.Scanner;
public class Day81P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // int[] cnt = new int[5];
        int a =0, e=0, i=0, o=0, u=0;
        for(char c: s.toCharArray()){
            if(c=='a') a++;
            else if(c=='e' && a>0){
                e = Math.max(e, a)+1;
            } else if(c=='i' && e>0){
                i = Math.max(i, e)+1;
            } else if(c=='o' && i>0){
                o = Math.max(i, o)+1;
            } else if(c=='u' && o>0){
                u = Math.max(u, o)+1;
            }
        }
        System.out.println(u);
    }
}
