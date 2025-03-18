package practise.java;

import java.util.*;

public class BellmanFord {
    public static int[] useAlgo(int n, int e, List<Edge> edges, int source){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        // n-1 Relaxation
        for(int i=0;i<n-1;i++){
            for(Edge edge: edges){
                if(dist[edge.u]!=Integer.MAX_VALUE && dist[edge.u]+edge.wt<dist[edge.v]){
                    dist[edge.v] = dist[edge.u] + edge.wt;
                }
            }
        }
        // Check for cycle
        for(Edge edge: edges){
            if(dist[edge.u]!=Integer.MAX_VALUE && dist[edge.u]+edge.wt<dist[edge.v]){
                return new int[0];
            }
        }
        return dist;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int source = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<e;i++){
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            edges.add(new Edge(u, v, wt));
        }
        int[] res = useAlgo(n, e, edges, source);
        if(res.length==0){
            System.out.println("Graph has Negative Cycle!");
        }
        System.out.println("shortest Distances from source "+source+" to other nodes:-");
        for(int x: res) if(x==Integer.MAX_VALUE) System.out.print("INF "); else System.out.print(x+" ");
        sc.close();
    }
}
