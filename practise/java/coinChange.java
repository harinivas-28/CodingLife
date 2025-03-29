package practise.java;

import java.util.Arrays;
import java.util.Scanner;

public class coinChange {
    private static int recurHelper(int am, int n, int[] a, int idx){
        if(am==0) return 1;
        if(am<0 || idx<0) return 0;
        return recurHelper(am-a[idx], n, a, idx) + recurHelper(am, n, a, idx-1);
    }
    private static int recursive(int n, int[] a){
        return recurHelper(n, n, a, a.length-1);
    }
    private static int rMemoHelper(int am, int n, int[] a,int idx, int[][] memo){
        if(am==0) return memo[am][idx] = 1;
        if(am<0 || idx<0) return 0;
        if(memo[am][idx]!=-1) return memo[am][idx];
        return memo[am][idx] = rMemoHelper(am-a[idx], n, a, idx, memo) + rMemoHelper(am, n, a, idx-1, memo);
    }
    private static int rMemo(int n, int[] a){
        int[][] memo = new int[n+1][a.length];
        for(int[] m: memo) Arrays.fill(m, -1);
        return rMemoHelper(n, n, a, a.length-1,memo);
    }
    private static int dp(int n, int[] a){
        int[][] dp = new int[n+1][a.length+1];
        for(int j=0;j<=a.length;j++) dp[0][j] = 1;
        for(int i=0;i<=n;i++) {
            for (int j = 1; j <= a.length; j++) {
                dp[i][j] = (i - a[j - 1] >= 0 ? dp[i - a[j - 1]][j] : 0) + dp[i][j - 1];
            }
        }
        return dp[n][a.length];
    }
    private static int oneDDp(int n, int[] a){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int coin: a){
            for(int i=coin;i<=n;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for(int i=0;i<m;i++) a[i] = sc.nextInt();
        int r1 = recursive(n, a);
        int r2 = rMemo(n, a);
        int r3 = dp(n, a);
        int r4 = oneDDp(n, a);
        System.out.println(r1+" "+r2+" "+r3+" "+r4);
    }
}
