package Coding.java;
import java.util.*;
public class Day49P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        Map<String, List<String>> map = new LinkedHashMap<>();
        for(String s: strs){
            String k = getHash(s);
            map.computeIfAbsent(k, x->new ArrayList<>()).add(s);
        }
        System.out.println(map.values());
    }
    private static String getHash(String s){
        int[] f = new int[26];
        for(char c: s.toCharArray()) f[c-'a']++;
        StringBuilder sb = new StringBuilder("^");
        for(int x: f) sb.append(x);
        sb.append("$");
        return sb.toString();
    }
}
