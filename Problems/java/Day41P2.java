package Problems.java;
import java.util.*;
/*
Venkatadri is a maths teacher.
He is teaching matrices to his students.
He is given a matrix of size m*n, and it contains only positive numbers.
He has given a task to his students to find the special matrix,
in the iven matrix A[m][n].
A special matrix has following property:
	- The sum of elements in each row, each column and the two diagonals are equal.
	- Every 1*1 matrix is called as a special matrix.
	- The size of the special matrix should be a square, i.e., P*P.

Your task is to help the students to find the speical matrix  with max size P.


Input Format:
-------------
Line-1: Two space separated integers M and N, size of the matrix.
Next M lines: N space separated integers m and n.

Output Format:
--------------
Print an integer, maximum size P of the special matrix.


Sample Input-1:
---------------
5 5
7 8 3 5 6
3 5 1 6 7
3 5 4 3 1
6 2 7 3 2
5 4 7 6 2

Sample Output-1:
----------------
3

Explanation:
------------
The special square is:
5 1 6
5 4 3
2 7 3


Sample Input-2:
---------------
4 4
7 8 3 5
3 2 1 6
3 2 3 3
6 2 3 3

Sample Output-2:
----------------
2

Explanation:
------------
The special square is:
3 3
3 3

 */
public class Day41P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] g = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                g[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int s = Math.max(m, n);
        int[][] rowSum = new int[m][n+1];
        int[][] colSum = new int[n][m+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rowSum[i][j+1] = rowSum[i][j] + g[i][j];
                colSum[j][i+1] = colSum[j][i]+g[i][j];
            }
        }
        for(int k=s;k>=1;k--){
            for(int i=0;i<=m-k;i++){
                for(int j=0;j<=n-k;j++){
                    if(sp(g, rowSum, colSum, i, j, k)){
                        System.out.println(k);
                        return;
                    }
                }
            }
        }
    }
    private static boolean sp(int[][] g, int[][] rowSum, int[][] colSum, int i, int j, int k){
        int tar = rowSum[i][j+k]-rowSum[i][j];
        for(int x=0;x<k;x++){
            int sum = rowSum[x+i][j+k]-rowSum[x+i][j];
            if(sum!=tar) return false;
        }
        for(int x=0;x<k;x++){
            int sum = colSum[j+x][i+k] -colSum[j+x][i];
            if(sum!=tar) return false;
        }
        int sum = 0;
        for(int x=0;x<k;x++){
            sum += g[i+x][j+x];
        }
        if(sum!=tar) return false;
        sum = 0;
        for(int x=0;x<k;x++){
            sum += g[i+x][j+k-x-1];
        }
        return sum == tar;
    }
}
