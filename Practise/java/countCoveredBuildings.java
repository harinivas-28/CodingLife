package Practise.java;

import java.util.*;

/*
 * Q1. Count Covered Buildings
Medium
4 pt.
You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].

A building is covered if there is at least one building in all four directions: left, right, above, and below.

Return the number of covered buildings.

 

Example 1:



Input: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]

Output: 1

Explanation:

Only building [2,2] is covered as it has at least one building:
above ([1,2])
below ([3,2])
left ([2,1])
right ([2,3])
Thus, the count of covered buildings is 1.
Example 2:



Input: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]

Output: 0

Explanation:

No building has at least one building in all four directions.
Example 3:



Input: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]

Output: 1

Explanation:

Only building [3,3] is covered as it has at least one building:
above ([1,3])
below ([5,3])
left ([3,2])
right ([3,5])
Thus, the count of covered buildings is 1.
 

Constraints:

2 <= n <= 10^5
1 <= buildings.length <= 10^5 
buildings[i] = [x, y]
1 <= x, y <= n
All coordinates of buildings are unique.
 */
public class countCoveredBuildings {
    public static void main(String[] args){
        int n = 3;
        int[][] buildings = {{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}};
        int res = solve(n, buildings);
        System.out.println(res);
    }
    private static int solve(int n, int[][] buildings){
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        for(int[] b: buildings){
            rows.computeIfAbsent(b[0], k -> new ArrayList<>()).add(b[1]);
            cols.computeIfAbsent(b[1], k -> new ArrayList<>()).add(b[0]);
        }
        for(List<Integer> l: rows.values()) Collections.sort(l);
        for(List<Integer> l: cols.values()) Collections.sort(l);
        int res = 0;
        for(int[] b: buildings){
            int a = b[0], c = b[1];
            List<Integer> ll = rows.get(a);
            int idxR = ll.indexOf(c);
            if(idxR==0 || idxR==ll.size()-1) continue;
            List<Integer> l = cols.get(c);
            int idxC = l.indexOf(a);
            if(idxC==0 || idxC==l.size()-1) continue;
            res++;
        }
        return res;
    }
}
