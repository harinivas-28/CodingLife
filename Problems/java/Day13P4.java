package Problems.java;
/*
A digit sum is the sum of all the digits of a number.
e.g., 123=> 1 + 2 + 3 => 6, So, digit sum of 123 is 6.

You are given an integer N. 
Find the digit sum of each number from 1 to N.
And group them according to their digit sum.

Your task is to find and print the number of groups have the largest size.

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer, number of groups with largest size.

Sample Input-1:
---------------
13

Sample Output-1:
----------------
4

Explanation:
------------
There are 9 groups formed: [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. 
There are 4 groups having largest size-2.


Sample Input-2:
---------------
24

Sample Output-2:
----------------
5
*/
import java.util.*;

public class Day13P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int i=1;i<=n;i++){
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0)+1);
            max = Math.max(max, map.get(sum));
        }
        for(int val: map.values()){
            if(val==max) res++;
        }
        // System.out.println(map);
        System.out.println(res);
        sc.close();
    }
    private static int digitSum(int n){
        int sum = 0;
        while(n>0){
            sum += (n%10);
            n/=10;
        }
        return sum;
    }
}
