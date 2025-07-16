package Practise.java;
import java.util.*;
public class Dijkstras {
    public static int[] useAlgo(int v, List<List<Node>> adj, int source){
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(curr.cost>dist[curr.v]) continue;
            for(Node ngh: adj.get(curr.v)){
                int newDist = dist[curr.v] + ngh.cost;
                if(newDist < dist[ngh.v]){
                    dist[ngh.v] = newDist;
                    pq.offer(new Node(ngh.v, newDist));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), e=sc.nextInt(), source = sc.nextInt();
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<e;i++){
            int u = sc.nextInt(),v=sc.nextInt(), cost = sc.nextInt();
            adj.get(u).add(new Node(v, cost));
            // adj.get(v).add(new Node(u, cost)); For Undirect Graph
        }
        int[] res = useAlgo(V, adj, source);
        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + source + " to " + i + " is " + (res[i] == Integer.MAX_VALUE ? "INF" : res[i]));
        sc.close();
    }
}
class Node implements Comparable<Node>{
    int v, cost;
    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
    public int compareTo(Node other){
        return this.cost - other.cost;
    }
}
