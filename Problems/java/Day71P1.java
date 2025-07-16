package Problems.java;
/*
Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above,
Can you help Naresh to convert iven expression into a list of words, in
lexicographical order.

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
// GT 3 Program 1
import java.util.*;
public class Day71P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<List<String>> l = new ArrayList<>();
        for(int i=0;i<s.length();){
            if(s.charAt(i)=='['){
                int idx = i;
                while(i<s.length()&&s.charAt(i)!=']'){i++;}
                String[] sub = s.substring(idx+1, i).split(",");
                l.add(Arrays.asList(sub));
            } else {
                int idx = i;
                while(i<s.length()&&s.charAt(i)!='['){i++;}
                String[] sub = s.substring(idx, i).split(",");
                l.add(Arrays.asList(sub));
            }
            if(i<s.length()&&s.charAt(i)==']') i++;
        }
        // l.stream().forEach(System.out::println);
        List<String> res = new ArrayList<>();
        solve(0, l, res, new StringBuilder());
        Collections.sort(res);
        System.out.println(res);
    }
    private static void solve(int idx, List<List<String>> l, List<String> res, StringBuilder sb){
        if(idx==l.size()){
            res.add(sb.toString());
            return;
        }
        for(String s: l.get(idx)){
            sb.append(s);
            solve(idx+1, l, res, sb);
            sb.setLength(sb.length()-s.length());
        }
    }
}
