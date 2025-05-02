package Coding.java;
import java.util.*;
/*
Grand Test: MAY 5th
Pattern = Coding questions + query + mcq
Coding questions -> {
    What ever we completed till now
}
MCQs -> {Java OCA, OS, DBMS upto joins, DDL , DML, DCL, TCL, Normalization, NOTE: No CN}
DSA -> Everything in mcqs(LinkedList, Trees, Except Graphs, Algorithms that we covered(Sliding Win, Bt, Bs...))
Queries -> Upto Joins(MySQL)
1 -> Greedy
1 -> Bt
1 -> DFS/BFS (Regular/Tree)
*/
/*
 * You are given an array ar[], find the closed subsequence in which we subtract 
the largest and smallest element in the subsequence, the result is equal to 1.

Your task is to return the length of its greatest closed subsequence among all
its possible subsequences.

A subsequence of array is a sequence that can be taken from the array by removing 
some or no elements without changing the order of the remaining elements.

Input Format:
-------------
Line-1: An integer n number of elements.
Line-2: n space separated integers represent the elements.
 
Output Format:
--------------
Print an integer.
 
Constraints:
 1 <= n <= 10^4
 -10^4 <= ar[i] <= 10^4

 
Sample Input-1:
---------------
6
4 3 5 2 6 3
 
Sample Output-1:
----------------
3

Explanation:
------------
Subsequence is [4,3,3]
 
Sample Input-2:
---------------
7
20 19 19 29 37 35 19

Sample Output-2:
----------------
4

Explanation:
------------
Subsequence is [20 19 19 19]

 */
// NOTE: Try to use MAP
// DFS: 2^N
// Sorting: N LogN
// Map: N
public class Day35P1 {
    static int res = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        // dfs(arr, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        // System.out.println(res);
        System.out.println(sorting(arr));
        sc.close();
    }
    @SuppressWarnings("unused")
    private static void dfs(int[] arr, int idx, int max, int min, int sz){
        if(idx==arr.length){
            if(max-min==1){
                res = Math.max(res, sz);
            }
            return;
        }
        if(max-min==1) res = Math.max(res, sz);
        dfs(arr, idx+1, Math.max(max, arr[idx]), Math.min(min, arr[idx]), sz+1);
        dfs(arr, idx+1, max, min, sz);
    }
    private static int sorting(int[] arr){
        Arrays.sort(arr);
        int i=0, j=1, ans = 0;
        while(j<arr.length){
            int diff = Math.abs(arr[j]-arr[i]);
            if(diff<=1){
                if(diff==1){
                    ans = Math.max(ans, j-i+1);
                }
                j++;
            } else {
                i++;
                j=i+1;
            }
        }
        return ans;
    }
}