package Problems.java;

import java.util.Scanner;

/*
Aziz is given a set of integers SOI[], consists of both +ve and -ve integers.

Aziz wants to find the maximum sum of contiguous subset of the SOI, with a twist.

You have to perform the following operation before finding the maximum sum:
- You are allowed to replace exactly one integer X, with its square value (X*X).

Can you please help Aziz to find out the maximum sum of contiguous subset.


Input Format:
-------------
Single line of space separated integers, values of the array.

Output Format:
--------------
Print an integer value as result.


Sample Input-1:
---------------
-5 -3 1 2 -3 4 -4 3

Sample Output-1:
----------------
26

Explanation:
------------
max sum is: (-5)^2 + (-3) + 1 + 2 + (-3) + 4 = 26


Sample Input-2:
---------------
2 -2 2 2 -2 -2 2

Sample Output-2:
----------------
10

Explanation:
------------
max sum is: 2 +(-2)^2 + 2 + 2 = 10
*/
public class Day72P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = ArrayUtils.parseIntArray(sc.nextLine());
        int ns = arr[0];
        int os = arr[0]*arr[0];
        int res = Math.max(ns, os);
        for(int i=1;i<arr.length;i++){
            int tns = Math.max(ns+arr[i], arr[i]);
            int tos = Math.max(Math.max(os+arr[i], arr[i]*arr[i]+ns), arr[i]*arr[i]);
            ns = tns;
            os = tos;
            res = Math.max(res, os);
        }
        System.out.println(res);
    }
}
