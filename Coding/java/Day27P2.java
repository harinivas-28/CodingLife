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
        List<List<String>> sets = parse(s);
        // System.out.println(sets);
        List<String> res = new ArrayList<>();
        backtrack(0, sets, res, new StringBuilder());
        System.out.println(res);
    }
    private static void backtrack(int idx, List<List<String>> sets, List<String> res, StringBuilder sb){
        if(idx>=sets.size()){
            res.add(sb.toString());
            return;
        }
        for(String s: sets.get(idx)){
            sb.append(s);
            backtrack(idx+1, sets, res, sb);
            sb.setLength(sb.length()-s.length());
        }
    }
    private static List<List<String>> parse(String s){
        return new AbstractList<List<String>>() {
            List<List<String>> sets = null;
            private void build(){
                if(sets!=null) return;
                sets = new ArrayList<>();
                int i = 0;
                while(i<s.length()){
                    if(s.charAt(i)=='['){
                        int st = i+1;
                        while(s.charAt(i)!=']') i++;
                        String[] temp = s.substring(st, i).split(",");
                        List<String> t = new ArrayList<>();
                        for(String x: temp) t.add(x);
                        sets.add(t);
                        i++;
                    } else {
                        int st = i;
                        while(i<s.length() && s.charAt(i)!='[') i++;
                        List<String> t = new ArrayList<>();
                        t.add(s.substring(st, i));
                        sets.add(t);
                    }
                }
                // System.out.println(sets);
            }
            @Override
            public int size() {
                build();
                return sets.size();
            }
            @Override
            public List<String> get(int index) {
                build();
                return sets.get(index);
            }
        };
    }
}
