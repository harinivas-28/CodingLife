package Problems.java;

import java.util.*;

/*
Mr NOkayya is AI developer, He is given a dictionary, he want to implement a
an Word-Corrector application that checks user-word and corrects it.

For a given user-word, the Word-Corrector handles two types of validations:

1) If the user-word matches a word in the dictionary (case-insensitive),
then the user-word is returned with the matched word in the dictionary.
    Ex-1: dict = ["kmit"], user-word = "KmIt": word-corrector = "kmit"
	Ex-2: dict = ["Kmit"], user-word = "kmit": word-corrector = "Kmit"
	Ex-3: dict = ["kmit"], user-word = "kmit": word-corrector = "kmit"

2) If after replacing the vowels of the user-word with any vowel individually,
it matches a word in the dictionary (case-insensitive),
then the user-word is returned with the matched word in the dictionary.
	Ex-1: dict = ["KmIt"], user-word = "kmet": word-corrector = "KmIt"
	Ex-2: dict = ["KmIt"], user-word = "kmmit": word-corrector = "" (no match)
	Ex-3: dict = ["KmIt"], user-word = "kit": word-corrector = "" (no match)

In addition to the above conditions, the word-corrector app works
with the following precedence rules:
 - When the user-word exactly matches a word in the dictionary (case-sensitive),
    you should return the same word back.
 - When the user-word matches a word up to validation-1,
    you should return the first such match in the dictionary.
 - When the user-word matches a word up to validation-2,
    you should return the first such match in the dictionary.
 - If the user-word has no matches in the dictionary,
    you should return the empty string.

You are given some user-words[], return a list of words result[],
where result[i] is the corrected words by the Word-Corrector app for
user-word = user-words[i].


Input Format:
-------------
Line-1: comma separated strings, dictionary[].
Line-2: comma separated strings, user-words[].

Output Format:
--------------
List of corrected user-words[] by Word-Corrector app.


Sample Input-1:
---------------
LiTe,lite,bare,Bare
lite,Lite,LiTe,Bare,BARE,Bear,bear,leti,leet,leto

Sample Output-1:
----------------
[lite, LiTe, LiTe, Bare, bare, , , LiTe, , LiTe]


Sample Input-2:
---------------
kmit,ngit,kmec
KmOT,NHIT,KMIC

Sample Output-2:
----------------
[kmit, , kmec]

 */
public class Day42P2 {
    static final Set<Character> v = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] dic = sc.nextLine().split(",");
        String[] w = sc.nextLine().split(",");
        Set<String> m1 = new HashSet<>();
        Map<String, String> m2 = new HashMap<>();
        Map<String, String> m3 = new HashMap<>();
        for(String s: dic){
            m1.add(s);
            String t = s.toLowerCase();
            m2.putIfAbsent(t, s);
            String t1 = fun(t);
            m3.putIfAbsent(t1, s);
        }
        List<String> res = new ArrayList<>();
        for(String w_: w){
            if(m1.contains(w_)){
                res.add(w_);
                continue;
            }
            String t = w_.toLowerCase();
            if(m2.containsKey(t)){
                res.add(m2.get(t));
                continue;
            }
            String t1 = fun(t);
            res.add(m3.getOrDefault(t1, ""));
        }
        System.out.println(res);
    }
    private static String fun(String s){
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            sb.append(v.contains(c)?'*':c);
        }
        return sb.toString();
    }
}
