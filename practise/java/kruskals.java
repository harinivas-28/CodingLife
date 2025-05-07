package practise.java;
import java.util.*;

public class kruskals {
    static int[] p;
    static int[] r;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>();
        int V = sc.nextInt();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int a = sc.nextInt(), b= sc.nextInt(), c = sc.nextInt();
            edges.add(new int[]{a, b, c});
        }
        System.out.println(minCost(V, edges));
        sc.close();
    }
    private static int find(int x){
        if(p[x]!=x)
            p[x] = find(p[x]);
        return p[x];
    }
    private static boolean union(int x, int y){
        int rx = find(x), ry = find(y);
        if(rx==ry) return false;
        if(r[rx]<r[ry]) p[rx] = ry;
        else if(r[rx]>r[ry]) p[ry] = rx;
        else {
            r[rx] = ry;
            r[rx]++;
        }
        return true;
    }
    private static int minCost(int V, List<int[]> edges){
        p = new int[V];
        r = new int[V];
        for(int i=0;i<V;i++) p[i] = i;
        Collections.sort(edges, (a,b)->Integer.compare(a[2], b[2]));
        int cost = 0;
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            if(union(u, v)){
                cost += wt;
            }
        }
        return cost;
    }
}
