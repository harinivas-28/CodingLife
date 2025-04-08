package practise.java;
import java.util.*;

public class constructArray {
    private final static int MOD = 1_000_000_007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a = 1, b = sc.nextInt();
        sc.close();
        System.out.println("Recursive: "+countArrays(n, k, a, b));
    }
    private static int countArrays(int n, int k, int first, int last){
        if(n==1){
            return first==last?1:0;
        }
        if(n==2){
            return first==last?0:1;
        }
        int ways = 0;
        for(int val=1;val<=k;val++){
            if(val==first) continue;
            ways = (ways + countArrays(n, k, val, last))%MOD;
        }
        return ways;
    }
}
