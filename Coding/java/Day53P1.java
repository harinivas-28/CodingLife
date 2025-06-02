package Coding.java;
/*
Amogh is an Antiquarian, The person who collects antiques.
He found a rear keyboard which has the following keys,
Keys are 'N', 'S', 'C' and 'P'

1st Key - 'N': Print one character 'N' on Console.
2nd Key - 'S': Select the whole Console.
3rd Key - 'C': Copy selected content to buffer.
4th Key - 'P': Print the buffer on Console, and append it after what has
already been printed.

Now, your task is to find out maximum numbers of 'N's you can print
after K keystrokes .

Input Format:
-------------
An integer K

Output Format:
--------------
Print an integer, maximum numbers of 'N's you can print.


Sample Input-1:
-------------------
3

Sample Output-1:
--------------------
3

Explanation:
---------------
We can print at most get 3 N's on console by pressing following key sequence:
N, N, N



Sample Input-2:
-------------------
7

Sample Output-2:
---------------------
9

Explanation:
---------------
We can print at most get 9 N's on console by pressing following key sequence:
N, N, N, S, C, P, P

 */
import java.util.Arrays;
import java.util.Scanner;
public class Day53P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(remo(n, memo));
    }
    private static int remo(int n, int[] memo){
        if(n<=0) return 0;
        if(memo[n]!=-1) return memo[n];
        int left = remo(n-1, memo)+1;
        for(int i=3;i<=n;i++){
            // remo(n - i) → how many 'N's you had before using the current S-C-P-P... block
            //(i - 2) → number of P operations you can do in the current block
            int ryt = remo(n-i, memo)*(i-2);
            left = Math.max(left, ryt);
        }
        System.out.println(Arrays.toString(memo));
        return memo[n]=left;
    }
}
