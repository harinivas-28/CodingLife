package Coding.java;
import java.util.*;
/*
Mr Robert is working with strings.
He selected two strings S1 and S2, may differ in length,
consists of lowercase alphabets only.

Mr Robert has to update the strings S1, S2 to meet any one of the criteria:
	- All the alphabets in S1 should be less than all the alphabets in S2.
	- All the alphabets in S2 should be less than all the alphabets in S1.
	- Both S1 and S2 should have only one distinct alphabet in it.
To Achieve, one of the criteria, you are allowed to replace any one letter in
the string with any other lowercase alphabet.

Your task is to help Mr Robert, to find the minimum replacements to be done to
update the strings S1 and S2 to meet one of the criteria mentioned above.


Input Format:
-------------
Two space separated strings S1 and S2.

Output Format:
--------------
Print an integer, minimum number of replacements.


Sample Input-1:
---------------
apple ball

Sample Output-1:
----------------
3

Explanation:
------------
Consider the best way to make the criteria true:
- Update S2 to "baaa" in 2 replacements, and Update S1 to "cpple" in 1 replacement
then every alphabet in S2 is less than every alphabet in S1.
        (OR)
- Update S1 to "ppppp" in 3 replacements, then every alphabet in S2 is less
than every alphabet in S1.


Sample Input-2:
---------------
kmit kmec

Sample Output-2:
----------------
2

 */
public class Day48P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        for(char c: s.toCharArray()) f1[c-'a']++;
        for(char c: t.toCharArray()) f2[c-'a']++;
        int m = s.length(), n=t.length();
        int res = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            int v = (m-f1[i])+(n-f2[i]);
            res = Math.min(res, v);
        }
        int[] p1 = new int[27];
        int[] p2 = new int[27];
        for(int i=0;i<26;i++){
            p1[i+1] = p1[i]+f1[i];
            p2[i+1] = p2[i]+f2[i];
        }
        for(int ch=1;ch<26;ch++){
            int c1 = (m-p1[ch])+p2[ch];
            int c2 = (n-p2[ch])+p1[ch];
            res = Math.min(res, Math.min(c1, c2));
        }
        System.out.println(res);
    }
}