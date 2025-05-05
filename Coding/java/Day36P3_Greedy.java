package Coding.java;

import java.util.Arrays;
import java.util.Scanner;
/*
 * There are floods in the eastern India.There are infinite number ofboats available
with National Disaster Response force.Where each boat can carry a maximum weight 
limit.

Each boat carries at most two people at same time provided the sum of those people 
is at most limit. 

Return the minimum number of boats to carry every given person to rescue them
 
Input Format
------------
Line1: Two space separated integers, representing no of people and limit of boat
Line2: space separated integers represents weight of each person 

Output Format
-------------
An integer represents minimum no of boats required


Example 1:
-----------
Input1: 2 3
        1 2
Output: 1
Explanation: 1 boat (1, 2)


Example 2:
----------
Input2: 4 3
        3 2 2 1
Output2: 3
Explanation: 3 boats (1, 2), (2) and (3)


Example 3:
----------
Input3: 4 5
        3 5 3 4
Output3: 4
Explanation: 4 boats (3), (3), (4), (5)
 */
public class Day36P3_Greedy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), lim = sc.nextInt();
        int[] wts = new int[n];
        for(int i=0;i<n;i++) wts[i] = sc.nextInt();
        
        // Thread t1 = new Thread(()->Arrays.sort(wts));
        // t1.start();
        // try{t1.join();}
        // catch(Exception e){}
        Arrays.sort(wts);
        int cnt=0;
        int s=0,e=n-1;
        while(s<=e){
            if(wts[s]+wts[e]<=lim){
                s++;
            }
            e--;
            cnt++;
        }
        sc.close();
        System.out.println(cnt);
    }
}
