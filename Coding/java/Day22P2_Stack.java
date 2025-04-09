package Coding.java;
import java.util.*;
/*
Arjun is playing a word game in his tab. When he start the game , It displays a
word and he has to check for any two adjacent characters which are same.If found 
he has to select those two characters by tapping, so that both characters will
be deleted from the word and the word size shrinks by 2. This process to be 
repeated until the word has no two adjacent characters are same.
You task is to help Arjun to perform the above task and Return the final word
obtained.

Input Format:
-------------
Line-1: A string represents the word.

Output Format:
--------------
Return a string or empty string.

Constraints:
------------   
    1 <= word.length <= 10^5   
    word consists only lower case letters.

Sample Input-1:
---------------
pqqprs

Sample Output-1:
----------------
rs

Explanation:
-------------
Initially , Delete two 'q's then the word will be 'pprs'. Now Delete two 'p's 
then the word will be rs.

Sample Input-2:
---------------
pqqqprrs

Sample Output-2:
----------------
pqps

Explanation:
-------------
Initially , Delete two 'q's then the word will be 'pqprrs'. Now Delete two 'r's
then the word will be pqps.

*/
public class Day22P2_Stack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();){
            while(!st.isEmpty() && i<s.length() && st.peek()==s.charAt(i)){
                st.pop();
                i++;
            }
            if(i<s.length()) st.push(s.charAt(i++));
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        System.out.println(sb.reverse().toString());
        sc.close();
    }
}
