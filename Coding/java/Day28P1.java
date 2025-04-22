package Coding.java;
import java.util.*;

public class Day28P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int c = sc.nextInt();
        sc.close();
        List<String> l = new ArrayList<>();
        for(int i=0;i<s.length();i+=(2*c)){
            int end = i+2*c;
            if(end>s.length()) end = s.length();
            l.add(s.substring(i, end));
        }
        // System.out.println(l);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<l.size();i++){
            StringBuilder t = new StringBuilder(l.get(i));
            if(t.length()>=c){
                res.append(new StringBuilder(t.substring(0, c)).reverse().toString());
                res.append(t.substring(c, t.length()));
            } else {
                res.append(new StringBuilder(t).reverse().toString());
            }
        }
        System.out.println(res.toString());
    }
}
