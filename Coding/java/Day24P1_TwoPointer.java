package Coding.java;
import java.util.*;
/*
Rohan has a habit of writing a word in reverse as R and then checks whether R is same as Original word W. If R is not same as W, he can remove only one character from R to make it as W.
Print 'true', if Rohan makes R equals W, Otherwise print 'false'.

Input Format:
-------------
Line-1: A string represents a word.

Output Format:
--------------
return a boolean result.

Sample Input-1:
---------------
bcba

Sample Output-1:
----------------
true

Explanation:
------------
By removing charcter 'a', we will get the word in reverse is also same.

Sample Input-2:
---------------
abcd

Sample Output-2:
----------------
false

Explanation:
-------------
There is no possibility to make the reverse is also same.

*/
public class Day24P1_TwoPointer {
    public static void main(String[] args){
        // abbaba
        // ababba
        Scanner sc = new Scanner(System.in);
        char[] s = sc.next().toCharArray();
        sc.close();
        int i=0, j=s.length-1, cnt=0;
        while(i<j && cnt<=1){
            if(s[i]!=s[j]){
                cnt++;
                if(j>0 && s[i]==s[j-1]) j--;
                else if(i<s.length-1 && s[i+1]==s[j]) i++;
            }
            i++;
            j--;
        }
        System.out.println(cnt<=1);
    }
}