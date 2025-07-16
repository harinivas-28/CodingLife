package Practise.java;
import java.util.*;
/*
You are given an integer n and a Directed Acyclic Graph (DAG) with n nodes labeled from 0 to n - 1. This is represented by a 2D array edges, where edges[i] = [ui, vi, wi] indicates a directed edge from node ui to vi with weight wi.

You are also given two integers, k and t.

Your task is to determine the maximum possible sum of edge weights for any path in the graph such that:

The path contains exactly k edges.
The total sum of edge weights in the path is strictly less than t.
Return the maximum possible sum of weights for such a path. If no such path exists, return -1.
 */
/*HINT : the problem is asking for a path with exactly k edges in a DAG, not just any combination of k edges, the previous approach is invalid. We can't freely choose any k edges; the selected edges must form a valid path, which is a much stricter requirement.
 */
public class maxWeightedGraph {
    static Integer[][][] memo;
    static Map<Integer, List<int[]>> graph;
    static int res = 0;
    static int t;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<r;i++){
            int u = sc.nextInt(), v = sc.nextInt(), w=sc.nextInt();
            edges.add(new int[]{u, v, w});
        }
        int k =sc.nextInt();
        int t = sc.nextInt();
        memo = new Integer[n][k+1][t];
        sc.close();
        System.out.println(maxWeight(n, edges, k, t));
    }
    private static int maxWeight(int n, List<int[]> edges, int k, int t){
        graph = new HashMap<>();
        for(int[] e: edges){
            graph.computeIfAbsent(e[0], x->new ArrayList<>()).add(new int[]{e[1], e[2]});
        }
        int res = -1;
        for(int u=0;u<n;u++){
            int ans = dfs(u, k, 0);
            res = Math.max(res, ans);
        }
        return res==Integer.MIN_VALUE ? -1 : res;
    }
    private static int dfs(int u, int k, int sum){
        if(k==0) return sum<t ? sum : Integer.MIN_VALUE;
        if(sum>=t) return Integer.MIN_VALUE;
        if(memo[u][k][sum]!=null) return memo[u][k][sum];
        int maxSum = Integer.MIN_VALUE;
        for(int[] e: graph.get(u)){
            int v = e[0], wt = e[1];
            if(sum+wt<t){
                int next = dfs(v, k-1, sum+wt);
                if(next!=Integer.MIN_VALUE){
                    maxSum = Math.max(maxSum, next);
                }
            }
        }
        return memo[u][k][sum] = maxSum;
    }
}
