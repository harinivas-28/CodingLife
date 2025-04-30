package Coding.java;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Raju is organizing a friendly competition where each participant submits a 
secret code representing their choices on a series of questions which are 
answered as yes or no. Each code is a number, and when you convert it to binary, 
every digit indicates a specific answer: 0 for "no" and 1 for "yes." 

The uniqueness of each participant's code lies in how much it differs from another's. 
To measure this, you compare two codes digit by digit and count the number of 
positions where their answers disagree.

Given an array of these integer-encoded codes, help Raju to calculate the total 
sum of these disagreement counts for every possible pair of participants.

Example 1:
----------
Input: 
5 13 3
Output: 
6

Explanation:
Converting to binary (using four bits for clarity):

5 is 0101
13 is 1101
3 is 0011
Now, compare each pair and count the number of positions with different digits:

Comparing 5 (0101) and 13 (1101) gives 1 differences.
Comparing 5 (0101) and 3 (0011) gives 2 differences.
Comparing 13 (1101) and 3 (0011) gives 3 differences.
Total differences = 1 + 2 + 3 = 6.

 */
public class Day33P3_Bits {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                res+=diff(arr[i], arr[j]);
            }
        }
        System.out.println(res);
        sc.close();
    }
    private static int diff(int a, int b){
        int cnt = 0, c = a^b;
        while(c!=0){
            cnt+=(c&1);
            c>>=1;
        }
        return cnt;
    }
}