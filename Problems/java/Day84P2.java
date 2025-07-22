package Problems.java;

import java.lang.reflect.Array;
import java.util.Scanner;

/*
Given N satellite stations, numbered 1 to N.
These satellites are connected to send signals from one to others.
To send a signal from satellite 's' to satellite 'd', it takes
an amount of time 't'.

You are given a list of travel times as directed edges times[i] = (s, d, t).

Your task to find the time taken to receive signal from a satellite station K,
to all N-1 satellite stations. If it is impossible, return -1 .

Input Format:
-------------
Line-1 ->   Three integers, N number of satellite stations,
            K is the satellite to send signal and T is the number of edges.
Next T lines -> Three space separated integers, 's' is the source,
            'd' is the destination,
			't' is the time taken receive signal from 's' to 'd'.

Output Format:
--------------
Print an integer as your result.


Sample Input-1:
---------------
4 2 3
2 1 1
2 3 1
3 4 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
5 2 4
2 1 1
2 3 2
3 4 3
5 1 4

Sample Output-2:
----------------
-1


Sample Input-3:
---------------
5 2 4
2 1 1
2 3 2
3 4 3
1 5 6

Sample Output-3:
----------------
7

*/
import java.util.*;
public class Day84P2 {
    static class Pair {
        int node, time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt(), t = sc.nextInt();
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<t;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Pair(v, w));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            int currTime = curr.time;
            for(Pair ngh: graph.get(u)){
                int v = ngh.node;
                int timeToV = ngh.time;
                if(currTime+timeToV < dist[v]){
                    dist[v] = currTime + timeToV;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        int maxTime = 0;
        for(int i=1;i<=n;i++){
            if(i==k) continue;
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        System.out.println(maxTime);
    }
}
