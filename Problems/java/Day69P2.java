package Problems.java;
import java.util.*;
/*
BCCI wants to select the group of bowlers for an upcoming test-series,
you want to choose the group with highest number of wickets, which is
the sum of wickets taken by all the bowlers in that group.

However, the bowler group is not allowed to have any disputes. A dispute
exists if a younger bowler has strictly highest wickets than an older bowler.
A dispute does not occur between bowlers of the same age.

You are given information of N bowlers as two lists, wickets and ages,
where each wickets[i] and ages[i] represents the wickets and age of
the i-th bowler, respectively, return the highest number of wickets
of all possible bowler groups.


Input Format:
-------------
Line-1: An integer N, number of bowlers.
Line-2: N space separated integers, wickets[].
Line-3: N space separated integers, ages[].

Output Format:
--------------
An integer, highest number of wickets of all possible bowler groups.


Sample Input-1:
---------------
4
5 3 5 6
3 5 4 2

Sample Output-1:
----------------
10

Explanation:
------------
It is best to choose 2 bowlers of age 3 and 4.


Sample Input-2:
---------------
5
5 3 5 6 3
2 5 4 2 1

Sample Output-2:
----------------
14

Explanation:
------------
It is best to choose 3 bowlers of age 1 and 2.
Notice that you are allowed to choose multiple bowlers of the same age.

Sample Input-3:
---------------
5
1 3 5 10 15
1 2 3 4 5

Sample Output-3:
----------------
34

Explanation:
------------
You can choose all the bowlers.

*/
public class Day69P2 {
    static int[][] b;
    static int n;
    static int[][] memo;
    private static int solve(int idx, int prev){
        if(idx==n) return 0;
        if(prev!=-1 && memo[idx][prev]!=-1) return memo[idx][prev];
        int l = solve(idx+1, prev);
        int r = 0;
        if(prev==-1 || b[idx][1]>=b[prev][1]){
            r = b[idx][1] + solve(idx+1, idx);
        }
        if(prev!=-1) memo[idx][prev]=Math.max(l, r);
        return Math.max(l, r);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] w = new int[n];
        int[] a = new int[n];
        for(int i=0;i<n;i++) w[i] = sc.nextInt();
        for(int j=0;j<n;j++) a[j] = sc.nextInt();
        b = new int[n][2];
        for(int i=0;i<n;i++){
            b[i][0] = a[i];
            b[i][1] = w[i];
        }
        Arrays.sort(b, (x, y)->{
            if(x[0]==y[0]) return x[1]-y[1];
            return x[0]-y[0];
        });
        memo = new int[n][n];
        for(int[] r: memo) Arrays.fill(r, -1);
        int res = solve(0, -1);
        System.out.println(res);
    }
}
