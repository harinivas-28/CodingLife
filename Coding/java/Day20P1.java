package Coding.java;
import java.util.*;
/*

"Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
goood
good goodd

Sample Output-1:
----------------
1

Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2
*/
public class Day20P1 {
    private static boolean f(String s, String r){
        // heeelllooo hello helo
        int x = s.length(), y = r.length();
        int i = 0, j = 0;
        while(i<x && j<y){
            char c1 = s.charAt(i);
            char c2 = r.charAt(j);
            if(c1!=c2) return false;
            int cnt1= 0, cnt2 = 0;
            while(i<x && s.charAt(i)==c1){
                i++;
                cnt1++;
            }
            while(j<y && r.charAt(j)==c2){
                j++;
                cnt2++;
            }
            if(cnt1<cnt2) return false;
            if(cnt1!=cnt2 && cnt1<3){
                return false;
            }
        }
        return i == x && j == y; 
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.nextLine();
        String[] strs = sc.nextLine().split(" ");
        int cnt = 0;
        for(String r: strs){
            if(f(s, r)){
                cnt++;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}
