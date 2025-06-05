package Coding.java;
import java.util.Scanner;
/*
Problem 3:
Write a program that finds the longest substring that reads the same forwards
and backwards.

Input:
------
babad

Output:
-------
bab or aba
 */
public class Day58P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = "";
        for(int i=0;i<s.length();i++){
            String p = expand(s, i, i);
            String q = expand(s, i, i+1);
            if(res.length()<p.length()){res = p;}
            if(res.length()<q.length()){res = q;}
        }
        System.out.println(res);
    }
    private static String expand(String s, int l, int r){
        while(r<s.length() && l>=0 && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
