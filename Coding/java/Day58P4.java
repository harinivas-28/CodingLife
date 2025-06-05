package Coding.java;
/*
Problem 4:
Write a program that reads a sentence, count and display the total number of
vowels and consonants.

Input:
------
Hello World

Output:
-------
Vowels: 3, Consonants: 7
*/
import java.util.*;

public class Day58P4 {
    public static void main(String[] args){
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        Scanner sc = new Scanner(System.in);
        int v = 0, c = 0;
        String[] strs = sc.nextLine().split(" ");
        for(String s: strs){
            s = s.toLowerCase();
            for(char x: s.toCharArray()){
                if(set.contains(x)) v++;
                else if(x>'a' && x<='z') c++;
            }
        }
        System.out.println("Vowels: "+v+", Consonants: "+c);
    }
}