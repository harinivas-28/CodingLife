package Coding.java;

import java.util.*;
/*
 * Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]


 */
public class Day27P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        
    }
}
/*
 *  public static void main(String[] arg{
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        List<List<String>> sets = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                i++; 
                StringBuilder sb = new StringBuilder();
                List<String> set= new ArrayList();
                while (s.charAt(i) != ']') {
                    if (s.charAt(i) == ',') {
                         set.add(sb.toString());
                         sb.setLength(0);
                    }
                    else {
                        sb.append(s.charAt(i));
                    }
                    i++;
                }
                set.add(sb.toString());
                sets.add(set);
                i++;
            }
             else {
                StringBuilder sb = new StringBuilder();
                List<String>set= new ArrayList();
                sb.append(s.charAt(i));
                set.add(sb.toString());
                sets.add(set);
                i++;
            }
        }
        List<String> res= new ArrayList();
        backtrack(0,sets,"",res);
        Collections.sort(res); // Lex Order
        System.out.println(res);
    }
    public static  void backtrack(int index,List<List<String>>list, String cur, List<String> res) {
        if(index==list.size()) {
           res.add(cur);
           return;
        }
        for(String s: list.get(index)) {
            backtrack(index+1,list,cur+s,res);
        }
    }
 */