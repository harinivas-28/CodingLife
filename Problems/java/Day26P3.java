package Problems.java;
import java.util.*;
/*
 * An valid bracket arrangement is either "", "[" + A + "]", 
or A + B, where A and B are valid bracket arrangements 
and + represents string concatenation.

For example, "", "[]", "[[]]", and "[[][[]]]" are all valid bracket combinations.
A non-empty valid bracket arrangement is called authentic bracket string.
If an authentic bracket string s can be divided into s = A + B, where A and B 
are valid bracket strings and non-empty.

Consider the following basic partitioning of an authentic bracket string S, 
S = P1 + P2 +... + Pk, where Pi are basic authentic bracket string.

Return S after deleting the outermost brackets of each authentic string in S's partitioning.


INPUT FORMAT:
-------------
A String S, consists of '[' and ']' brackets only.

OUTPUT FORMAT:
--------------
Print S after deleting the outermost brackets.


SAMPLE INPUT-1:
---------------
[[]][[][]][]

SAMPLE OUTPUT-1:
----------------
[][][]


SAMPLE INPUT-2:
---------------
[[][]][[]][[][[]]]


SAMPLE OUTPUT-2:
----------------
[][][][][[]]

 */
public class Day26P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();){
            char c = s.charAt(i);
            int start = i+1;
            Stack<Character> stack = new Stack<>();
            stack.push(s.charAt(i++));
            while(i<s.length() && !stack.isEmpty()){
                if(c=='[') stack.push(c);
                else stack.pop();
                i++;
                if(i<s.length()) c = s.charAt(i);
            }
            res.append(s.substring(start, i-1));
        }
        System.out.println(res.toString());
    }
    /*public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int cnt1 = 0, cnt2 = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[') cnt1++;
            else cnt2++;
            if(cnt1==cnt2){
                res.append(s.substring(start+1, i));
                start = i+1;
            }
        }
        return res.toString();
    }*/
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int cnt = 0;
        for(char c: s.toCharArray()){
            if(c=='('){
                if(cnt>0) res.append(c);
                cnt++;
            } else {
                cnt--;
                if(cnt>0) res.append(c);
            }
        }
        return res.toString();
    }
}
// [[][]][[]][[][[]]]