package Coding.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
You are given two words W1 and W2.
You need find all the mapping of W2 in W1, and 
return all the statrting indices of the mappings.

The mapping of the words w2 and w1 is as follows:
	- A shuffled word contains all the characters as original word.
	The length of the words and occurrence count of each character are same.
	- find shuffled word of W2 as a substring in W1, and 
	return the starting index of substring.


Input Format:
-------------
Single line space separated strings, two words.

Output Format:
--------------
Print the list of integers, indices.


Sample Input-1:
---------------
abcabcabc abc
 
Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6]



Sample Input-2:
---------------
bacacbacdcab cab

Sample Output-2:
----------------
[0, 3, 4, 5, 9]

*/
public class Day18P2_Strings {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        f(w1, w2);
        var r = new ArrayList<Integer>();
        int x = w2.length();
        for(int i=0;i<=w1.length()-x;i++){
            String sub = w1.substring(i, i+x);
            if(eq(sub.toCharArray(), w2.toCharArray())){
                r.add(i);
            }
        }
        System.out.println("Brute Force: "+r);
        sc.close();
    }
    private static boolean eq(char[] s1, char[] s2){
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }
    private static void f(String w1, String w2){
        var res = new ArrayList<Integer>();
        int[] f = new int[26];
        for(char c: w2.toCharArray()){
            f[c-'a']++;
        }
        int[] f2 = new int[26];
        int l = 0;
        for(int r=0;r<w1.length();r++){
            if(r<w2.length()-1){
                f2[w1.charAt(r)-'a']++;
            } else {
                f2[w1.charAt(r)-'a']++;
                if(Arrays.equals(f, f2)){
                    res.add(l);
                }
                f2[w1.charAt(l)-'a']--;
                l++;
            }
        }
        System.out.println("Sliding Window: "+res);
    }
}
