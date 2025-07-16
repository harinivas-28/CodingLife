package Practise.java;
import java.util.*;

public class minimumCost {
    static int[] p;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt();
        int[][] links = new int[t][3];
        for(int i=0;i<t;i++){
            links[i][0] = sc.nextInt();
            links[i][1] = sc.nextInt();
            links[i][2] = sc.nextInt();
        }
        p = new int[n+1];
        for(int i=0;i<=n;i++) p[i] = i;
        Arrays.sort(links, (a,b)->Integer.compare(a[2], b[2]));
        int cost = 0, edges = 0;
        for(int[] l: links){
            if(union(l[0], l[1])){
                cost+=l[2];
                edges++;
            }
        }
        sc.close();
        System.out.println(edges==n-1 ? cost : -1);
    }
    static boolean union(int x, int y){
        int rx = find(x), ry = find(y);
        if(rx==ry) return false;
        p[rx] = ry;
        return true;
    }
    static int find(int x){
        if(p[x]!=x)
         p[x] = find(p[x]);
        return p[x];
    }
}