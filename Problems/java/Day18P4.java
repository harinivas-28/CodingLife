package Problems.java;
import java.util.Scanner;
/*
 * Ramesh and Suresh are playing a game.
Initially, Ramesh has a secret number, and Suresh has to guess that number.
Ramesh now checks, How many digits of the guess number match 
the secret number exactly, if both the digit and position are matched, 
indicate them as Apples. If the digit is matched and position is different, 
indicate them as Bananas.

Ramesh will give a hint to Suresh as follows:
e.g., secret number= 1231, and guess number = 4213
Only digit=2 is matching, so apple is 1, banana is 2
Ramesh tell the answer as 1A2B

You are given secrect number and guess number as strings,
Your task to help Ramesh, to find and return the HINT.

NOTE: The length of the both secrect and guess number is same, 
		contains only digits.

Input Format:
-------------
Two strings, secret and guess

Output Format:
--------------
Print the string, the HINT.


Sample Input-1:
---------------
1807 7810

Sample Output-1:
----------------
1A3B

Explanation: 
------------
1 Apple and 3 Banana. Apple is 8, Banana are 0, 1 and 7.


Sample Input-2:
---------------
1123 0111

Sample Output-2:
----------------
1A1B

Explanation: 
------------
The 1st 1 in Suresh guess is an Apple, the 2nd or 3rd 1 is B.

 */
public class Day18P4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String r = sc.next();
        int a = 0, b = 0;
        int[] freq = new int[10];
        for(char c: s.toCharArray()) freq[c-'0']++;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==r.charAt(i)){
                freq[r.charAt(i)-'0']--;
                a++;
            } else if(freq[r.charAt(i)-'0']>0){
                freq[r.charAt(i)-'0']--;
                b++;
            }
        }
        System.out.println(a+"A"+b+"B");
        sc.close();
    }
}
