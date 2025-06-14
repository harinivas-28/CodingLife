package PYQ;
import java.util.*;
// AMAZON Q
// OPTIMIZED IS BELOW
public class NoOfPalindromes {
    private static int expand(String s, int l, int r){
        int cnt = 0;
        while(l>=0 && r<s.length() && s.charAt(l--)==s.charAt(r++)){
            cnt++;
        }
        return cnt;
    }
    private static int expandForK(String s, int l, int r, int k){
        while(l>=0 && r<s.length() && s.charAt(l--)==s.charAt(r++)){
            if(r-l-1==k) return 1;
        }
        return 0;
    }
    private static int palinOfK(String s, int k){
        int res = 0;
        for(int i=0;i<s.length();i++){
            int odd = expandForK(s, i, i, k);
            int even = expandForK(s, i, i+1, k);
            res += odd+even;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0;
        for(int i=0;i<s.length();i++){
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);
            res += odd+even; // No of Palindromes of all lengths
        }
        int k = sc.nextInt();
        System.out.println(res);
        System.out.println(palinOfK(s, k)); // No of palindromes of length k
        System.out.println("OPTIMIZED: ");
        Optim.countPalin(s, k);
    }
    // OPTIMIZED
    static class Optim {
        static Map<Integer, Integer> map = new HashMap<>();
        private static void expand(String s, int l, int r){
            while(l>=0 && r<s.length() && s.charAt(l--)==s.charAt(r++)){
                map.put(r-l-1, map.getOrDefault(r-l-1, 0)+1);
            }
        }
        private static void countPalin(String s, int k){
            for(int i=0;i<s.length();i++){
                expand(s, i, i);
                expand(s, i, i+1);
            }
            int res = map.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("All lengths of palindromes: "+res);
            if(k>0){
//                System.out.println(map);
                System.out.println("Palindromes of length k: "+map.get(k));
            }
        }
    }
}
