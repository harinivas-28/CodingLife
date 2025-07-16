package Practise.java;
import java.util.*;

public class prims {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[][] edges = new int[t][3];// u, v, wt
        for(int i=0;i<t;i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        sc.close();
        System.out.println(costOfMst(n, edges));
    }
    private static int costOfMst(int n, int[][] edges){
        int[][] adj = getAdj(edges, n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        boolean[] vis = new boolean[n];
        pq.offer(new int[]{0, 0});
        int sum = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int v = curr[0], wt = curr[1];
            if(vis[v]) continue; 
            vis[v] = true;
            sum += wt;
            for(int i = 0; i < n; i++){
                if(!vis[i]){
                    pq.offer(new int[]{i, adj[v][i]});
                }
            }
        }
        return sum;
    }
    private static int[][] getAdj(int[][] edges, int n){
        int[][] adj = new int[n][n];
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            adj[u][v] = wt;
            adj[v][u] = wt;
        }
        return adj;
    }
}