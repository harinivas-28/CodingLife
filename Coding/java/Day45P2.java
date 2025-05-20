package Coding.java;
import java.util.*;
/*
Arjun wants to build some homes in a land of size R*C.
He wanted to construct homes in rectangular shape.
The place which is remained will be used for gradening.
Accordingly, he has prepared the plan and given as
a 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

A home is set of cells with value 1 in rectangular shape.
He wants to findout all the homes in the plan and store their co-ordinates in
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate
(bottom right corner) of i-th home.

Your task is to help Arjun to find all the homes and return the coords[][] of
all the homes from top left corner to bottom right corner.

NOTE: No two homes are adjacent to each other in 4 directions,
(left, right, top, bottom).

Input Format:
-------------
Line-1: Two integers R and C, size of the land.
Next R lines: C space separated integers, either 0 or 1
0- represents garden area land and 1- represents the home.

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.


Sample Input-1:
---------------
2 3
1 0 0
0 1 1

Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]


Sample Input-2:
---------------
4 4
1 1 0 1
0 0 0 0
1 1 0 1
1 1 0 1

Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]

 */
public class Day45P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m =sc.nextInt(), n = sc.nextInt();
        int[][] g = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                g[i][j]= sc.nextInt();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j]==1){
                    int[] ys = solve(g, i, j);
                    res.add(Arrays.asList(i, j, ys[0], ys[1]));
                }
            }
        }
        for(List<Integer> b: res){
            System.out.println(b);
        }
    }
    private static int[] solve(int[][] g, int i, int j){
        int stCol = j;
        while(j<g[0].length && g[i][j]==1){
            j++;
        }
        int endCol = j-1;
        int stRow = i;
        while(stRow<g.length) {
            boolean valid = true;
            for(int x = stCol; x <= endCol; x++){
                if(g[stRow][x] != 1){
                    valid = false;
                    break;
                }
            }
            if(!valid) break;
            stRow++;
        }
        int endRow = stRow-1;
        for(int r = i; r <= endRow; r++){
            for(int c = stCol; c <= endCol; c++){
                g[r][c] = 0;
            }
        }
        return new int[]{endRow, endCol};
    }
}
