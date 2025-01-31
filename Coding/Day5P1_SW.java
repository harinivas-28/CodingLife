/*
You are given an integer array nums and two integers l and r. Your task is to
analyze the volatility of a sequence of values. The volatility of a sequence is
defined as the difference between the maximum and minimum values in that sequence.

You need to determine the sequence with the highest volatility among all
sequences of length between l and r (inclusive).

Return the highest volatility. If no such sequence exists, return -1.

Input Format:
-------------
Line-1: 3 space separated integers, n, l, r
Line-2: n space separated integers, nums[].

Output Format:
-------------
An integer, the highest volatility.


Sample Input-1:
---------------
5 2 3
8 3 1 6 2

Sample Output-1:
----------------
7

Explanation:
------------
The possible sequences of length between l = 2 and r = 3 are:

[8, 3] with a volatility of 8−3=5
[3, 1] with a volatility of 3−1=2
[1, 6] with a volatility of 6−1=5
[8, 3, 1] with a volatility of 8−1=7
The sequence [8, 3, 1] has the highest volatility of 7.

Sample Input-2:
---------------
4 2 4
5 5 5 5

Sample Output-2:
----------------
0

Explanation:
------------
All possible sequences have no volatility as the maximum and minimum values
are the same, resulting in a difference of 0.

 */

// Using Min and Max variables

// import java.util.*;
// public class Day5P1_CN {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int l = sc.nextInt();
//         int r = sc.nextInt();
//         int[] nums = new int[n];
//         for(int i=0;i<n;i++) nums[i] = sc.nextInt();

//         int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
//         int res = 0;
//         for(int i=l;i<=r;i++){
//             int x=0, y=0;
//             while(y<n){
//                 min = Math.min(min, nums[y]);
//                 max = Math.max(max, nums[y]);
//                 if(y>=i-1){
//                     res = Math.max(res, max-min);
//                     if(nums[x]==min){
//                         min = Integer.MAX_VALUE;
//                         for(int j=x+1;j<=y;j++) min = Math.min(min, nums[j]);
//                     } else if(nums[x]==max){
//                         max = Integer.MIN_VALUE;
//                         for(int j=x+1;j<=y;j++) max = Math.max(max, nums[j]);
//                     }
//                     x++;
//                 }
//                 y++;
//             }
//         }
//         System.out.println(res);
//     }
// }

// Using TreeMap DS

// import java.util.*;
// public class Day5P1_CN {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int l = sc.nextInt();
//         int r = sc.nextInt();
//         int[] nums = new int[n];
//         for(int i=0;i<n;i++) nums[i] = sc.nextInt();

//         int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         int res = 0;
//         for(int i=l;i<=r;i++){
//             int x=0, y=0;
//             while(y<n){
//                 min = Math.min(min, nums[y]);
//                 max = Math.max(max, nums[y]);
//                 map.putIfAbsent(nums[y], nums[y]);
//                 if(y>=i-1){
//                     res = Math.max(res, max-min);
//                     if(nums[x]==min){
//                         min = map.pollFirstEntry().getValue();
//                     } else if(nums[x]==max){
//                         max = map.pollLastEntry().getValue();
//                     }
//                     map.remove(nums[x]);
//                     x++;
//                 }
//                 y++;
//             }
//         }
//         System.out.println(res);
//     }
// }

// Using List

import java.util.*;
public class Day5P1_SW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        int res = 0;
        for(int i=0;i<=(r-l+1);i++){
            int x=0, y=0;
            while(y<n){
                list.add(nums[y]);
                if(y>=i+l-1){
                    int max = Collections.max(list);
                    int min = Collections.min(list);
                    res = Math.max(res, max-min);
                    list.remove(0);
                }
                y++;
            }
        }
        System.out.println(res);
    }
}
