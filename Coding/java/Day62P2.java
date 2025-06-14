package Coding.java;
import java.util.*;
/*
You write a love letter to your friend. However, before your friend can read it,
someone else takes it and rotates the characters of each word from left to right
K times.

Your task is to determine how many of the words still remain the same even after
this rotation.

Input Format:
-------------
input1: A string containing words separated by spaces.
input2: An integer K indicating the number of right rotations for each word.

Output Format:
--------------
An integer representing the number of words that remain unchanged after K right
rotations.


Sample Input:
-------------
ramram santan nnnn
3

Sample Output:
--------------
2


Sample Input:
-------------
adasda
3

Sample Output:
--------------
0
 */
public class Day62P2 {
    private static String rotate(String s, int n){
        return s.substring(s.length()-n)+s.substring(0, s.length()-n);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = sc.nextInt();
        int cnt = 0;
        for(String s: strs){
            if(n%s.length()==0){
                cnt++;
                continue;
            }
            String rs = rotate(s, n%s.length());
            if(s.equals(rs)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
