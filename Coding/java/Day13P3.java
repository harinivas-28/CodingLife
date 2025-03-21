package Coding.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Pascal's Triangle looks like below:
			1
		  1  1
		1  2  1
	  1  3  3  1
ans so on... You can create N number of rows, rows are indexed from 0 onwards.

You are given an integer N,
Your task is to print N-th index Row of the Pascal's Triangle.

Input Format:
-------------
An integer N, index number.

Output Format:
--------------
Print the n-th index row of Pascal's Triangle.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
1 1


Sample Input-2:
---------------
3

Sample Output-2:
----------------
1 3 3 1

*/
public class Day13P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Long> res = new ArrayList<>();
        res.add((long)1);
        for(int r=1;r<=n;r++){
            long nxt = res.get(r-1)*(n-r+1)/r;
            res.add(nxt);
        }
        for(long x: res){
            System.out.print(x+" ");
        }
        sc.close();
    }
}
