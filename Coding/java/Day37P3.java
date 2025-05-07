package Coding.java;
import java.util.*;
/*There are N people having some amount in their credit cards, both +ve or -ve.
You are given the amounts as an integer array cards[], in rupees.

You are allowed to perform only one operation:
    - pick N-1 credit cards add 1rupee to each card.
    
Your task is to return the minimum number of operations required to
make all the credit cards to have the same amount.

Input Format:
-------------
Line-1: An integer N
Line-2: N space separated integers, cards[]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
4
2 5 4 3

Sample Output-1:
----------------
6

Explanation:
------------
6 operations are required.
[2, 5, 4, 3]  =>  [3, 5, 5, 4]  =>  [4, 5, 6, 5]  =>  [5, 6, 6, 6]
=>  [6, 7, 7, 6] => [7, 8, 7, 7] => [8, 8, 8, 8]


Sample Input-2:
---------------
5
4 5 9 8 5

Sample Output-2:
----------------
11
*/
public class Day37P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]= sc.nextInt();
        System.out.println("Brute Force: "+bruteForce(arr));
        System.out.println("Optimized: "+opt(arr));
        sc.close();
    }
    private static int opt(int[] arr){
        int n = arr.length;
        int min = Arrays.stream(arr).min().getAsInt();
        int ops = 0;
        for(int i=0;i<n;i++){
            ops += arr[i]-min;
        }
        return ops;
    }
    private static int bruteForce(int[] arr){
        int n = arr.length;
        int[] freq = new int[1000000];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int t = arr[i];
            freq[t]++;
            pq.offer(t);
        }
        if(freq[pq.peek()]==n) {System.out.println(0);return 0;}
        int cnt = 0;
        while(true){
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<n-1;i++){
                int val = pq.poll();
                freq[val]--;
                val++;
                freq[val]++;
                l.add(val);
            }
            cnt++;
            pq.addAll(l);
            if(freq[pq.peek()]==n){
                break;
            }
        }
        return cnt;
    }
}
