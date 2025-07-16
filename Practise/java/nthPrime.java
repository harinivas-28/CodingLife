package Practise.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class nthPrime {
    private static int estimateUpperBound(int n){
        if(n<6) return 15;
        return (int)(n*(Math.log(n) + Math.log(Math.log(n))));
    }
    private static List<Integer> sieve(int max){
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2;i*i<=max;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=max;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=max;i++){
            if(isPrime[i]) primes.add(i);
        }
        return primes;
    }
    private static int findNthPrime(int n){
        int ub = estimateUpperBound(n);
        List<Integer> primes = sieve(ub);
        return primes.get(n-1);
    }
    public static void main(String[] args){
        int n = 10000;
        System.out.println("The " + n + "th prime number is: " + findNthPrime(n));
    }
}
