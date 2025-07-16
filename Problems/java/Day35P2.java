package Problems.java;
import java.util.*;
/*
 * Now a days, everyone is used to type the words in short-forms,
A short-form can be created by replacing non-intersected substrings 
and non-adjacent substrings with their respective lengths.

e.g., elite can be written as follows:
    - e3e (by replacing lit with 3), 
    - el2e (by replacing it with 2),  
	- 1l1t1 (by replacing e,i,e, with 1,1,1)
    - 3t1 (by replacing eli and e with 3 and 1), etc.
	and can't be written as follows:
	- 22e (by replacing el and it with 2 and 2)
	- 32 (by replacing eli and te with  3 and 2)

You will be given a word.
Your task is to find all possible short-forms of the given word, 
and print them as a list of lexicographic order.



Input Format:
-------------
A string W, the word.

Output Format:
--------------
Print the list of possible short-forms of W in lexographic order. 


Sample Input-1:
---------------
kmit

Sample Output-1:
----------------
[1m1t, 1m2, 1mi1, 1mit, 2i1, 2it, 3t, 4, k1i1, k1it, k2t, k3, km1t, km2, kmi1, kmit]


Sample Input-2:
---------------
cse

Sample Output-2:
----------------
[1s1, 1se, 2e, 3, c1e, c2, cs1, cse]

 */
public class Day35P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> res = new ArrayList<>();
        bt(s, 0, 0, res, new StringBuilder());
        Collections.sort(res);
        System.out.println(res);
        sc.close();
    }
    private static void bt(String s, int idx,int cnt, List<String> l,StringBuilder sb){
        int t = sb.length();
        if(idx==s.length()){
            if(cnt>0) sb.append(cnt);
            l.add(sb.toString());
            sb.setLength(t);
            return;
        }
        bt(s, idx+1, cnt+1, l, sb);
        if(cnt>0) sb.append(cnt);
        sb.append(s.charAt(idx));
        bt(s, idx+1, 0, l, sb);
        sb.setLength(t);
    }
}
