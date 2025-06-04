package Coding.java;
/*
Problem: Write a program to count each word's first index and total occurrences 
in a sentence.

Sample Input: 
apple banana apple orange banana apple

Sample Output:
apple -> first index: 0, count: 3
banana -> first index: 6, count: 2
orange -> first index: 19, count: 1

*/
import java.util.*;

public class Day57P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        Map<String, Integer> ind = new HashMap<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int idx = 0;
        for(String x: arr){
            if(!ind.containsKey(x)){
                ind.put(x, idx);
            }
            map.put(x, map.getOrDefault(x, 0)+1);
            idx += x.length()+1;
        }
        for(String k: map.keySet()){
            System.out.println(k+" -> first index: "+ind.get(k)+", count: "+map.get(k));
        }
    }
}