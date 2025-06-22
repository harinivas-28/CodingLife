package PYQ;
import java.util.*;
/*
DARWIN BOX - 02
Problem: Minimum Value from All Operator Combinations
Given an array of n integers, you must place an operator (+, -, or *) between each pair of numbers in all possible ways (without using parentheses and ignoring standard operator precedence — evaluate strictly left to right).

Your task is to find and output the minimum result obtainable from all possible combinations.

Input
The first line contains an integer n (2 ≤ n ≤ 10).

The second line contains n integers a₁, a₂, ..., aₙ (-9 ≤ aᵢ ≤ 9).

Output
Output a single integer: the minimum value obtainable by evaluating all valid expressions formed by inserting operators between the numbers and evaluating left to right.

Note
No operator precedence: evaluate strictly left to right. For example, for 2 * 3 + 4, calculate (2 * 3) + 4 = 10.

Example Input
3
2 3 4
Example Output
-5
Minimum value among these is -5.
 */
public class MinOperatorExpression {
    private static int fun(int idx,int val, int[] arr){
        if(idx==arr.length) return val;
        int plus = fun(idx+1, val+arr[idx], arr);
        int minus = fun(idx+1, val-arr[idx], arr);
        int mul = fun(idx+1, val*arr[idx], arr);
        return Math.min(plus, Math.min(minus, mul));
    }
    private static void solve(Scanner sc){
        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(fun(1, arr[0], arr));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            solve(sc);
        }
    }
}
