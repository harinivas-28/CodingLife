package Problems.java;
/*
Prabhath is working on words.  He used to take out every letter that was repeated
in the word.
A word W is given to Prabhath. His objective is to eliminate every duplicate
letter from W such that the resultant word R contains every unique letter from W
and did not contain any duplicate letters.
And R should be at the top of the dictionary order.

NOTE:
-----
He is not allowed to shuffle the relative order of the letters of the word W to
create the word R.

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resultant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos
 */
import java.util.*;
public class Day73P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] lastInd = new int[26];
        for(int i=0;i<s.length();i++){
            lastInd[s.charAt(i)-'a'] = i;
        }
        boolean[] vis = new boolean[26];
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(vis[c-'a']) continue;
            while(!dq.isEmpty() && dq.peekLast()>c && lastInd[dq.peekLast()-'a']>i){
                vis[dq.removeLast()-'a'] = false;
            }
            dq.addLast(c);
            vis[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: dq) sb.append(c);
        System.out.println(sb.toString());
    }
}
