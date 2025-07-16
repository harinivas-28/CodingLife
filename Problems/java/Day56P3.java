package Problems.java;
/*
Write a Java program to find the nth prime number. 
The value of n should be input by the user.

Sample Input:
---------------
5

Sample Output:
-----------------
11

*/
import java.util.*;

public class Day56P3 {

    public static int findNthPrime(int n) {
        // Implement this method.
        int cnt = 1;
        int num = 2;
        while(true){
            num++;
            if(isPrime(num)){
                cnt++;
                if(cnt==n) return num;
            }
        }
    }
    private static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int result = findNthPrime(n);
        System.out.println(result);
        sc.close();
    }
}
