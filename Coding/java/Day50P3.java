package Coding.java;
import java.util.*;
/*
Pavan is playing a game where there are N levels and each level has some points in it. level[i] is the points to spend on ith level(0-indexed) to move forward. Inorder to win the game he has to reach the top level.

The rule book explains "In one step you have to spend the points given on the present level and you can either cross one level or two levels forward".

Return the minimum number of points to spend to win the game.

Note:You are allowed to start at either level-0 or level-1.

Constraints:

    2 <= N <=1000
    0 <= level[i] <= 999

Input Format:
-------------
Line-1: An Integer N represents number of levels.
Line-2: N space seperated integers represents the points in each level.

Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
3
20 30 40

Sample Output-1:
----------------
30

Explanation:
------------
He can start at index-1 by spending points 30 and he can win.

Sample Input-2:
---------------
7
2 3 50 2 2 50 2

Sample Output-2:
----------------
9

Explanation:
------------
Start at index-1:
  -Spend 3 points and reach to index-3
  -Spend 2 points and reach to index-4
  -Spend 2 points and reach to index-6
  -Spend 2 points and he wins.

  */
public class Day50P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        System.out.println("Recursion + Memoization: "+solve(arr, memo));
        System.out.println("DP: "+dp(arr));
    }
    private static int dp(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for(int i=2;i<n;i++){
            dp[i]= arr[i]+ Math.min(dp[i-1], dp[i-2]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
    private static int solve(int[] arr, int[] memo){
        return Math.min(dfs(0,arr, memo), dfs(1, arr, memo));
    }
    private static int dfs(int idx, int[] arr, int[] memo){
        if(idx>=arr.length) return 0;
        if(memo[idx]!=-1) return memo[idx];
        int left = arr[idx] + dfs(idx+1, arr, memo);
        int right = arr[idx] + dfs(idx+2, arr, memo);
        return memo[idx] = Math.min(left, right);
    }
}

