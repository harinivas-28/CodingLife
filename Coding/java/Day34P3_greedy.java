package Coding.java;
import java.util.*;
/*
 * In a garden, there is a row of plants. The gardener need to water them regularly.
In the row of plants, some are empty places some are plants. you need to setup 
the watering res to water the row of plants at the empty places. A watering kit
can supply water to its adjacent plants, i.e., if the watering kit is at 
i-th position it can water the plants ar 'i+1'-th and 'i-1'-th  positions.

You are given a string 'plants', consists of two characters only [P,E], where P 
indiactes plant and E indicates empty place.

Your task is to return the minimum number of watering res needed so that 
for every plant, the gardener can supply the water to all the plants in that 
row OR -1 if it is impossible.


Input Format:
-------------
A string, consists of only two characters P and E

Output Format:
--------------
Print an integer result, the minimum num of watering res.


Sample Input-1:
---------------
PEEEPEP

Sample Output-1:
----------------
2

Explanation: 
------------
You can setup watering res at index-1, index-5, so all the 3 plants gets water.


Sample Input-2:
---------------
PEPEEPP

Sample Output-2:
----------------
-1

Explanation: 
------------
No empty place after the last plant in the row, so retrun -1.
 */
public class Day34P3_greedy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        if(s.indexOf("PPP")!=-1 || s.startsWith("PP") || s.endsWith("PP")){
            System.out.println(-1);
            return;
        }
        int n = s.length(),cnt=0, res = 0;
        for(char c:s.toCharArray()){
            if(c=='P') cnt++;
        }
        int i =1;
        while(i<n-1){
            if(s.charAt(i-1)=='P'&&s.charAt(i+1)=='P'){
                cnt=cnt-2;
                res++;
                i=i+2;
            }
            i++;
        }
        System.out.println(res+cnt);
    }  
}
