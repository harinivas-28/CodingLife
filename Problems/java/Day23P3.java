package Problems.java;
import java.util.*;
/*
Nehanth, a bubbly kid playing with digits and creating numbers using them.
The kid is creating the number called successive number. 
A number is called successive number, if and only if 
each digit in the number is one less than the next digit.

You are given two integers, start and end, both are inclusive.
Your task to find and print all the successive numbers in the given range (start, end).

Input Format:
-------------
Two space separated integers, start and end

Output Format:
--------------
Print the list of successive numbers in the range(start, end).


Sample Input-1:
---------------
50 150

Sample Output-1:
----------------
[56, 67, 78, 89, 123]


Sample Input-2:
---------------
100 600

Sample Output-2:
----------------
[123, 234, 345, 456, 567]

*/
public class Day23P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        // BRUTE FORCE
        List<Integer> res = new ArrayList<>();
        for(int i=a;i<=b;i++){
            int temp = i;
            int prev = temp%10;
            boolean flag = true;
            temp/=10;
            while(temp>0){
                int rem = temp%10;
                if(rem>prev || rem!=prev-1){
                    flag = false;
                    break;
                }
                prev = rem;
                temp/=10;
            }
            if(flag){
                res.add(i);
            }
        }
        System.out.println(res);
        List<Integer> t = F(a, b);
        System.out.println(t);
        // optimized
        List<Integer> res2 = optimized(a, b);
        System.out.println(res2);
    }
    private static List<Integer> optimized(int a, int b){
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            int num = i;
            int next = i;
            while(next<9){
                next++;
                num = num*10 + next;
                if(num>b) break;
                if(num>=a) res.add(num);
            }
        }
        return res;
    }
    private static List<Integer> F(int a, int b){
        int st = a, end = b;
        String h = "0123456789";
        boolean f = true;
        int min_length = 0;
        while(f){
            if(h.indexOf(String.valueOf(a))!=-1){
                f = false;
                min_length = noOfDigits(a);
            }
            a++;
        }
        int max_length = 0;
        while(!f){
            if(h.indexOf(String.valueOf(b))!=-1){
                f = true;
                max_length = noOfDigits(b);
            }
            b--;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=min_length;i<=max_length;i++){
            for(int j=0;j<=h.length()-i;j++){
                int val = Integer.parseInt(h.substring(j, j+i));
                if(val>=st && val<=end){
                    res.add(val);
                }
            }
        }
        return res;
    }
    private static int noOfDigits(int n){
        return n==0 ? 1 : (int)Math.log10(n)+1;
    }
}
