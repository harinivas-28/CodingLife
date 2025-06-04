package Coding.java;
/*
Write Java code for a method which takes a String (a sentence) as input 
and returns a HashMap. The Map key is String (word in the String) and 
value is frequency of the word in the given sentence.
(In the words ignore any special characters)

Sample Input:
---------------
Java is fun, and Ja#va@ is powerful 

Sample Output:
-----------------
java: 2
is: 2
fun: 1
and: 1
powerful: 1

*/
import java.util.*;

public class Day56P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String lowerS = s.toLowerCase();
        String filter = removeSymb(lowerS);
        String[] arr = filter.split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String x: arr){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        // System.out.println(map);
        for(String k: map.keySet()){
            System.out.println(k+": "+map.get(k));
        }
        sc.close();
    }
    private static String removeSymb(String s){
        String res = "";
        for(char c: s.toCharArray()){
            if(Character.isLowerCase(c)){
                res += c;
            } else if (c==' '){
                res += c;
            }
        }
        return res;
    }
}