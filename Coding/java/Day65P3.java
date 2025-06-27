package Coding.java;
/*
/*
Ravi is playing with strings.Given Three alphabets [a,b,c] , ravi has to
make strings such that no two adjacents alphabets are same.

For example, He can make strings as "ab", "acb", "b" and "cbabcabcb" which
are acceptable.where as the strings "bb", "bcc" and "aabbc" are not acceptable.

Given two integers N and L, Ravi made a list of all acceptable strings of
length N sorted in lexicographical order.

Return the Lth string of this list or return an empty string if there are less
than L acceptable strings of length N.

Input Format:
-------------
Line-1: Two space separated integers N and L.

Output Format:
--------------
Print a string result.


Sample Input-1:
---------------
2 3

Sample Output-1:
----------------
ba

Explanation:
-------------
Strings in lexigraphical order are ab,ac,ba,bc,ca,cb. and 3rd one is ba.


Sample Input-2:
---------------
3 4

Sample Output-2:
----------------
acb

Explanation:
------------
Strings in lexigraphical order are aba,abc,aca,acb,bab....
 */
import java.util.*;
public class Day65P3 {
    private final static char[] set = {'a', 'b', 'c'};
    private static String res = "";
    private static int cnt;
    private static void solve(int n, int l, StringBuilder sb){
        if(sb.length()==n){
            cnt++;
            // System.out.println(sb.toString()+" "+cnt);
            if(cnt==l){
                res = sb.toString();
            }
            return;
        }
        for(char c: set){
            if(sb.isEmpty() || sb.charAt(sb.length()-1)!=c){
                sb.append(c);
                solve(n, l, sb);
                sb.setLength(sb.length()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        cnt = 0;
        solve(n, l, new StringBuilder());
        System.out.println(res);
    }
}
