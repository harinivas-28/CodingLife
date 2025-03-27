package Coding.java;
import java.util.*;

// public class Day16P1_SW {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         String s = sc.next();
//         sw(s);
//         sc.close();
//         // int[] a = new int[26];
//         // int[] b = new int[26];
//         // int l = 0;
//         // StringBuilder sb = new StringBuilder();
//         // for(int r=0;r<s.length();r++){
//         //     char c = s.charAt(r);
//         //     char caps = c;
//         //     boolean change = false;
//         //     if(c-'a'>=0 && c-'a'<=(int)'z'){
//         //         a[c-'a']++;
//         //         caps = Character.toUpperCase(c);
//         //     } else {
//         //         b[c-'A']++;
//         //         caps = Character.toLowerCase(c);
//         //         change = true;
//         //     }
//         //     int st = r;
//         //     while(r<s.length() && change?a[caps-'a']>=1 && b[c-'A']>=1:a[c-'a']>=1&&b[caps-'A']>=1){
//         //         r++;
//         //         c = s.charAt(r);
//         //     }
//         //     if(sb.length()<(r-l+1)){
//         //         sb = new StringBuilder(s.substring(st, r+1));
//         //     }
//         // }
//         // System.out.println(sb.toString());
//     }
//     private static void sw(String s){
//         // QcvcCcq
//         Set<Character> set = new HashSet<>();
//         StringBuilder sb = new StringBuilder();
//         int n = s.length();
//         int l = 0;
//         for(int r=0;r<n;){
//             char c = s.charAt(r);
//             boolean f = false;
//             set.add(c);
//             while(r<n && set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))){
//                 r++;
//                 f = true;
//                 if(r<n){
//                     c = s.charAt(r);
//                     set.add(c);
//                 }
//             }
//             if(f && sb.length()<(r-l+1)){
//                 sb = new StringBuilder(s.substring(l, r+1<=n?r+1:r));
//             }
//             r++;
//         }
//         System.out.println(sb.toString());
//     }
// }
// public class Day16P1_SW {
//     private static StringBuilder res = new StringBuilder();
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         String s = sc.next();
//         for(int i=0;i<s.length();i++){
//             for(int j=i+1;j<s.length();j++){
//                 String sub = s.substring(i, j);
//                 isHarm(sub);
//             }
//         }
//         System.out.println(res.toString());
//         sc.close();
//     }
//     private static void isHarm(String sub){
//         Set<Character> set = new HashSet<>();
//         for(char c: sub.toCharArray()) set.add(c);
//         for(char c: sub.toCharArray()){
//             if(!set.contains(Character.toLowerCase(c)) || set.contains(Character.toUpperCase(c))){
//                 return;
//             }
//         }
//         if(res.length()<sub.length()){
//             res = new StringBuilder(sub);
//         }
//     }
// }
public class Day16P1_SW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        int l = sb.length();
        int steps = 0;
        while(l>1){
            if(sb.charAt(l-1)=='0'){
                sb.deleteCharAt(l-1);
            } else {
                int i = sb.length()-1;
                while(i>=0 && sb.charAt(i)!='0'){
                    sb.setCharAt(i, '0');
                    i--;
                }
                if(i<0){
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(i, '1');
                }
            }
            System.out.println(sb.toString());
            l = sb.length();
            steps++;
        }
        System.out.println(steps);
    }
}
