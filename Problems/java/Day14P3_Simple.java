package Problems.java;
import java.util.*;
/*
 * You are given a list of positive integers List[].
You need to findout the product P as (List[i]-1)*(List[j]-1).
Where P should be the largest possible value, 
and i, j are the postions of the two different elements in the List.

Input Format:
-------------
Line-1: An integer N, number of elemenets of the list.
Line-2: N space separated integers, List[], where list[i] >0

Output Format:
--------------
Print an integer, P


Sample Input-1:
---------------
4
3 4 5 2

Sample Output-1:
----------------
12


Sample Input-2:
---------------
4
2 5 4 5

Sample Output-2:
----------------
16

 */
public class Day14P3_Simple {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        System.out.println((arr[n-1]-1)*(arr[n-2]-1));
        sc.close();
    }
}
