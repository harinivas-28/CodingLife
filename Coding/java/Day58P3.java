package Coding.java;
/*
Write a Java Program to read a sentence and print each word reversed, but
maintain the original word order.

Input:
------
Java is fun

Output:
-------
 avaJ si nuf
*/
import java.util.*;

public class Day58P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        for(String s: strs){
            for(int i=s.length()-1;i>=0;i--){
                System.out.print(s.charAt(i));
            }
            System.out.print(" ");
        }
        sc.close();
    }
}