package Practise.java;
import java.util.*;

import Problems.java.ArrayUtils;
public class knapsack {
    /*
     * Inputs:
        weights[] = {2, 3, 4, 5}
        values[] = {3, 4, 5, 6}
        capacity = 5
       Expected Output:
        Maximum value: 7
     */
    /*
     * Inputs: 
        int[] weights = {1, 3, 4, 5, 2, 6, 2, 7, 8, 9};
        int[] values  = {1, 4, 5, 7, 3, 8, 4, 9, 10, 11};
        int capacity = 15;
       Expected Output:
        Maximum value: 36
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] wts = ArrayUtils.parseIntArray(sc.nextLine());
        int[] vals = ArrayUtils.parseIntArray(sc.nextLine());
        int limit = sc.nextInt();
        // RECURSION
        int res = recurse(wts, vals, limit, 0, 0, 0);
        // RECURSION + MEMOIZATION
        int[][] memo = new int[wts.length][limit+1];
        for(int[] x: memo)
            Arrays.fill(x, -1);
        int res2 = recurseMemo(wts, vals, limit, 0, 0, 0, memo);
        // ITERATIVE DP
        int res3 = useDp(wts, vals, limit);
        // ITERATIVE 1D DP
        int res4 = use1dDp(wts, vals, limit);

        System.out.println("Recursive: "+res);
        System.out.println("Recursive + Memoization: "+res2);
        System.out.println("Dynamic Programming: "+res3);
        System.out.println("1D-Dynamic Programming: "+res4);
        sc.close();
    }
    private static int use1dDp(int[] wts, int[] vals, int cap){
        int[] dp = new int[cap+1];
        for(int x=0;x<wts.length;x++){
            for(int w=cap;w>=wts[x];w--){
                dp[w] = Math.max(vals[x] + dp[w - wts[x]], dp[w]);
            }
        }
        return dp[cap];
    }
    private static int useDp(int[] wts, int[] vals, int capacity){
        int[][] dp = new int[wts.length+1][capacity+1];
        for (int i = 1; i <= wts.length; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (wts[i-1] <= w) { 
                    dp[i][w] = Math.max(vals[i-1] + dp[i-1][w-wts[i-1]], dp[i-1][w]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[wts.length][capacity];
        // DP EXPLANATION -> EOF
    }
    private static int recurse(int[] wts, int[] vals, int limit, int currWt, int currVal, int idx){
        if (currWt > limit) return 0; 
        if (idx >= wts.length) return currVal; 
        int include = 0;
        if (currWt + wts[idx] <= limit) {
            include = recurse(wts, vals, limit, currWt + wts[idx], currVal + vals[idx], idx + 1);
        }
        int exclude = recurse(wts, vals, limit, currWt, currVal, idx + 1);

        return Math.max(include, exclude);
    }
    private static int recurseMemo(int[] wts, int[] vals, int limit, int currWt, int currVal, int idx, int[][] memo){
        if (currWt > limit) return 0; 
        if (idx >= wts.length) return currVal; 
        if(memo[idx][currWt]!=-1) return memo[idx][currWt];
        int include = 0;
        if (currWt + wts[idx] <= limit) {
            include = recurse(wts, vals, limit, currWt + wts[idx], currVal + vals[idx], idx + 1);
        }
        int exclude = recurse(wts, vals, limit, currWt, currVal, idx + 1);

        return memo[idx][currWt] = Math.max(include, exclude);
    }
}

/*
private static int useDp(int[] wts, int[] vals, int capacity) {
    // Create a 2D DP table where:
    // dp[i][w] represents the maximum value that can be achieved using the first 'i' items
    // with a knapsack capacity of 'w'.
    int[][] dp = new int[wts.length + 1][capacity + 1];

    // Iterate over all items (1-based index for DP table)
    for (int i = 1; i <= wts.length; i++) {
        // Iterate over all possible capacities from 1 to the given capacity
        for (int w = 1; w <= capacity; w++) {
            // Check if the current item's weight can fit in the current capacity
            if (wts[i - 1] <= w) { 
                // Option 1: Include the current item
                // Add the value of the current item (vals[i-1]) to the maximum value achievable
                // with the remaining capacity (w - wts[i-1]).
                int include = vals[i - 1] + dp[i - 1][w - wts[i - 1]];

                // Option 2: Exclude the current item
                // Take the maximum value achievable without including the current item.
                int exclude = dp[i - 1][w];

                // Take the maximum of the two options
                dp[i][w] = Math.max(include, exclude);
            } else {
                // If the current item's weight exceeds the current capacity,
                // we cannot include it. The value remains the same as the previous row.
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    // The bottom-right cell of the DP table contains the maximum value
    // that can be achieved with all items and the given capacity.
    return dp[wts.length][capacity];
}
 */
