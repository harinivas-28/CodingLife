package Problems.java;
import java.util.*;
/*
Sharath is playing a game where there are N levels. Inorder to win the game he has to reach Nth level.
The rule book explains "In one step you can either cross one level or two levels".
Return the number of distinct possible ways to win the game.
Constraints:
    1 <= N <= 45
Input Format:
-------------
Line-1: An Integer N represents number of levels.

Output Format:
--------------
Print an integer.

Sample Input-1:
---------------
2

Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.

Sample Input-2:
---------------
4

Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4
*/
public class Day50P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        System.out.println("Recursion + Memoization: "+dfs(0, n, memo));
        System.out.println("Dp: "+dp(n));
    }
    private static int dp(int n){
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    private static int dfs(int idx, int n, int[] memo){
        if(idx==n) return 1;
        if(idx>n) return 0;
        if(memo[idx]!=-1) return memo[idx];
        return memo[idx] = dfs(idx+1, n, memo) + dfs(idx+2, n, memo);
    }
}


