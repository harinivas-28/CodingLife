package CompanyQuestions;
import java.util.*;
/*
Question 2 – LCS With Palindrome

Sam loves palindromes. One day, his father comes and gives him two strings. Sam is interested in finding the length of the longest common palindrome subsequence and wants your help with it.

Input Specification:
-------------------
 input1: First string which is given by his father
 input2: Second string which is given by his father

Output Specification:

 Return the length of the longest common palindrome subsequence.

Example 1:
----------
input1: adfa
input2: aagh

Output: 2


Explanation:
------------
The only common palindrome subsequence is aa so length is 2.

Example 2:
----------
input1: acbda
input2: fgaba
Output: 3


Explanation: The longest common palindrome subsequence is aba so length is 3.
 */
public class LCSWithPalindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=m, j=n;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                } else j--;
            }
        }
        System.out.println("LCS: "+sb.toString());
        String lcps = gen(sb.toString());
        String lcps1 = manachers(sb.toString());
        System.out.println("LCPS: "+lcps);
        System.out.println("Length: "+lcps.length());
    }
    private static String gen(String s){
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);
            int len = Math.max(odd, even);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }
    private static int expand(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i--)==s.charAt(j++)){}
        return j-i-1;
    }
    private static String manachers(String s){
        if(s==null || s.isEmpty()) return "";
        StringBuilder t = new StringBuilder("#");
        for(char c: s.toCharArray()){
            t.append(c).append("#");
        }
        String ts = t.toString();
        int len = ts.length();
        int[] p = new int[len];
        int c = 0, r=0;
        for(int i=0;i<len;i++){
            int mirror = 2*c-i;
            if(i<r){
                p[i] = Math.min(r-i, p[mirror]);
            }
            while(i+p[i]+1<len && i-p[i]-1>0 && ts.charAt(i+p[i]+1)==ts.charAt(i-p[i]-1)){
                p[i]++;
            }
            if(i+p[i]>r){
                c = i;
                r = i+p[i];
            }
        }
        int maxLen =0, ci = 0;
        for(int i=0;i<len;i++){
            if(p[i]>maxLen){
                maxLen = p[i];
                ci = i;
            }
        }
        int st = (ci-maxLen)/2;
        return s.substring(st, st+maxLen);
    }
}

