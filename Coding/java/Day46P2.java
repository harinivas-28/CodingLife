package Coding.java;
import java.util.*;

public class Day46P2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = sc.nextInt();
        String bn = find(n-1);
        System.out.println(bn);
        System.out.println(bn.charAt(p-1));
         System.out.println(Integer.bitCount(p-1)%2);
    }
    private static String find(int n){
        if(n==0) return "0";
        String prev = find(n-1);
        String preComp = comp(prev);
//        System.out.println(prev+"1"+preComp);
        return prev+"1"+preComp;
    }
    private static String comp(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                sb.append('0');
            } else {
                sb.append('1');
            }
        }
        return sb.toString();
    }
}
