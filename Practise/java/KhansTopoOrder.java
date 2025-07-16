package Practise.java;

import java.util.*;

public class KhansTopoOrder {
    public static void main(String[] args){
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        List<Integer> topoOrder = khans(n, edges);
        System.out.println(topoOrder);
    }
    private static List<Integer> khans(int n, int[][] edges){
        int[][] adj = new int[n][n];
        for(int[] edge: edges){
            adj[edge[0]][edge[1]] = 1;
        }
        int[] inDeg = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj[i][j]==1) inDeg[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDeg[i]==0) q.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for(int i=0;i<n;i++){
                if(adj[curr][i]==1){
                    inDeg[i]--;
                    if(inDeg[i]==0) q.offer(i);
                }
            }
        }
        return res;
    }
}
