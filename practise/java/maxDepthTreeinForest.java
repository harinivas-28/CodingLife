package practise.java;

import java.util.*;

public class maxDepthTreeinForest {
    static List<List<Integer>> adj;
    static int res = Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=1;i<=n;i++){
            int x = sc.nextInt();
            if(x!=-1){
                adj.get(x).add(i);
            } else {
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int val = q.poll();
            res = Math.max(res, dfs(val));
        }
        System.out.println(res);
        sc.close();
    }
    private static int dfs(int node){
        if(adj.get(node).isEmpty()) return 1; 
        int maxDepth = 0;
        for(int x: adj.get(node)){
            maxDepth = Math.max(maxDepth, dfs(x));
        }
        return maxDepth + 1; 
    }
}
