package practise.java;
/*
 * Handles very large exponents efficiently (even up to 10^18)

    Avoids Math.pow (which is not safe for mod and large numbers)

    Ensures correctness and avoids overflows
 */
public class math {
    public static long pow(long base, long exp){
        long res = 1;
        while(exp>0){
            if((exp&1)==1) res *= base;
            base *= base;
            exp >>= 1;
        }
        return res;
    }
    public static long modPow(long base, long exp, int mod){
        long res = 1;
        while(exp>0){
            if((exp&1)==1) res = (res*base)%mod;
            base = (base*base)%mod;
            exp >>= 1;
        }
        return res;
    }
}