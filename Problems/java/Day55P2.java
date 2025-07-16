package Problems.java;
import java.util.*;
/*
You are controlling a battlefield represented by an m x n grid.
Each cell on this grid can be one of the following:

- A reinforced barrier ('B'), blocking your laser.
- An enemy drone ('D'), your target.
- An open cell ('0'), where you can position your robot to fire.

When your robot fires its powerful laser from an open cell,
the beam destroys all enemy drones in the same row and column
until the beam hits a barrier ('B'). The barrier completely stops
the laser, protecting anything behind it.

Your goal is to identify the best position (open cell) to place
your robot so that firing the laser destroys the maximum number
of enemy drones in a single shot. Return this maximum number.

Input format:
-------------
Line 1: Two space separated integers, represents m & n
Next M lines: each row of battlefield


Output format:
--------------
An integer, maximum number of enemy drones destroyed in a single shot.

Example 1:
----------
input=
3 4
0 D 0 0
D 0 B D
0 D 0 0

Output=
3

Explanation: placing robot at battlefield[1][1] destroys 3 enemy drones in a
single shot.

Example 2:
----------
3 3
B B B
0 0 0
D D D

Output=
1


Constraints:
- 1 <= m, n <= 500
- battlefield[i][j] is either 'B', 'D', or '0'.

*/
public class Day55P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        String[][] g = new String[m][n];
        sc.nextLine();
        for(int i=0;i<m;i++) {
            g[i] = sc.nextLine().split(" ");
        }
        int[][] up = new int[m][n], down=new int[m][n];
        int[][] left = new int[m][n], right = new int[m][n];
        for(int j=0;j<n;j++){
            int cnt = 0;
            for(int i=0;i<m;i++){
                if(g[i][j].equals("B")) cnt = 0;
                else if(g[i][j].equals("D")) cnt++;
                up[i][j] = cnt;
            }
        }
        for(int j=0;j<n;j++){
            int cnt = 0;
            for(int i=m-1;i>=0;i--){
                if(g[i][j].equals("B")) cnt = 0;
                else if(g[i][j].equals("D")) cnt++;
                down[i][j] = cnt;
            }
        }
        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(g[i][j].equals("B")) cnt = 0;
                else if(g[i][j].equals("D")) cnt++;
                left[i][j] = cnt;
            }
        }
        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int j=n-1;j>=0;j--){
                if(g[i][j].equals("B")) cnt = 0;
                else if(g[i][j].equals("D")) cnt++;
                right[i][j] = cnt;
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j].equals("0")){
                    int total = 0;
                    total += (i>0 ? up[i-1][j] : 0);
                    total += (i<m-1 ? down[i+1][j] : 0);
                    total += (j>0 ? left[i][j-1]:0);
                    total+=(j<n-1? right[i][j+1]:0);
                    res = Math.max(res, total);
                }
            }
        }
        System.out.println(res);
    }
}
