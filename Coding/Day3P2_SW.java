// Day 3 P2
/*
In a distant galaxy, there exists an ancient space station covered in a vast
        array of digital codes. These codes are believed to hold the key to unlocking
        powerful alien technology. The interstellar explorers call these codes "prime
        sequences."

        The prime-sequence beauty of the digital code is defined as the number of prime
        sequences that meet the following conditions:
        -The prime sequence has a length of k.
        -The prime sequence is a divisor of the entire digital code.
        -The prime sequence is a prime number.

        Given the digital code on the space station, represented as an integer code, and
        the length of the prime sequences k, return the prime-sequence beauty of the code.

        Note:
        -----
        Leading zeros in prime sequences are allowed.
        0 is not a divisor of any value.
        A prime sequence is a contiguous sequence of characters in the main digital code.

        Input Format:
        -------------
        Line-1: space separated String and integer, code and K

        Output Format:
        -------------
        An integer, the prime-sequence beauty of the code.


        Sample Input:
        -------------
        239246 2

        Sample Output:
        --------------
        1

        Explanation:
        ------------
        The following are the prime sequences of length k:
        "23" from "239246": 23 is a divisor of 239246 and is a prime number.
        "39" from "239246": 39 is not a divisor.
        "92" from "239246": 92 is not a divisor.
        "24" from "239246": 24 is is not a divisor 239246.
        "46" from "239246": 46 is a divisor of 239246 but is not a prime number.
        Therefore, the prime-sequence beauty is 1.

        Sample Input:
        -------------
        24224 1

        Sample Output:
        --------------
        3

 */

import java.util.*;

public class Day3P2_SW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        int res2 = slideWin(s, k);  // APPROACH 1
         System.out.println("res2: "+res2);
         int sNum = Integer.parseInt(s);
        // APPROACH 2
         int res = 0;
         for(int i=0;i<s.length()-k+1;i++){
             int num = Integer.parseInt(s.substring(i, i+k));
             res += (sNum%num==0 && isPrime(num)) ? 1: 0;
         }
         System.out.println(res);
         sc.close();
    }
    private static boolean isPrime(int num){
        if(num<=1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    private static int slideWin(String s, int k){
        int res = 0;
        StringBuilder sb = new StringBuilder();
        int sNum = Integer.parseInt(s);
        int r=0;
        while(r<s.length()){
            sb.append(s.charAt(r));
            if(r>=k-1){
                int num = Integer.parseInt(sb.toString());
                res += (sNum%num==0 && isPrime(num)) ? 1: 0;
                sb.deleteCharAt(0);
            }
            r++;
        }
        return res;
    }
}