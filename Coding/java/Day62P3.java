package Coding.java;
import java.util.*;
/*
A group of students is forming a tech club, and they are
interviewing K × K students. Each student has two skill levels:
 - Mathematics (M)
 - Physics (P)
These skill levels range from 0 to K-1.

They want to form committees of size N under the following
conditions:
 - All members of a committee must have different Mathematics
   skill levels.
 - All members must have different Physics skill levels.
 - For any two students in the committee, the difference of their
   Math skills must not equal the difference of their Physics skills,
   i.e., |M1 - M2| != |P1 - P2|

Input Format:
-------------
input1: Integer N – desired committee size
input2: Integer K – number of skill levels for Math and Physics
(total students = K × K)

Output Format:
--------------
An integer representing the number of valid committees of size N
that can be formed from the K × K students. Return the result
modulo 10^9 + 7.

Sample Input:
-------------
2
3

Sample Output:
--------------
8

Explanation:
------------
Examples of some valid pairs:
(0,0) and (1,2) → |0-1| = 1, |0-2| = 2
(0,1) and (1,0) → |0-1| = 1, |1-0| = 1  (same diff → invalid)
(0,0) and (2,1) → |0-2| = 2, |0-1| = 1

8 Valid Pairs:
1. (0,0) - (1,2)
2. (0,0) - (2,1)
3. (0,1) - (2,0)
4. (0,2) - (1,0)
5. (0,2) - (2,1)
6. (1,0) - (2,2)
7. (1,2) - (0,0)
8. (1,2) - (2,0)

Sample Input:
-------------
2
2

Sample Output:
--------------
0
 */
public class Day62P3 {
    private static final int MOD = 1_000_000_000 + 7;
    private static boolean isValid(List<int[]> com){
        Set<Integer> math = new HashSet<>();
        Set<Integer> phy = new HashSet<>();
        for(int[] x: com){
            int m1 = x[0], p1 = x[1];
            if(!math.add(m1) || !phy.add(p1)) return false;
            for(int[] y: com){
                if(x==y) continue;
                int m2 = y[0], p2 = y[1];
                if(Math.abs(m1-m2)==Math.abs(p1-p2)) return false;
            }
        }
        return true;
    }
    private static int solve(List<int[]> st, List<int[]> com, int idx, int n){
        if(com.size()==n){
            return isValid(com) ? 1: 0;
        }
        if(idx>=st.size()) return 0;
        int res = solve(st, com, idx+1, n)%MOD;
        com.add(st.get(idx));
        res = (res+solve(st, com, idx+1, n))%MOD;
        com.remove(com.size()-1);
        return res;
    }
    private static int formCommittee(int n, int k) {
        List<int[]> st = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                st.add(new int[]{i, j});
            }
        }
        return solve(st, new ArrayList<>(), 0, n);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        System.out.println(formCommittee(n, k));
    }
}
