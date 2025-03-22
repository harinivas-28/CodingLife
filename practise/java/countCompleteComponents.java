package practise.java;

import java.util.*;

public class countCompleteComponents {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n; int[][] edges;
        { // Input Code
            n = sc.nextInt();
            edges = new int[n][n];
            for(int i=0;i<n;i++){
                int u = sc.nextInt(), v = sc.nextInt();
                if(u!=-1 && v!=-1)
                    edges[i] = new int[]{u, v};
            }
        }
        int res = useDSU(n, edges);
        int res2 = useDFS(n, edges);
        int res3 = simple(n, edges);
        System.out.println("Using DSU: "+res+"\nUsing DFS: "+res2+"\nSimple sorting: "+res3);
        sc.close();
    }
    private static int simple(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            graph.get(i).add(i);
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(List<Integer> l: graph){
            Collections.sort(l);
            map.put(l, map.getOrDefault(l, 0)+1);
        }
        int res = 0;
        for(Map.Entry<List<Integer>, Integer> en: map.entrySet()){
            if(en.getKey().size() == en.getValue()){
                res++;
            }
        }
        return res;
    }
    private static int dfs(int curr, List<Integer>[] adj, boolean[] vis, int[] noOfEdges){
        vis[curr] = true;
        noOfEdges[0] += adj[curr].size();
        int val = 0;
        for(int x: adj[curr]){
            if(!vis[x]){
                val += dfs(x, adj, vis, noOfEdges);
            }
        }
        return 1 + val;
    }
    private static int useDFS(int n, int[][] edges){
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int res = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            int[] noOfEdges = new int[1];
            if(!vis[i]){
                int compSize = dfs(i, adj, vis, noOfEdges);
                if(noOfEdges[0]/2 == compSize*(compSize-1)/2){
                    res++;
                }
            }
        }
        return res;
    }
    private static int useDSU(int n, int[][] edges){
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            dsu.union(edge[0], edge[1]);
        }
        Map<Integer, Integer> nodeCount = new HashMap<>();
        Map<Integer, Integer> edgeCount = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int root = dsu.find(i);
            nodeCount.put(root, nodeCount.getOrDefault(root, 0)+1);
        }
        for(int[] edge: edges){
            int root = dsu.find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0)+1);
        }
        int res = 0;
        for(int root: nodeCount.keySet()){
            int nodes = nodeCount.get(root);
            int req = nodes*(nodes-1)/2;
            if(edgeCount.getOrDefault(root, 0) == req){
                res++;
            }
        }
        return res;
    }
}
