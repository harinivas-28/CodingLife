package Problems.java;
/*
Mr Sudhakar is working with Strings,
He is given a String S, He wants to sort the characters in S in descending order
based on the frequency of the characters. If two or more characters have same
frequency then arrange them in sorted-order.

Your task is to help Mr Sudhakar to convert the string S into sorted order of
frequency.

Note: The frequency of a character is the number of times it appears in the string.

Input Format:
----------------
A String S, conatins bothe lower case and upper case letters.

Output Format:
------------------
Print a string after conversion.


Sample Input-1:
---------------
divide

Sample Output-1:
----------------
ddiiev

Explanation:
------------
d and e have same frequecy and i and v have same frequency.
So sorted-order is ddeevi.


Sample Input-2:
---------------
TomAto

Sample Output-2:
----------------
ooATmt


Sample Input-3:
---------------
rrrppp

Sample Output-3:
----------------
ppprrr
*/
import java.util.*;
public class Day80P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Character> l = new ArrayList<>(map.keySet());
        l.sort((a, b)->{
            int f = Integer.compare(map.get(a), map.get(b));
            if(f==0){
                return Character.compare(a, b);
            }
            return f;
        });
        StringBuilder res = new StringBuilder();
        for(char c: l){
            res.append(String.valueOf(c).repeat(map.get(c)));
        }
        System.out.println(res.toString());
    }
}
