package Coding.java;
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
    }
    private static List<Integer> F(int a, int b){
        int st = 0;
        boolean flag = true;
        for(int i=a;i<=b;i++){
            int temp = i;
            int prev = temp%10;
            i/=10;
            while(temp>0){
                int rem = i%10;
                if(rem>prev || rem!=prev-1){
                    flag = false;
                    break;
                }
                prev = rem;
                temp/=10;
            }
            if(flag){
                st = i;
                break;
            }
        }
        String val = "1";
        int noOfDig = st==0 ? 1 : (int)Math.log10(st) + 1;
        val = val.repeat(noOfDig);
        List<Integer> res = new ArrayList<>();
        for(int i=st;i<=b;i+=Integer.parseInt(val)){
            int t = (int)Math.log10(st)+1;
            if(t>noOfDig) val+='1';
            res.add(i);
        }
        // System.out.println(res);
        return res;
    }
}
