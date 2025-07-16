package Practise.java;
import java.util.*;
/*
M-Coloring Problem
Difficulty: MediumAccuracy: 34.42%Submissions: 153K+Points: 4Average Time: 45m
You are given an undirected graph consisting of V vertices and E edges represented by a list edges[][], along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.

Note: The graph is indexed with 0-based indexing.

Examples:

Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:

Vertex 0: Color 1
Vertex 1: Color 2
Vertex 2: Color 2
Vertex 3: Color 3
Input: V = 3, edges[][] = [[0, 1], [1, 2], [0, 2]], m = 2
Output: false
Explanation: It is not possible to color the given graph using only 2 colors because vertices 0, 1, and 2 form a triangle.
Constraints:
1 ≤ V ≤ 10
1 ≤ E = edges.size() ≤ (V*(V-1))/2
0 ≤ edges[i][j] ≤ V-1
1 ≤ m ≤ V

Expected Complexities
Time Complexity: O(V * m ^ V)
Auxiliary Space: O(V + E)
Company Tags
Amazon
 */
public class graphColoring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int r = sc.nextInt();
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<r;i++){
            int u = sc.nextInt(), v = sc.nextInt();
            edges.add(new int[]{u, v});
        }
        int m = sc.nextInt(); // m colors
        sc.close();
        System.out.println(colorGraph(V, edges, m));
    }
    private static boolean colorGraph(int V, List<int[]> edges, int m){
        List<List<Integer>> adj = new ArrayList<>();
        Collections.fill(adj, new ArrayList<>());
        for(int[] e: edges){
            int u = e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] col = new int[V];
        Arrays.fill(col, -1);
        return dfs(0, adj, col, m);
    }
    private static boolean dfs(int idx, List<List<Integer>> adj, int[] col, int m){
        if(idx==col.length) return true;
        for(int i=0;i<m;i++){
            if(valid(i, idx, adj, col)){
                col[idx] = i;
                if(dfs(idx+1, adj, col, m)){
                    return true;
                }
                col[idx] = -1;
            }
        }
        return false;
    }
    private static boolean valid(int i, int idx, List<List<Integer>> adj, int[] col){
        for(int x: adj.get(idx)){
            if(col[x]!=-1 && col[x]==i) return false;
        }
        return true;
    }
}
