package Problems.java;
import java.util.*;
/*
Given a integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, where two consecutive 
values in BCS having N bits, must have one bit difference only. 
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

*/
public class Day27P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        Set<Integer> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder("0".repeat(n));
        solve(sb, set);
        System.out.println(set);

        set.clear();
        BitSet bs = new BitSet();
        solve(bs, set, n);
        System.out.println(set);
    }

    private static int toInt(BitSet bs, int n) {
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (bs.get(i)) {
                // val += Math.pow(2, i);
                val += (1<<i);
            }
        }
        return val;
    }

    private static void solve(BitSet bs, Set<Integer> set, int n) {
        int num = toInt(bs, n);
        if (set.contains(num)) return;
        set.add(num);
        
        for (int i = 0; i < n; i++) {
            BitSet nextBs = (BitSet) bs.clone();
            nextBs.flip(i);
            int nextNum = toInt(nextBs, n);
            if (!set.contains(nextNum)) {
                solve(nextBs, set, n);
            }
        }
    }
    private static void solve(StringBuilder sb, Set<Integer> set){
        int num = Integer.parseInt(sb.toString(), 2);
        if(set.contains(num)) return;
        set.add(num);
        for(int i=sb.length()-1;i>=0;i--) {
            sb.setCharAt(i, sb.charAt(i)=='1' ? '0' : '1');
            num = Integer.parseInt(sb.toString(), 2);
            if(set.contains(num)) {
                sb.setCharAt(i, sb.charAt(i)=='1' ? '0' : '1');
                continue;
            }
            solve(sb, set);
        }
    }
}
