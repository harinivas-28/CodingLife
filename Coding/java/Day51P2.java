package Coding.java;
import java.util.*;
/*
You are a robot explorer navigating a vast digital maze stored as a string of
digits. Each digit or pair of digits on the path represents a movement
instruction, which translates to a specific direction using the following map:

"1" → Move 'A'

"2" → Move 'B'

...

"26" → Move 'Z'

However, the maze has tricky encoding rules. Sometimes a single digit can be
read alone, and sometimes two digits together form a valid move — but not every
combination is valid.

For example, "05" is invalid, while "5" is fine. Your robot
can only navigate using valid instruction steps, and you must find how much
unique navigation sequences the robot can follow to reach the end of the maze.

Given the string s of digits, determine the total number of distinct ways the
robot can interpret and follow the path from start to end without making an
invalid move.

If no valid navigation is possible, return 0.


Input Format:
-------------
A string s.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
123

Sample Output-1:
----------------
3

Explanation:
------------
123 can be converted as: ABC, LC, AW


Sample Input-2:
---------------
326

Sample Output-2:
----------------
2

Explanation:
------------
326 can be converted as: CBF, CZ
*/

public class Day51P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        System.out.println("Recursion + Memoization: "+remo(0, s, memo));
        System.out.println("Dp: "+dp(s));
    }
    private static int dp(String s){
        int[] dp = new int[s.length()+1];
        dp[0] = dp[1] = 1;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)!='0') dp[i] += dp[i-1];
            if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<'7')){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
    private static int remo(int idx, String s, int[] memo){
        if(idx==s.length()) return 1;
        if(s.charAt(idx)=='0') return 0;
        if(memo[idx]!=-1) return memo[idx];
        int cnt = remo(idx+1, s, memo);
        if(idx+1<s.length()){
            if(s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<'7'))
                cnt+=remo(idx+2, s, memo);
        }
        return memo[idx] = cnt;
    }
}
