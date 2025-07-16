package Problems.java;
/*
Problem 1:
Write a java program that reads a sentence and counts how many times each word
appears. Display only the words that occur more than once.

Input:
------
this is a test this test is easy

Output:
-------
this -> 2
is -> 2
test -> 2
*/
import java.util.*;

public class Day58P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String s: strs){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for(String k: map.keySet()){
            if(map.get(k)>1){
                System.out.println(k+" -> "+map.get(k));
            }
        }
    }
}
