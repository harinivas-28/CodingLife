package Coding.java;
/*
You have given a bulb grid, where the bulb which is turned ON is indicated
with 1, and turned OFF is indicated with 0.

You are allowed to perform an operation:
    - Select a row/column in the bulb grid, and toggle the bulbs,
    the bulbs which are turned ON will be turned OFF and the bulbs which are
    turned OFF will be turned ON.

Your task is to find the highest possible sum of all the binary equivalents
of each row in the bulb grid, after performing the above operation any
number of times on the bulb grid.


Input Format:
-------------
Line-1: Two space separated integers, M and N
Next M lines: N space separated integers, grid[][]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 5
0 1 1 1 1
1 0 1 1 1
0 0 0 0 1

Sample Output-1:
----------------
78

Explanation:
------------
Given grid is
0 1 1 1 1
1 0 1 1 1
0 0 0 0 1

Perform operation on row-0 and row-2
1 0 0 0 0
1 0 1 1 1
1 1 1 1 0

Perform operation on col-1 and col-4
1 1 0 0 1 = 25
1 1 1 1 0 = 30
1 0 1 1 1 = 23
So, now the total value of Binary Equivalent is 78


Sample Input-2:
---------------
2 3
0 1 0
0 0 1

Sample Output-2:
----------------
11
 */
import java.util.*;
public class Day81P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] g = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                g[i][j] = sc.nextInt();
            }
        }
        // rows
        for(int i=0;i<m;i++){
            if(g[i][0]==0){
                flipRow(g, i);
            } else continue;
        }
        // cols
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                cnt += g[j][i];
            }
            if(cnt<m-cnt){
                flipCol(g, i);
            }
        }
        // sum
        int sum = 0;
        for(int i=0;i<m;i++){
            int x = n-1;
            int t = 0;
            for(int j=0;j<n;j++){
                t = (t<<1) | g[i][j];
                x--;
            }
            sum += t;
        }
        System.out.println(sum);
    }
    private static void flipRow(int[][] g, int i){
        for(int j=0;j<g[0].length;j++){
            g[i][j] ^= 1;
        }
    }
    private static void flipCol(int[][] g, int i){
        for(int j=0;j<g.length;j++){
            g[j][i] ^=1;
        }
    }
}
