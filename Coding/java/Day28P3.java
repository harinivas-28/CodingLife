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
        int n = sc.nextInt();
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        List<Integer> wt = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            from.add(u);
            to.add(v);
            wt.add(w);
        }
        int div = sc.nextInt();
        sc.close();
        List<Integer> res = solve(n, from, to, wt, div);
        System.out.println(res);
    }
    private static List<Integer> solve(int n, List<Integer> from, List<Integer> to, List<Integer> wt, int div){
        return new AbstractList<Integer>() {
            List<Integer> res = null;
            private void build(){
                if(res!=null) return;
                res = new ArrayList<>();
                int[][] adj = new int[n+1][n+1];
                for(int[] a: adj) Arrays.fill(a, Integer.MAX_VALUE);
                for(int i=1;i<=n;i++) adj[i][i] = 0;
                for(int i=0;i<from.size();i++){ 
                    int u = from.get(i), v = to.get(i), w = wt.get(i);
                    adj[u][v] = w;
                    adj[v][u] = w;
                }
                // Floyd Warshall
                for(int k=1;k<=n;k++){
                    for(int i=1;i<=n;i++){
                        for(int j=1;j<=n;j++){
                            if(adj[i][k]!=Integer.MAX_VALUE && adj[k][j]!=Integer.MAX_VALUE)
                                adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                        }
                    }
                }
                for(int i=1;i<=n;i++){
                    int cnt = 0;
                    for(int j=1;j<=n;j++){
                        if(adj[i][j]!=0 && adj[i][j]%div==0){
                            cnt++;
                        }
                    }
                    res.add(cnt);
                }
            }
            @Override
            public int size() {
                build();
                return res.size();
            }
            @Override
            public Integer get(int index) {
                build();
                return res.get(index);
            }
        };
    }
}
