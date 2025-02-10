package Coding.java;
import java.util.*;
public class Day1P2_SW {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int L = sc.nextInt();
        int res = L;
        int cnt = 0;
        for(int i=0;i<L;i++){
            if(s.charAt(i)=='B') cnt++;
        }
        res = Math.min(res, L-cnt);
        for(int i=L;i<s.length();i++){
            if(s.charAt(i-L)=='B') cnt--;
            if(s.charAt(i)=='B') cnt++;
            res = Math.min(res, L-cnt);
        }
        System.out.println(res);
        sc.close();
    }
}