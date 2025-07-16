package CompanyQuestions;
import java.util.*;
/*
Question: 11

Tech Club Committee Selection Problem

A group of students is planning to form a tech club and the club is open for recruitment.
They are interviewing students and marking the skill levels in Mathematics and Physics of the `ith` student as `(M, P)` respectively.
They will be segregating the selected students into committees, and for better efficiency they have a few conditions:

1. All members of a committee should have different skill levels in Mathematics
2. All members of a committee Should have different skill levels in Physics .
3. The difference in the skill level for Mathematics and Physics for two students should not be the same.
       |M1 - M2|should not be equal to |P1 - P2|.


you are given an integer N representing the size of a committee and an integer K. representing that K*K students are being interviewed .
Your task is to return an integer value representing the number of ways in which the committees can be formed.

note:

* The answer should be returned after performing the modulo operation with 10^4
* The skill level for K students (k>1) will be (0,0),(0,1)...(k-1,k-1) respectively.

Input Specification:
--------------------
* input1: An integer value `N` representing the size of a committee.
* input2: An integer value `K` representing that `K * K` students are being interviewed.

output specification:
---------------------
Return an integer value representing the number of ways in which committees can be formed.

Example 1:
---------
input1: 2
input2: 3

Output:
8


Explanation:
-----------
The number of students being interviewed is 3*3=9 and the number of members in a committee is 2.
The number of ways in which committees can be forn=med while satisfying the conditions is as under

--------------------------------------------------------------
|	                   |   student 1                      |       student 2                     |
|Committees  |(mathematics,physics) | (mathematics,physics)   |
|-------------------------------------------------------------                                 |
|1	                  |      (0,0)	    |	   (1,2)              |
|2	     |      (0,0)	    |	   (2,1)              |
|3	     |	    (0,1)	    |	   (2,0)              |
|4	     |      (0,1)	    |	   (2,2)              |
|5	     |      (0,2)	    |	   (1,0)              |
|6	     |      (0,2)	    |	   (2,1)              |
|7	     |      (1,0)	    |	   (2,2)              |
|8	     |      (1,2)	    |	   (2,0)              |
---------------------------------------------------------------

Since 8 committees can be formed, 8 is returned as the output.

Example 2:
----------
input1: 2
input2: 2

Output:
0


Explanation:
------------
The number of students being interviewed is 2*2=4 and the number of members in the committee is 2.
The students being interviewed possess mathematics and physics skills as under:(0,0),(0,1) and (1,1).
 * (1,1) and (0,0) cannot be together as the difference of their
    Mathematics and physics skills is the Same.
 * (0,0) cannot be in the same committee as (0,1) or (1,0)
    because they have the same Mathematics and physics skills respectively.
 *  Similarly (1,1) cannot be in the same committee as (0,1) or (1,0).

There is no way in which a committee which satisfies the given conditions can be formed.Therefore 0 is returned as the output.

 */
public class CommitteeSelection {
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
