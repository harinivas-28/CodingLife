package practise.java;

import Coding.java.ArrayUtils;

import java.util.*;

/*
Problem Description
In this problem, you are given two strings s1 and s2. Your task is to find the shortest contiguous substring in s1 such that the entire string s2 is a subsequence of that substring. A subsequence is a sequence that can be derived from the other sequence by deleting some or no elements without changing the order of the remaining elements.

For example, if s1 is "abcdebdde" and s2 is "bde", you have to find the shortest part of s1 that contains all the characters in s2 in the same order.

Here are the conditions you need to satisfy:

If no such window exists, return an empty string "".
If there are multiple substrings of s1 that satisfy the condition, return the one with the left-most starting index.
In the example given, the minimum window in s1 where s2 is a subsequence is "bcde".
 */
public class minimumWindowSubsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = (j==1) ? i: dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int minLen = Integer.MAX_VALUE;
        int st = -1;
        for(int i=1;i<=m;i++){
            if(dp[i][n]!=-1){
                int len = i-dp[i][n]+1;
                if(len<minLen){
                    minLen = len;
                    st = dp[i][n]-1;
                }
            }
        }
//        Arrays.stream(dp).forEach(x->System.out.println(Arrays.toString(x))); DEBUG
        String res = st!=-1 ? a.substring(st, st+minLen) : "";
        System.out.println(res);
    }
}
