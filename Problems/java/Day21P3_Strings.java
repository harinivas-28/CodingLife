package Problems.java;
import java.util.*;

/*
In the context of linguistic harmony, we define a "harmonious string" as a string where 
every alphabet it contains appears both in uppercase and lowercase forms. For instance, 
a string like "pqQpP" is harmonious because it has both 'P' and 'p' as well as 'Q' and 'q'. 
Conversely, a string like "pqP" is not harmonious as it fails to meet this condition, 
with 'q' present while 'Q' is absent.

You are given a string S, your task is  to return the longest harmonious substring in S.
If there are multiple answers meeting this criterion, you should return the one that appears 
earliest in the string. If there is no harmonious substring, you should return an empty string.

Input Format:
-------------------
A string S

Output Format:
-------------------
Prin the longest harmonious string.


Sample Input:
--------------
QcvcCcq

Sample Output:
---------------
cCc


Sample Input:
--------------
pqrs

Sample Output:
--------------
""
*/
public class Day21P3_Strings {
    public static String F(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String maxCurrent = "";
        // Check all substrings starting at index 0
        for (int j = 0; j < s.length(); j++) {
            String substr = s.substring(0, j + 1);
            if (isHarmonious(substr)) {
                if (substr.length() > maxCurrent.length()) {
                    maxCurrent = substr;
                }
            }
        }
        // Recursively check the rest of the string starting from index 1
        String restResult = F(s.substring(1));
        // Compare and keep the longer result
        if (restResult.length() > maxCurrent.length()) {
            maxCurrent = restResult;
        } else if (restResult.length() == maxCurrent.length() && !restResult.isEmpty()) {
            // If lengths are equal, choose the one that appears first
            int currentIndex = s.indexOf(maxCurrent);
            int restIndex = s.indexOf(restResult);
            if (restIndex < currentIndex) {
                maxCurrent = restResult;
            }
        }
        return maxCurrent;
    }
    private static boolean isHarmonious(String s) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower.add(c);
            } else {
                upper.add(Character.toLowerCase(c));
            }
        }
        for (char c : s.toCharArray()) {
            char lowerC = Character.toLowerCase(c);
            if (!lower.contains(lowerC) || !upper.contains(lowerC)) {
                return false;
            }
        }
        return true;
    }
    public static boolean harmonious(String s){
        int l[]=new int[26];
        int u[]=new int[26];
        for(char c:s.toCharArray()){
            if(Character.isUpperCase(c)){
                u[c-'A']++;
            }
            else l[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(u[i]==l[i]) continue;
            if(u[i]==0 && l[i]!=0 ) return false;
            if(u[i]!=0 && l[i]==0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = F(s);
        String res2 = slideWin(s);
        String res3 = longestNiceSubstring(s);
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String s1=s.substring(i,j+1);
                if(s1.length()>ans.length() && harmonious(s1)){
                    ans=s1;
                }
            }
        }
        System.out.print(ans);
        System.out.println(res+" "+res2);
        System.out.println(res3);
        sc.close();
    }
    public static String longestNiceSubstring(String s) {
        if(s.length()<2) return "";

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            char l = Character.toLowerCase(c);
            char u = Character.toUpperCase(c);
            if(s.indexOf(l)!=-1 && s.indexOf(u)!=-1){
                continue;
            }
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i+1));
            return left.length()>=right.length() ? left : right;
        }
        return s;
    }
    static String slideWin(String s){
        int maxLen = 0;
        int n = s.length();
        int start = 0;
        for(int i=0;i<n;i++){
            Map<Character, int[]> map = new HashMap<>();
            int inv = 0;
            for(int j=i;j<n;j++){
                char c = s.charAt(j);
                boolean isLower = Character.isLowerCase(c);
                char k = Character.toLowerCase(c);
                int[] counts = map.getOrDefault(k, new int[]{0, 0});
                int l = counts[0], u = counts[1];
                if(isLower){
                    counts[0]++;
                } else {
                    counts[1]++;
                }
                map.put(k, counts.clone());
                int prevCnt = (l>0) != (u>0) ? 1:0;
                int newCnt = (counts[0]>0) != (counts[1]>0) ? 1:0;
                inv += (newCnt - prevCnt);
                if(inv==0){
                    int currL = j-i+1;
                    if(currL>maxLen){
                        maxLen = currL;
                        start = i;
                    }
                }
            }
        }
        return maxLen==0 ? "" : s.substring(start, start+maxLen);
    }
}