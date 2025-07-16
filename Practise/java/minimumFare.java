package Practise.java;
import java.util.*;

public class minimumFare {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            int a =sc.nextInt();
            int b = sc.nextInt();
            l.add(new int[]{a, b});
        }
        sc.close();
        // fun(l, 0, 0, 0, 0);
        // System.out.println(res);
        System.out.println(greedy(l));
    }
    public static int twoCitySchedCost(int[][] costs) {
        int N = costs.length/2;
        int[] refund = new int[N * 2];
        int minCost = 0, index = 0;
        for(int[] cost : costs){
            refund[index++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        Arrays.sort(refund);
        for(int i = 0; i < N; i++){
            minCost += refund[i];
        }
        return minCost;
    }
    private static int greedy(List<int[]> l){
        Collections.sort(l, (a, b)->(a[0]-a[1])-(b[0]-b[1]));
        int n=l.size();
        int total = 0;
        for (int i = 0; i < n / 2; i++) {
            total += l.get(i)[0];
        }
        for (int i = n / 2; i < n; i++) {
            total += l.get(i)[1];
        }
        // System.out.println(total);
        return total;
    }
    @SuppressWarnings("unused")
    private static void fun(List<int[]> l, int idx, int sum, int k, int n){
        if(idx>=l.size()){
            if(k==l.size()/2 && n==l.size()/2){
                res = Math.min(res, sum);
            }
            return;
        }
        if(k<l.size()/2)
            fun(l, idx+1, sum+l.get(idx)[0], k+1, n);
        if(n<l.size()/2)
            fun(l, idx+1, sum+l.get(idx)[1], k, n+1);
    }
}