package Problems.java;
/*
Sumanth has an idea to calculate the ABD value of a string.
An ABD value is defined as the absolute difference between
the most occurrence count of a character and the least occurrence count
of another character in the given string.

Sumanth is given a string S,
He wants to find out, the sum of ABD values of all the substrings of S,
where ABD > 0.

Your task is to help Sumanth to find total ABD value of substrings of S.

Input Format:
-------------
A String S

Output Format:
--------------
Print an integer, sum of ABD of all the strings of S


Sample Input-1:
---------------
abbcc

Sample Output-1:
----------------
5

Explanation:
------------
The substrings with non-zero ABD are as follows:
Substring and ABD value -> "abb"-1,"abbc"-1,"abbcc"-1,"bbc"-1,"bcc"-1
The total sum of ABD is, 5


Sample Input-2:
---------------
abcbabc

Sample Output-2:
----------------
15

Explanation:
------------
The substrings with non-zero ABD are as follows:
substring and ABD value -> "abcb"-1,"abcba"-1,"abcbab"-2,"abcbabc"-1,"bcbabc"-2
"bcbab"-2, "bcba"-1, "bcb"-1, "cbab"-1,"cbabc"-1,"bab"-1, "babc"-1.
The total sum of ABD is, 15
*/
import java.util.*;
public class Day84P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0, l =3;
        while(l<=s.length()){
            res += solve(s, l);
            l++;
        }
        System.out.println(res);
    }
    private static int solve(String s, int l){
        int[] f = new int[26];
        int i=0, sum=0;
        while(i<s.length()){
            f[s.charAt(i)-'a']++;
            if(i>=l-1){
                int max = Arrays.stream(f).max().getAsInt();
                int min = Arrays.stream(f).filter(x->x>0).min().getAsInt();
                sum += max-min;
                f[s.charAt(i-l+1)-'a']--;
            }
            i++;
        }
        return sum;
    }
}
