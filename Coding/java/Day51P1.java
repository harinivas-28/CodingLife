package Coding.java;
import java.util.*;

/*
You are a stealthy archaeologist exploring a circular ring of ancient tombs located deep within a jungle. Each tomb holds a certain number of precious artifacts. However, these tombs are protected by an ancient magical curse: if you disturb two adjacent tombs during the same night, the entire ring activates a trap that seals you in forever.

The tombs are arranged in a perfect circle, meaning the first tomb is adjacent to the last. You must plan your artifact retrieval carefully to maximize the number of artifacts collected in a single night without triggering the curse.

Given an integer array  artifacts  representing the number of artifacts in each tomb, return the   maximum   number of artifacts you can collect without disturbing any two adjacent tombs on the same night.

Example 1:
Input:
2 4 3
Output:
4

Explanation:   You cannot loot tomb 1 (artifacts = 2) and tomb 3 (artifacts = 3), as they are adjacent in a circular setup.

Example 2:
Input:
1 2 3 1
Output:
4

Explanation:   You can loot tomb 1 (1 artifact) and tomb 3 (3 artifacts) without breaking the ancient rule.
Total = 1 + 3 = 4 artifacts.

Example 3:
Input:
1 2 3
Output:
3

Constraints:
-  1 <= artifacts.length <= 100
-  0 <= artifacts[i] <= 1000
*/

public class Day51P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        System.out.println("Recursion + Memoization: "+Math.max(dfs(0, arr, arr.length-2, memo), dfs(1, arr, arr.length-1, memo)));
        System.out.println("Dp: "+dp(arr));
    }
    private static int dp(int[] arr){
        int n = arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.max(arr[0], arr[1]);
        int[] dp1 = new int[n];
        dp1[0] = arr[0];
        dp1[1] = arr[1];
        for(int i=2;i<n-1;i++){
            dp1[i] = Math.max(dp1[i-2]+arr[i], dp1[i-1]);
        }
        int[] dp2 = new int[n];
        dp2[1] = arr[1];
        dp2[2] = arr[2];
        for(int i=3;i<n;i++){
            dp2[i] = Math.max(dp2[i-2]+arr[i], dp2[i-1]);
        }
        return Math.max(dp1[n-2], dp2[n-1]);
    }
    private static int dfs(int idx, int[] arr, int end, int[] memo){
        if(idx>end) return 0;
        if(memo[idx]!=-1) return memo[idx];
        int l = arr[idx] + dfs(idx+2, arr, end, memo);
        int r = dfs(idx+1, arr, end, memo);
        return memo[idx] = Math.max(l, r);
    }
}
