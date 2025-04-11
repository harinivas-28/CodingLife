package Coding.java;
import java.util.*;
/* 
Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15
sample output-2
---------------
2,13


*/
public class Day24P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] arr1 = new int[a];
        for(int i=0;i<a;i++) arr1[i] = sc.nextInt();
        
        int b = sc.nextInt();
        int[] arr2 = new int[b];
        for(int i=0;i<b;i++) arr2[i] = sc.nextInt();
        
        int target = sc.nextInt();
        sc.close();
        int f = 0, s = 0;
        int minDist = Integer.MAX_VALUE;
        for(int i=0;i<a;i++){
            for(int j=b-1;j>=0;j--){
                int val = Math.abs(target-(arr1[i]+arr2[j]));
                if(minDist>val){
                    minDist = val;
                    f = arr1[i];
                    s = arr2[j];
                }
            }
        }
        System.out.println(f+","+s);
        opt(a, b, arr1, arr2, target);
    }    
    private static void opt(int a, int b, int[] arr1, int[] arr2, int target){
        int minDist = Integer.MAX_VALUE, f = 0, s = 0; 
        for(int x: arr1){
            int val = bS(arr2, target - x); 
            if(val != -1){
                int dist = Math.abs(target - (x + val));
                if(dist < minDist){
                    minDist = dist;
                    f = x;
                    s = val;
                }
            }
        }
        System.out.println(f + "," + s);
    }

    private static int bS(int[] arr, int target){
        int low = 0, high = arr.length - 1; 
        int closest = -1, minDiff = Integer.MAX_VALUE;
        while(low <= high){ 
            int mid = (low + high) / 2;
            int diff = Math.abs(target - arr[mid]);
            if(diff < minDiff || (diff == minDiff && arr[mid] < closest)){
                minDiff = diff;
                closest = arr[mid];
            }
            if(arr[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return closest;
    }
}
