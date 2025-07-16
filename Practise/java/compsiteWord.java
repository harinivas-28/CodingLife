package Practise.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class compsiteWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String[] dic = sc.nextLine().split(" ");
        HashSet<String> set = new HashSet<>(Arrays.asList(dic));
        String s = sc.next();
        for(int i=1;i<=s.length();i++){
            String sub1 = s.substring(0, i);
            String sub2 = s.substring(i);
            if(set.contains(sub1) && set.contains(sub2)){
                System.out.println(sub1+" + "+sub2);
                flag = true;
            }
        }
        if(flag){
            System.out.println("Given string is composite word!");
        } else {
            System.out.println("Given String is not composite word!");
        }
        sc.close();
    }
}
