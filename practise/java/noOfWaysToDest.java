package practise.java;
import java.util.*;
/*
 * You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
 */
public class noOfWaysToDest {
    public static void main(String[] args){
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        int res = countPaths(n, roads);
        System.out.println(res);
    }
    public static int countPaths(int n, int[][] roads) {
        final long INF = Long.MAX_VALUE / 2;
        final int MOD = (int) 1e9 + 7;
        long[][] graph = new long[n][n];
        for (long[] row : graph) {
            Arrays.fill(row, INF);
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph[u][v] = time;
            graph[v][u] = time;
        }
        long[] dist = new long[n]; 
        Arrays.fill(dist, INF);
        dist[0] = 0;

        int[] ways = new int[n]; 
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 0)); 

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long time = curr.time;
            if (time > dist[u]) continue;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] == INF) continue; 

                long newTime = time + graph[u][v];

                if (newTime < dist[v]) { 
                    dist[v] = newTime;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v, newTime));
                } else if (newTime == dist[v]) { 
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1]; 
    }

    private static class Pair implements Comparable<Pair> {
        int node;
        long time;
        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair other) {
            return Long.compare(this.time, other.time);
        }
    }
}
