package Coding.java;

public class Temp {
    private static final int mod = 1_000_000_007;
    public static int numRollsToTarget(int n, int k, int target) {
        Integer[][] memo = new Integer[n+1][target+1];
        return bT(n, k, target, 0, 0, memo); 
    }
    private static int bT(int n, int k, int target, int currSum, int depth, Integer[][] memo){
        if(depth>n || currSum > target) return 0;
        if(depth==n){
            return currSum==target ? 1: 0;
        }
        if(memo[depth][currSum]!=null) return memo[depth][currSum];
        int ways = 0;
        for(int i=1;i<=k;i++){
            ways = (ways + bT(n, k, target, currSum+i, depth+1, memo))%mod;
        }
        return memo[depth][currSum] = ways;
    }
    public static void main(String[] args){
        int[] n = {1, 2, 30};
        int[] k = {6, 6, 30};
        int[] tar = {3, 7, 500};
        for(int i=0;i<3;i++){
            System.out.println(numRollsToTarget(n[i], k[i], tar[i]));
        }
    }
} 