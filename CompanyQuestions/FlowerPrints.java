package CompanyQuestions;
import java.util.*;
/*
Question 1 – Flower Prints
Emma owns a boutique and decides to design a new gown. She wants to design the gown by printing some flowers over it.
There are X printing blocks in total, and each block consists of some number of flowers.

your task is to Help Emma find and return the maximum number of flowers that cannot be printed on the gown, using the X printing blocks.

Any block can be used any number of times.

Note: The number of flowers on any two blocks is co-prime.

Input Specification:

 input1: An integer value X, representing the total number of blocks available
 input2: An integer array representing the number of flowers on each printing block

Output Specification:

 Return an integer value representing the maximum number of flowers that cannot be printed on the gown.

Example 1:
----------
input1: 2
input2: [3, 5]

Output: 7

Explanation:
------------
Emma has two blocks: one of 3 flowers, one of 5 flowers. She cannot print 1, 2, 4, and 7 flowers using the given blocks but can print any higher integral.

Since 7 is the maximum number of flowers that cannot be printed, therefore 7 is returned as the output.

Example 2:
----------
input1: 2
input2: [2, 5]

Output: 3

Explanation:
------------
Emma has two blocks:one has 2 flowers and the other has 5 flowers.she cannot print 1 flower and 3 flowers using these blocks but can print any higher integral.
since 3 is the maximum number of flowers that cannot be printed.therefore 3 is returned as output.
 */
public class FlowerPrints {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        boolean[] dp = new boolean[1000];
        dp[0] = true;
        for(int num: nums){
            for(int i=num;i<dp.length;i++){
                if(dp[i-num]) dp[i] = true;
            }
        }
        int m = 0;
//        System.out.println(Arrays.toString(dp));
        for(int i=0;i<dp.length;i++){
            if(!dp[i]) m = i;
        }
        System.out.println(m);
    }
}
