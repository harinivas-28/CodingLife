package Problems.java;
import java.util.*;
/*
There is a switch-board made by an electrician,
If you turn on any two adjacent switches, it will cause short-circuit
and damage the switch-board.

You are given N integers(only 0's and 1's), Indicates current status of
the switch board with N switches, where 1 indicates switch is ON and 0 indicates
switch is OFF. And an integer K, number of switches to be turned ON.

Return true if and only if you can turn ON all the K switches, without causing 
any damage to switch-board. Otherwise, return false.

Input Format:
-------------
Line-1: Two integers N and K, number of switches, and number of switches to be ON
Line-2: N space separated integers, only 0's and 1's.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5 1
1 0 0 0 1

Sample Output-1:
----------------
true

Sample Input-2:
---------------
5 2	
1 0 0 0 1

Sample Output-2:
----------------
false

*/
public class Day22P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && (i == 0 || nums[i - 1] == 0) && (i == n - 1 || nums[i + 1] == 0)) {
                nums[i] = 1;
                k--;
                if (k == 0) break;
            }
        }
        System.out.println(k == 0);
        sc.close();
    }
}