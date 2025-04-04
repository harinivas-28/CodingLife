package Coding.java;
import java.util.Scanner;
/*
In a forest, There are N redwoord trees in a row.
You are given the heights of the trees as heights[],

You are task is to find the longest tree arrangement as follows:
	- Minimum size of the tree arrangement is 3.
	- And there exist a Tree-'i' with heights[i], where 0 < i < N-1.
		- heights[0] < heights[1] < heights[2] <...< heights[i] and
		-  heights[i] > heights[i+1] > heights[i+2] >...>heights[N-1] 

And return the length of the longest tree arrangement.
If there is no such arrangement, return 0.

Input Format:
-------------
Line-1: An integer N, number of elements.
Line-2: N space separated integers, value of the elements.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
8
4 2 5 7 4 2 3 6

Sample Output-1:
----------------
5

Explanation:
------------
The longest tree arrangement is : 2 5 7 4 2


Sample Input-2:
---------------
4
2 4 5 7

Sample Output-2:
----------------
0
*/

//SELECT * FROM {user} WHERE id = ? AND deleted = ?
//http://10.11.52.200/report/outline/studentreport.php?id=1953&course=1720&mode=outline
//referer:
// http://10.11.52.200/report/outline/studentreport.php?id=1953&course=1720&mode=outline

public class Day19P2 {
    private static int f(int n, int[] a){
        // two pass
        int[] l = new int[n+1];
        int[] r = new int[n+1];
        for(int i=1;i<n;i++){
            if(a[i-1]<a[i]){
                l[i] = l[i-1] + 1;
            }
        }
        for(int i=n-1;i>0;i--){
            if(a[i-1]>a[i]){
                r[i-1] = r[i] + 1;
            }
        }
        // DEBUG CODE
        // for(int i=0;i<n+1;i++){
        //     System.out.print(l[i]+" ");
        // }
        // System.out.println();
        // for(int i=0;i<n+1;i++){
        //     System.out.print(r[i]+" ");
        // }
        // System.out.println();
        int res = 0;
        for(int i=0;i<n+1;i++){
            if(l[i]==0 || r[i]==0) continue;
            res = Math.max(res, l[i]+r[i]+1);
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        
        int r = 0;
        for(int i=0;i<n;i++){
            int st = i, end = i;
            boolean in=false, dec = false;
            while(end<n-1 && a[end]<a[end+1]){
                in = true;
                end++;
            }
            while(in && end<n-1 && a[end]>a[end+1]){
                dec = true;
                end++;
            }
            if(in && dec){
                r = Math.max(r, end-st+1);
            }
        }
        System.out.println(r<2?0:r);
        int res = f(n, a);
        System.out.println(res<2?0:res);
        sc.close();
    }
}
