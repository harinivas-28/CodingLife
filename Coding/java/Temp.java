package Coding.java;
import java.util.*;
// public class Temp {
//     private static final int mod = 1_000_000_007;
//     private static int res = 0;
//     private static Map<String, List<String>> map;
//     private static Map<String, Integer> memo;
//     public static int countVowelPermutation(int n) {
//         map = new HashMap<>();
//         memo = new HashMap<>();
//         map.put("a", List.of("e"));
//         map.put("e", Arrays.asList("a", "i"));
//         map.put("i", Arrays.asList("a", "e", "o", "u"));
//         map.put("o", Arrays.asList("i", "u"));
//         map.put("u", List.of("a"));
//         for(String vowel: map.keySet()){
//             // bT(n, vowel, vowel);
//             res = (res+bTandMemo(n-1, vowel))%mod;
//         }
//         return res;
//     }
//     private static int bTandMemo(int n, String currChar) {
//         if (n == 0) return 1;  
//         String key = n + "-" + currChar;
//         if (memo.containsKey(key)) return memo.get(key);

//         int count = 0;
//         for (String next : map.get(currChar)) {
//             count = (count + bTandMemo(n - 1, next)) % mod;
//         }

//         memo.put(key, count);  
//         return count;
//     }
//     @SuppressWarnings("unused")
//     private static void bT(int n, String str, String currChar){
//         if(str.length()==n){
//             res++;
//             res %= mod;
//             return;
//         }
//         for(String s: map.get(currChar)){
//             bT(n, str+s, s);
//         }
//     }
//     private static final int[][] rules = {
//             {0, 1, 0, 0, 0},
//             {1, 0, 1, 0, 0},
//             {1, 1, 0, 1, 1},
//             {0, 0, 1, 0, 1},
//             {1, 0, 0, 0, 0}
//     };
//     private static int useDp(int n){
//         if(n==1) return 5;
//         int[][] dp = new int[n+1][5];
//         Arrays.fill(dp[1], 1);
//         for(int i=2;i<=n;i++){
//             for(int j=0;j<5;j++){
//                 dp[i][j] = 0;
//                 for(int k=0;k<5;k++){
//                     if(rules[k][j]==1) {
//                         dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
//                     }
//                 }
//             }
//         }
//         long res = 0;
//         for(int i=0;i<5;i++){
//             res = (res+dp[n][i])%mod;
//         }
//         return (int)res;
//     }
//     public static void main(String[] args){
//         int[] testCases = {1, 2, 3, 20, 20000};
//         for(int i=0;i<5;i++){
// //            System.out.println("n = "+testCases[i]+", Vowel Permutation = "+countVowelPermutation(testCases[i]));
//             System.out.println("Using DP: ");
//             System.out.println("n = "+testCases[i]+", Vowel Permutation = "+useDp(testCases[i]));
//         }
//     }
// }

public class Temp {
    private static boolean f(String s, String r){
        // heeelllooo hello helo
        int x = s.length(), y = r.length();
        int i = 0, j = 0;
        while(i<x && j<y){
            char c1 = s.charAt(i);
            char c2 = r.charAt(j);
            if(c1!=c2) return false;
            int cnt1= 0, cnt2 = 0;
            while(i<x && s.charAt(i)==c1){
                i++;
                cnt1++;
            }
            while(j<y && r.charAt(j)==c2){
                j++;
                cnt2++;
            }
            if(cnt1<cnt2) return false;
            if(cnt1!=cnt2 && cnt1<3){
                return false;
            }
        }
        // System.out.println(r);
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.nextLine();
        String[] strs = sc.nextLine().split(" ");
        int cnt = 0;
        for(String r: strs){
            if(f(s, r)){
                cnt++;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}