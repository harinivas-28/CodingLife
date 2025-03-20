package Coding.java;
/*
In a School, the math teacher has given a number N between 1000 to 9999.
He asked the students to create two numbers N1 and N2 using the digits of N,
where each digit must be used only once and N1 and N2 must be between 0 to 999 
(leading 0's are allowed). The sum of  N1 and N2 should be minimum.

Your task is to help the students to find the mimimum sum of N1 and N2 using N.

Input Format:
-------------
An integer N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7512

Sample Output-1:
----------------
42

Explanation:
------------
The possible numbers of N1 and N2 are,
(125,7), (12,57), (157,2), (17,25) or (15,27),..etc.
Among these 17+25 or 15+27 will give the minimum sum.


Sample Input-2:
---------------
5004

Sample Output-2:
----------------
9

*/
import java.util.*;
public class Day12P2_Simple {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i = 0;
        int[] arr = new int[4];
        while(n!=0 && i<4) {
            arr[i++] = n%10;
            n/=10;
        } 
        Arrays.sort(arr);
        int n1 = arr[0]*10 + arr[2];
        int n2 = arr[1]*10 + arr[3];
        // System.out.println(n1+" "+n2+" "+(n1+n2));
        // for(int x: arr) System.out.print(x+" ");
        System.out.println(n1+n2);
        sc.close();
    }
}
