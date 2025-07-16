package Problems.java;
/*
Mr Saurabh is given a list of words.
Your task is to help Mr Saurabh to find the size of largest group

A group is formed using the following rules:
- Pick one smallest word (in length) and form a group with this word
  (if it is not part of any other group yet)
- Add a letter at any place in the word without changing the relative order
  of the letters in it, and if it forms a word which is existing in the list[],
  then add the word to the group.
- Repeat the above two steps, till all the words in the list are part of groups.

NOTE:You move form more than one group.

Input Format:
-------------
Space separated words, wordsList[].

Output Format:
--------------
Print an integer result


Sample Input-1:
---------------
many money n an mony any one mone on

Sample Output-1:
----------------
5

Explanation:
------------
the words group is : [n, on, one, mone, money]


Sample Input-2:
---------------
a ab abb babb abab baba bab abbaa

Sample Output-2:
----------------
4
 */
import java.util.*;
public class Day81P3 {
    static Set<String> set;
    static Map<String, Integer> memo;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();
        set = new HashSet<>(Arrays.asList(arr));
        int res = 1;
        for(String s: arr){
            int t = 1;
            for(int i=0;i<s.length();i++){
                String sb = s.substring(0, i)+s.substring(i+1);
                if(set.contains(sb)){
                    t = Math.max(t, map.get(sb)+1);
                }
            }
            map.put(s, t);
            res = Math.max(res, t);
        }
        // System.out.println(map);
        System.out.println(res);
        int maxLen =  0;
        memo = new HashMap<>();
        for(String x: arr){
            maxLen = Math.max(maxLen, bt(x));
        }
        System.out.println("Recursion: "+maxLen);
    }
    private static int bt(String curr){
        if(memo.containsKey(curr)) return memo.get(curr);
        int max = 1;
        for(int i=0;i<=curr.length();i++){
            for(char c='a';c<='z';c++){
                StringBuilder sb = new StringBuilder(curr);
                sb.insert(i, c);
                String next = sb.toString();
                if(set.contains(next)){
                    max = Math.max(max, 1+bt(next));
                }
            }
        }
        memo.put(curr,max);
        return max;
    }
}
