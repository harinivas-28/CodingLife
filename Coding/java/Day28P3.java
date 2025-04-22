package Coding.java;
import java.util.*;
/*
 * The government has set up a network of smart traffic lights connected 
by roads, forming a tree structure with n traffic lights. Each road has a 
communication delay measured in meters.

Each road connects exactly two traffic lights, and all lights are connected 
(i.e., there are no cycles).

To maintain secure and efficient signal relays, the system allows only indirect
communication — where two traffic lights can communicate via a third traffic 
light (called the k) if:

The total signal path length (distance from light A to k to light B) is 
divisible by a given signal propagation speed.

You are to compute, for each traffic light, the number of such valid (A → B) 
communication pairs that it can mediate.

Input Format:
-------------
Line-1: An integer N     // number of traffic lights
Line-2: N-1 space sepearted integers,  light_from[].
Line-3: N-1 space sepearted integers,  light_to[].
Line-4: N-1 space sepearted integers,  road_lengths[].
Line-5: An integer, signal_speed    // signal propagation speed

Output Format:
---------------
An array of size n, where the ith value is the number of valid pairs 
that use traffic light i+1 as a k


Sample Input:
-------------
4
1 2 2
1 3 5
2 4 3
5

Sample Output:
--------------
2 0 2 2

 */
public class Day28P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] from = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] to = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] wt = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int div = Integer.parseInt(sc.nextLine());
        sc.close();

        List<Integer> res = solve(n, from, to, wt, div);
        for (int val : res) System.out.print(val + " ");
    }

    private static List<Integer> solve(int n, int[] from, int[] to, int[] wt, int div){
        return new AbstractList<Integer>() {
            List<Integer> res = null;
            private void build(){
                if(res!=null) return;
                res = new ArrayList<>();
                Map<Integer, List<int[]>> graph = new HashMap<>();
                for(int i = 0; i < n - 1; i++) {
                    graph.putIfAbsent(from[i]-1, new ArrayList<>());
                    graph.putIfAbsent(to[i]-1, new ArrayList<>());
                    graph.get(from[i]-1).add(new int[]{to[i] - 1, wt[i]});
                    graph.get(to[i]-1).add(new int[]{from[i] - 1, wt[i]});
                }
                for(int k = 0; k < n; k++) {
                    int[] dist = new int[n];
                    Arrays.fill(dist, -1);
                    dfs(k, -1, 0, dist, graph);
                    int cnt = 0;
                    for(int i = 0; i < n; i++) {
                        for(int j = i + 1; j < n; j++) {
                            if(i != k && j != k) {
                                int val = dist[i] + dist[j];
                                if(val % div == 0) {
                                    cnt++;
                                }
                            }
                        }
                    }
                    res.add(cnt);
                }
            }
            @Override
            public Integer get(int i){
                build();
                return res.get(i);
            }
            @Override
            public int size(){
                build();
                return res.size();
            }
            private void dfs(int node, int parent, int currDist, int[] dist, Map<Integer, List<int[]>> graph) {
                dist[node] = currDist;
                List<int[]> temp = graph.get(node);
                for(int[] nb : temp) {
                    if(nb[0] != parent) {
                        dfs(nb[0], node, currDist + nb[1], dist, graph);
                    }
                }
            }
        };
    }
}
