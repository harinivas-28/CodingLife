package Problems.java;
/*

Write Java function to return minimum number of denominations – given an infinite
supply of each denomination of {1, 2, 5, 10, 20, 50, 100, 200,500, 2000} and 
a target value N

Sample Input: 
-------------
187

Sample Output: 
--------------
[100, 50, 20, 10, 5, 2]

*/
import java.util.*;

public class Day57P2 {
    public static void main(String[] args){
        int[] d = new int[]{1, 2, 5, 10, 20, 50, 100, 200,500, 2000};
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer> res= new ArrayList<>();
        for(int i=d.length-1;i>=0;i--){
            if(d[i]<=n){
                int times = n/d[i];
                n %= d[i];
                while(times-->0){
                    res.add(d[i]);
                }
            }
        }
        System.out.println(res);
    }
}