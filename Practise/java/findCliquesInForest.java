package Practise.java;
import java.util.*;
public class findCliquesInForest {
    private static List<List<Integer>> useDSU(int n, int[][] edges){
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            dsu.union(edge[0], edge[1]);
        }
        Map<Integer, List<Integer>> nodeCount = new HashMap<>();
        for(int i=0;i<n;i++){
            int root = dsu.find(i);
            nodeCount.putIfAbsent(root, new ArrayList<>());
            nodeCount.get(root).add(i);
        }
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for(int[] edge: edges){
            int root = dsu.find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0)+1);
        }
        List<List<Integer>> cliques = new ArrayList<>();
        for(int root: nodeCount.keySet()){
            List<Integer> comp = nodeCount.get(root);
            int k = comp.size();
            int req = k*(k-1)/2;
            if(edgeCount.getOrDefault(root, 0)==req){
                cliques.add(comp);
            }
        }
        return cliques;
    }
    private static void dfs(int curr, List<List<Integer>> adj, boolean[] vis, List<Integer> comp, int[] noOfEdges){
        vis[curr] = true;
        comp.add(curr);
        for(int x: adj.get(curr)){
            noOfEdges[0]++;
            if(!vis[x]){
                dfs(x, adj, vis, comp, noOfEdges);
            }
        }
    }
    public static List<List<Integer>> findCliques(int n, int[][] edges){
        List<List<Integer>> cliques = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n]; 
        for(int i=0;i<n;i++){
            if(!vis[i]){
                List<Integer> comp = new ArrayList<>();
                int[] noOfEdges = new int[1];
                dfs(i, graph, vis, comp, noOfEdges);
                int k = comp.size();
                if(noOfEdges[0]/2 == k*(k-1)/2){
                    cliques.add(comp);
                }
            }
        }
        return cliques;
    }
    public static void main(String[] args){
        int n = 6;
        int[][] edges = {
            {0, 1}, {0, 2}, {1, 2}, 
            {3, 4}
        };

        List<List<Integer>> cliques = findCliques(n, edges);
        List<List<Integer>> cliques2 = useDSU(n, edges);
        System.out.println("Cliques in the forest(Using DFS): " + cliques);
        System.out.println("Cliques in the forest(Using DSU): " + cliques2);
    }
}
