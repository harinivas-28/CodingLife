package Coding.java;
/*
Jadav Payeng, "The Forest Man of India",
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally
with each other, form a sapling-group.
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

 */
import java.util.*;
public class Day82P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] g = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                g[i][j] = sc.nextInt();
            }
        }
        int res2 = bfs(g, m, n);
        System.out.println("BFS: "+res2);
        boolean[][] vis = new boolean[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1 && !vis[i][j]){
                    res = Math.max(res, dfs(i, j, g, vis));
                }
            }
        }
        System.out.println("DFS: "+res);
    }
    private static int bfs(int[][] g, int m, int n){
        int res = 0;
        final int[][] dir = {{0,1},{1,0},{-1, 0},{0,-1},{1, -1}, {1, 1}, {-1, -1}, {-1, 1}};
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1 && !vis[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    int t = 0;
                    while(!q.isEmpty()){
                        int[] x = q.poll();
                        vis[x[0]][x[1]] = true;
                        t++;
                        for(int[] d: dir){
                            int nx = x[0]+d[0];
                            int ny = x[1] + d[1];
                            if(nx<m && ny<n && nx>=0 && ny>=0 && !vis[nx][ny] && g[nx][ny]!=0){
                                vis[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    res = Math.max(res, t);
                }
            }
        }
        return res;
    }
    private static int dfs(int i, int j, int[][] g, boolean[][] vis){
        if(i>=g.length || i<0 || j>=g[0].length || j<0 || vis[i][j] || g[i][j]==0) return 0;
        vis[i][j] = true;
        return 1 + dfs(i+1, j, g, vis) + dfs(i-1, j, g, vis) +
                dfs(i, j+1, g, vis) + dfs(i, j-1, g, vis) +
                dfs(i+1, j+1, g, vis) + dfs(i-1, j-1, g, vis) +
                dfs(i+1, j-1, g, vis) + dfs(i-1, j+1, g, vis);
    }
}
