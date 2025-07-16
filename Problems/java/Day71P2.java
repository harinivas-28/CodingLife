package Problems.java;
/*
A merchant has two types of idols, gold and silver.
He has arranged the idols in the form of m*n grid,
	- the gold idols are represented as 1's
	- the silver idols are represented as 0's.

Your task is to find the longest consecutive arrangement of gold idols,
The arrangement can be either horizontal, vertical, diagonal or
anti-diagonal, but not the combination of these.


Input Format:
-------------
Line-1: Two space separated integers m and n, grid size.
Next m lines : n space separated integers, arrangement of idols.

Output Format:
--------------
Print an integer, longest arrangement of gold idols.


Sample Input:
------------
4 5
1 0 1 1 1
0 1 0 1 0
1 0 1 0 1
1 1 0 1 1

Sample Output:
-------------
4

Sample Input:
-------------
5 7
1 1 1 1 0 1 0
0 1 1 1 0 0 0
0 1 1 1 0 1 1
1 1 0 0 1 1 1
1 0 0 0 0 1 1

Sample Output
-------------
5

NOTE:
Solve this program using DP approach only.

 */
import java.util.Scanner;
public class Day71P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] g = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                g[i][j] = sc.nextInt();
            }
        }
        int[][][] dp = new int[m][n][4];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1){
                    dp[i][j][0] = (j>0 ? dp[i][j-1][0] : 0)+1;
                    dp[i][j][1] = (i>0 ? dp[i-1][j][1]: 0)+1;
                    dp[i][j][2] = (i>0 && j>0 ? dp[i-1][j-1][2]: 0)+1;
                    dp[i][j][3] = (i>0 && j<n-1 ? dp[i-1][j+1][3] :0)+1;
                    res = Math.max(res, Math.max(Math.max(dp[i][j][0], dp[i][j][1]),
                            Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        System.out.println(res);
    }
}
// BRUTE FORCE (The solution recalculates the same lines repeatedly (O(m * n * max(m,n)) time).
/*
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] g = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                g[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1){
                    res = Math.max(res, f(i, j, g));
                    res = Math.max(res, d(i, j, g));
                    res = Math.max(res, diag(i, j, g));
                    res = Math.max(res, anti(i, j, g));
                }
            }
        }
        System.out.println(res);
    }
    static int f(int i, int j, int[][] g){
        int cnt = 0;
        while(j<g[0].length && g[i][j++]==1){cnt++;}
        return cnt;
    }
    static int d(int i, int j, int[][] g){
        int cnt = 0;
        while(i<g.length&& g[i++][j]==1){cnt++;}
        return cnt;
    }
    static int diag(int i, int j, int[][] g){
        int cnt = 0;
        while(i<g.length&&j<g[0].length&&g[i++][j++]==1){cnt++;}
        return cnt;
    }
    static int anti(int i, int j, int[][] g){
        int cnt = 0;
        while(i<g.length&&j>=0&&g[i++][j--]==1){cnt++;}
        return cnt;
    }
}
 */