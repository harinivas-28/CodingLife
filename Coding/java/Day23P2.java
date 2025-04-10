package Coding.java;
import java.util.*;
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
public class Day23P2 {
    private static List<Integer> getLine(int n){
        List<Integer> a = new ArrayList<>(Arrays.asList(1));
        if(n==0) return a;
        for(int i=1;i<=n;i++){
            List<Integer> t = new ArrayList<>();
            for(int j=0;j<a.size();j++){
                t.add(j-1>=0 ? a.get(j-1)+a.get(j) : 1);
            }
            t.add(1);
            a = t;
        }
        return a;
    }
    private static void useFormula(int n){
        long val = 1;
        System.out.println(val+" ");
        for(int i=1;i<=n;i++){
            System.out.print(val+" ");
            val = val * (n-i+1)/i;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<Integer> res = getLine(n);
        useFormula(n);
        System.out.println(res);
    }
}
