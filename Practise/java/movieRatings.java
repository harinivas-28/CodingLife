package Practise.java;
import java.util.*;

/*
 * Alexa loves movies and maintains a list of negative and/or positive integer ratings for the movies in her collection. She's getting ready for a film festival and wants to choose some subsequence of movies from her collection to bring such that the following conditions are satisfied:

The collective sum of their ratings is maximal.

She must go through her list in order and cannot skip more than one movie in a row.

In other words, she cannot skip over two or more consecutive movies. For example, if
ratings = [1, -3, -2], she must include either the second number or the first and third numbers to get a maximal rating sum of -3.

Example
If ratings = [-3, 2, 4, -1, -2, -5],
Her maximal choices are [2, 4, -2] for a sum of 4.

Function Description
Complete the function maximizeRatings in the editor below. The function must return an integer denoting the maximum possible rating sum for Alexa's chosen subsequence of movies without reordering them.

maximizeRatings has the following parameter(s):
ratings(ratings[0],....ratings[n-1]): an array of integers

Constraints:
1 ≤ n ≤ 10^5
-1000 ≤ ratings[i] ≤ 1000, where 0 ≤ i < n

Input
ratings: a list of integers of size n (1 ≤ n ≤ 10^5)
Each ratings[i] (where 0 ≤ i < n) is in the range -1000 to 1000

Sample Case 0
Input
5  
9  
-1  
-3  
4  
5  

Output
17

Explanation
Alexa picks the bolded items in ratings = [9, -1, -3, 4, 5] to get maximum rating:
9 + 4 + 5 = 17.
Thus, the answer is 17.
 */
public class movieRatings {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int res = solve(0, arr);
        sc.close();
        System.out.println(res);
    }
    public static int solve(int idx, int[] arr){
        if(idx>=arr.length) return 0;
        int left = arr[idx] + solve(idx+2, arr);
        int right = solve(idx+1, arr);
        return Math.max(left, right);
    }
}