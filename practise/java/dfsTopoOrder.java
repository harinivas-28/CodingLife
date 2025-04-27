package practise.java;

import java.util.*;

public class dfsTopoOrder {
    public static void main(String[] args){
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {3, 2}, {0, 3}};
        List<Integer> topoOrder = topoSort(n, edges);
        System.out.println(topoOrder);
    }
    private static List<Integer> topoSort(int n, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
        }
        boolean[] vis = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i])
                dfs(i, vis, adj, stack);
        }
        // Collections.reverse(res);
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    private static void dfs(int u, boolean[] vis,List<List<Integer>> adj,Stack<Integer> st){
        vis[u] = true;
        for(int v: adj.get(u)){
            if(!vis[v]){
                dfs(v, vis, adj, st);
            }
        }
        st.push(u);
    }
}
