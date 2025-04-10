package Coding.java;
import java.util.*;
/*
MotorSport Ltd hosting a Racing Championship. 
Ajith is participating in car races. Each race start and end in perticular time intervals.

You are given an array of racing time intervals consisting of
start and end times [[s1,e1],[s2,e2],...] (s < e ) of N races, in which Ajith has to participate.
Your task is to determine whether Ajith can participate in all the races or not.

NOTE: If a race starts at time 'a' ends at time 'b', 
another race can start at 'b'.

Input Format:
-------------
Line-1: An integer N, number of races Ajith has to participate.
Next N lines: Two space separated integers, start and end time of each race.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
3
0 30
5 10
15 20

Sample Output-1:
----------------
false

Sample Input-2:
---------------
3
0 10
15 25
30 35

Sample Output-2:
----------------
true

*/
public class Day23P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<int[]> l = new ArrayList<>();
        int n = sc.nextInt();
        sc.close();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            l.add(new int[]{a, b});
        }
        Collections.sort(l, (a,b)->a[0]-b[0]);
        int end = l.get(0)[1];
        for(int i=1;i<l.size();i++){
            if(l.get(i)[0]<end || l.get(i)[1]<=end){
                System.out.println(false);
                return;
            }
            end = Math.max(end, l.get(i)[1]);
        }
        System.out.println(true);
    }    
}
