package PYQ;
import java.util.*;
/*
Problem: Max Cyclic Value with XOR, ADD, OR
You are given an array of n integers.
Your task is to:

Pick any index as the starting point.

Compute a value by traversing all array elements cyclically, applying in order:

XOR with the next element,

then ADD the next element,

then OR the next element,

repeat this cycle: XOR → ADD → OR → XOR → ADD → OR … until every element has been used exactly once.

You must consider all possible starting points and compute all possible values.
Your goal is to find:

The maximum value among all possible cycles.

Whether this maximum value is EVEN or ODD.

Input Format
The first line contains an integer n (1 ≤ n ≤ 1000).

The second line contains n integers a1, a2, ..., an (0 ≤ a[i] ≤ 10^9).

Output Format
Print two values:

The maximum value obtained,

and whether it is "Even" or "Odd" (without quotes).

Example Input
4
5 2 7 3
Example Output
21 Odd
Explanation
Possible cycles (one per starting index):

Start at index 0 → use XOR, ADD, OR in order as you move through the circular array.

Similarly for index 1, 2, and 3.

Compute each cycle’s result and find the maximum.

Key Points
The operations repeat: XOR → ADD → OR → XOR → ADD → OR ...

You use each array element exactly once.

The array is circular, so after the last index, wrap to the start.

For each starting index, try this full cycle and record the result.

Output the maximum and whether it is even or odd.
 */
public class MaxCycleValue {
    private static void solve(Scanner sc){
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int maxi = 0;
        for(int i=0;i<n;i++){
            int val = arr[i];
            int op = 0;
            maxi = Math.max(val, maxi);
            for(int j=i+1;;j++){
                j%=n;
                if(j==i) break;
                switch (op) {
                    case 0: val ^= arr[j]; break;
                    case 1: val += arr[j]; break;
                    case 2: val |= arr[j]; break;
                }
                op = (op+1)%3;
                maxi = Math.max(val, maxi);
            }
        }
        System.out.println(maxi+" "+(maxi%2==0 ? "Even":"Odd"));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }
}
