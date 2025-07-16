package Problems.java;
import java.util.*;
/*
There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
Note: Look HINT for explanation.
*/
public class Day29P3_dsu {
    static class DSU {
        int[] p;
        public DSU(int n){
            p = new int[n];
            for(int i=0;i<n;i++) p[i] = i;
        }
        public int find(int x){
            if(p[x]!=x)
                p[x] = find(p[x]);
            return p[x];
        }
        public void union(int x, int y){
            int rx = find(x), ry = find(y);
            if(rx!=ry){
                p[ry] = rx;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        DSU dsu = new DSU(n);
        for(int i=0;i<x;i++){
            int u = sc.nextInt(), v =sc.nextInt();
            dsu.union(u, v);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(dsu.find(i));
        }
        sc.close();
        System.out.println(set.size());
    }
}