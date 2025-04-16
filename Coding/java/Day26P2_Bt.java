package Coding.java;

import java.util.Scanner;
/*
 * Ramesh and Suresh are best friends. 
They decided to play a word game.

The game rules are as follows:
	- The game board shows a word W consist of two characters only A and B.
	- You are allowed to replace a pair of neighbour letters AA with BB in W.
	- Finally, The one who failed to replace the letters will lose the game.

You can assume that Ramesh will start playing the game always.

Your task is to determine if Ramesh can guarantee a win.
Print 'true', if Ramesh guarantee a win, otherwise, print 'false'.

Input Format:
-------------
A string W, word.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
AAABAAAA

Sample Output-1:
----------------
true

Explanation:
------------
Given word is AAABAAAA 
Ramesh -> AAABBBAA 
Now whatever the pair Suresh replaced with BB, 
one more replace is possible for Ramesh
So, there is a guarantee for Ramesh to win.

Sample Input-2:
---------------
AAAAAA

Sample Output-2:
----------------
true


Sample Input-3:
---------------
AAABAAA

Sample Output-3:
----------------
false

 */
public class Day26P2_Bt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(bT(s));
    }
    private static boolean bT(String s){
        /*
        if(sb.indexOf("AA")==-1){
            return !ram;
        }
        /*
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == 'A' && sb.charAt(i + 1) == 'A') {
                    sb.replace(i, i + 2, "BB");
                    if (!bT(sb, !ram)) {
                        return true;
                    }
                    sb.replace(i, i + 2, "AA");
                }
            }
        /*
        int idx = sb.indexOf("AA");
        sb.replace(idx, idx+2, "BB");
        if(bT(sb, !ram)) return true;
        sb.replace(idx, idx+2, "AA");
        return false; 
        */ 
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='A' && s.charAt(i+1)=='A'){
                String next = s.substring(0, i)+"BB"+s.substring(i+2);
                if(!bT(next)) return true;
            }
        }
        return false; 
    }
}
