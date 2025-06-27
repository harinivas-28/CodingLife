package Coding.java;

import java.util.Scanner;

/*
Bunny is playing with binary strings. He wants to break
a binary string B into 3 parts, of length atleast '1',
when we merge the 3 parts will result the string B.

Your task is to find the count the various forms to break
the Binary String B into 3 parts, where each part should
contain equal number of 1's.


Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, count the various forms to break.


Sample Input-1:
---------------
01010010

Sample Output-1:
----------------
6

Explanation:
------------
There are six forms to break S into 3 parts
where each part contain the equal number of  1's.
01 | 01 | 0010
01 | 010 | 010
01 | 0100 | 10
010 | 1 | 0010
010 | 10 | 010
010 | 100 | 10


Sample Input-2:
---------------
010010

Sample Output-2:
----------------
0
 */
public class Day68P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int totalOnes = 0;
        for(char c: s.toCharArray()){
            if(c=='1') totalOnes++;
        }
        if(totalOnes%3!=0){
            System.out.println(0);
            return;
        }
        if(totalOnes==0){
            long res = ((long)(n-1)*(n-2))/2;
            System.out.println(res);
            return;
        }
        int onesPerPart = totalOnes/3;
        int cnt = 0, firstCutWays=0, secondCutWays = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1') cnt++;
            if(cnt==onesPerPart) firstCutWays++;
            else if(cnt==2*onesPerPart) secondCutWays++;
        }
        long res = (long)firstCutWays*secondCutWays;
        System.out.println(res);
    }
}
