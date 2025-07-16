package Problems.java;
import java.util.*;
/*
Ram and Bheem are using a Desktop Computer.One day they found that keyboard 
is defective in which if you type backspace button,it will print '$', 
instead of removing one previous character.

Bheem and Ram have tried to type one word each on the same keyboard.
Return true, if both tried to type the same word. Otherwise return false.

Note:backspace for an empty text will continue empty.

Input Format:
-------------
Line-1:Two space seperated strings represents words w1,w2.

 
Output Format:
--------------
Print a boolean result.
 
Constraints:

    1 <= w1.length, w2.length <= 200
    w1 and w2 only contain lowercase letters and '$' characters.


 
Sample Input-1:
---------------
pq$r  pt$r

Sample Output-1:
----------------
true

Explanation:
------------
Both wants to type 'pr'

Sample Input-2:
---------------
se$$at cea$$t

Sample Output-2:
----------------
false

Sample Input-3:
---------------
s$$at ce$$at

Sample Output-2:
----------------
true

Explanation:
------------
Both wants to type 'at'.
*/
public class Day15P2_Stack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        Stack<Character> st1 = new Stack<>();
        for(char c: str[0].toCharArray()){
            if(c=='$'){if(!st1.isEmpty()) st1.pop();}
            else st1.push(c);
        }
        Stack<Character> st2 = new Stack<>();
        for(char c: str[1].toCharArray()){
            if(c=='$'){if(!st2.isEmpty()) st2.pop();}
            else st2.push(c);
        }
        if(st1.size()!=st2.size()){
            System.out.println(false);
            sc.close();
            return;
        }
        String r1 = "", r2 = "";
        while(!st1.isEmpty()) r1 += st1.pop();
        while(!st2.isEmpty()) r2 += st2.pop();
        System.out.println(r1.equals(r2));
        sc.close();
    }
}