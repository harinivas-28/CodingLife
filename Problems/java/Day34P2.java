package Problems.java;

import java.util.Scanner;

public class Day34P2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int m1 = Integer.parseInt(s[0].substring(3));
        int m2 = Integer.parseInt(s[1].substring(3));
        int h1 = Integer.parseInt(s[0].substring(0, 2));
        int h2 = Integer.parseInt(s[1].substring(0, 2));
        int st = h1*60+m1;
        int end = h2*60+m2;
        if(end<st) end+=24*60;
        while(st%15!=0) st++;
        while(end%15!=0) end--;
        int tot = (end-st)/15;
        System.out.println(tot);
        sc.close();
    }
}