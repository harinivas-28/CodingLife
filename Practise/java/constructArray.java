package Practise.java;
import java.util.*;
/*
 * Construct the Array
 * Your goal is to find the number of ways to construct an array such that consecutive positions contain different values.
 *
 * Specifically, we want to construct an array with `n` elements such that each element is between `1` and `k`, inclusive. 
 * We also want the first and last elements of the array to be `first` and `last`.
 *
 * Given `n`, `k`, `first`, and `last`, find the number of ways to construct such an array. Since the answer may be large, 
 * return it modulo `1_000_000_007`.
 *
 * For example, for `n = 4`, `k = 3`, `first = 1`, `last = 3`, there are 4 ways, as shown here:
 * [1, 2, 3, 3], [1, 3, 2, 3], [1, 2, 2, 3], [1, 3, 1, 3]
 *
 * Complete the function countArrays which takes input `n`, `k`, `first`, and `last`. Return the number of ways to construct 
 * the array such that consecutive elements are distinct.
 *
 * Constraints:
 * 1 <= n <= 50
 * 1 <= k <= 50
 * 1 <= first, last <= k
 *
 * Subtasks:
 * For 50% of the maximum score, 1 <= n, k <= 20
 *
 * Sample Input:
 * n = 4, k = 3, first = 1, last = 3
 *
 * Sample Output:
 * 4
 *
 * Explanation:
 * Refer to the example arrays in the description.
 */
public class constructArray {
    private final static int MOD = 1_000_000_007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a = 1, b = sc.nextInt();
        sc.close();
        System.out.println("Recursive: "+countArrays(n, k, a, b));
    }
    private static int countArrays(int n, int k, int first, int last){
        if(n==1){
            return first==last?1:0;
        }
        if(n==2){
            return first==last?0:1;
        }
        int ways = 0;
        for(int val=1;val<=k;val++){
            if(val==first) continue;
            ways = (ways + countArrays(n-1, k, val, last))%MOD;
        }
        return ways;
    }
}
